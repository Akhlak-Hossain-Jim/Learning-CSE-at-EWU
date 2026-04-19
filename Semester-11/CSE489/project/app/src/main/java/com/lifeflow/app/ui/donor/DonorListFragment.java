package com.lifeflow.app.ui.donor;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.lifeflow.app.R;
import com.lifeflow.app.data.api.ProfileService;
import com.lifeflow.app.data.api.SupabaseClient;
import com.lifeflow.app.data.model.UserProfile;
import com.lifeflow.app.utils.Constants;
import com.lifeflow.app.utils.NetworkUtils;
import com.lifeflow.app.utils.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Donor list screen with search + blood group filter chips.
 * Tasks 3.2.4 (fetch), 3.3.1 (search), 3.3.2 (chip filter), 3.3.3 (combined filter).
 */
public class DonorListFragment extends Fragment {

    private TextInputEditText etSearch;
    private ChipGroup chipGroupBloodFilter;
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView rvDonors;
    private LinearLayout layoutEmpty;
    private ProgressBar progressBar;

    private DonorAdapter adapter;
    private SessionManager sessionManager;

    private String activeSearchQuery  = "";
    private String activeBloodFilter  = "";  // empty = no filter

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_donor_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sessionManager = new SessionManager(requireContext());
        bindViews(view);
        setupRecyclerView();
        setupSearch();
        setupChipFilter();
        setupSwipeRefresh();
        fetchDonors();
    }

    // ------------------------------------------------------------------
    // View binding
    // ------------------------------------------------------------------

    private void bindViews(View view) {
        etSearch             = view.findViewById(R.id.etSearch);
        chipGroupBloodFilter = view.findViewById(R.id.chipGroupBloodFilter);
        swipeRefresh         = view.findViewById(R.id.swipeRefresh);
        rvDonors             = view.findViewById(R.id.rvDonors);
        layoutEmpty          = view.findViewById(R.id.layoutEmpty);
        progressBar          = view.findViewById(R.id.progressBar);
    }

    private void setupSwipeRefresh() {
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(() -> {
            activeSearchQuery = "";
            activeBloodFilter = "";
            etSearch.setText("");
            fetchDonors();
        });
    }

    // ------------------------------------------------------------------
    // RecyclerView setup
    // ------------------------------------------------------------------

    private void setupRecyclerView() {
        adapter = new DonorAdapter(new ArrayList<>(), donor -> {
            // Task 3.4.3 — open DonorDetailActivity with donor's ID
            Intent intent = new Intent(getActivity(), DonorDetailActivity.class);
            intent.putExtra(Constants.EXTRA_DONOR_ID, donor.getId());
            startActivity(intent);
        });
        rvDonors.setLayoutManager(new LinearLayoutManager(getContext()));
        rvDonors.setAdapter(adapter);
    }

    // ------------------------------------------------------------------
    // Task 3.3.1 — client-side search
    // ------------------------------------------------------------------

    private void setupSearch() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                activeSearchQuery = s != null ? s.toString().trim().toLowerCase() : "";
                applyFilters();
            }
        });
    }

    // ------------------------------------------------------------------
    // Task 3.3.2 — blood group chip filter (single-select)
    // ------------------------------------------------------------------

    private void setupChipFilter() {
        chipGroupBloodFilter.setOnCheckedStateChangeListener((group, checkedIds) -> {
            if (checkedIds.isEmpty()) {
                activeBloodFilter = "";
            } else {
                Chip chip = group.findViewById(checkedIds.get(0));
                if (chip != null) {
                    String chipText = chip.getText().toString();
                    // "All" chip = no filter
                    activeBloodFilter = chipText.equals(getString(R.string.filter_all))
                            ? "" : chipText;
                }
            }
            applyFilters();
        });
    }

    // ------------------------------------------------------------------
    // Task 3.3.3 — combined search + filter
    // ------------------------------------------------------------------

    private void applyFilters() {
        List<UserProfile> source = adapter.getFullList();
        List<UserProfile> result = new ArrayList<>();

        for (UserProfile donor : source) {
            boolean matchesSearch = activeSearchQuery.isEmpty()
                    || (donor.getFullName() != null
                        && donor.getFullName().toLowerCase().contains(activeSearchQuery))
                    || (donor.getCity() != null
                        && donor.getCity().toLowerCase().contains(activeSearchQuery));

            // Normalise stored blood group: database stores "A+" / "A-"
            // chips show "A+" / "A−" (minus sign may vary); compare caseless
            boolean matchesChip = activeBloodFilter.isEmpty()
                    || bloodGroupMatches(donor.getBloodGroup(), activeBloodFilter);

            if (matchesSearch && matchesChip) result.add(donor);
        }

        adapter.submitFilteredList(result);
        showEmptyState(result.isEmpty());
    }

    /** Tolerates "−" (Unicode minus) vs "-" (hyphen) differences in blood group strings. */
    private boolean bloodGroupMatches(String stored, String filter) {
        if (stored == null) return false;
        String normalStored = stored.replace("−", "-");
        String normalFilter = filter.replace("−", "-");
        return normalStored.equalsIgnoreCase(normalFilter);
    }

    // ------------------------------------------------------------------
    // Task 3.2.4 — fetch donors from API
    // ------------------------------------------------------------------

    private void fetchDonors() {
        if (!NetworkUtils.isNetworkAvailable(requireContext())) {
            com.google.android.material.snackbar.Snackbar.make(
                    requireView(),
                    getString(R.string.error_no_internet),
                    com.google.android.material.snackbar.Snackbar.LENGTH_LONG).show();
            return;
        }
        showLoading(true);
        ProfileService service = SupabaseClient.getProfileService(sessionManager);
        service.getDonors(
                "eq." + Constants.ROLE_DONOR,
                "eq.true",
                "created_at.desc"
        ).enqueue(new Callback<List<UserProfile>>() {
            @Override
            public void onResponse(Call<List<UserProfile>> call,
                                   Response<List<UserProfile>> response) {
                if (!isAdded()) return;
                showLoading(false);
                swipeRefresh.setRefreshing(false);
                if (response.isSuccessful() && response.body() != null) {
                    List<UserProfile> donors = response.body();
                    adapter.setData(donors);
                    showEmptyState(donors.isEmpty());
                } else {
                    showEmptyState(true);
                    Toast.makeText(getContext(),
                            getString(R.string.error_generic), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<UserProfile>> call, Throwable t) {
                if (!isAdded()) return;
                showLoading(false);
                swipeRefresh.setRefreshing(false);
                showEmptyState(true);
                Toast.makeText(getContext(),
                        getString(R.string.error_network), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // ------------------------------------------------------------------
    // Helpers
    // ------------------------------------------------------------------

    private void showLoading(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        rvDonors.setVisibility(show ? View.GONE : View.VISIBLE);
        if (show) layoutEmpty.setVisibility(View.GONE);
    }

    private void showEmptyState(boolean show) {
        layoutEmpty.setVisibility(show ? View.VISIBLE : View.GONE);
        rvDonors.setVisibility(show ? View.GONE : View.VISIBLE);
    }
}
