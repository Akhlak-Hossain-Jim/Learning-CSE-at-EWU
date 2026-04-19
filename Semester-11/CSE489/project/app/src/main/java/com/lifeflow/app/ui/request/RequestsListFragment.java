package com.lifeflow.app.ui.request;

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

import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lifeflow.app.R;
import com.lifeflow.app.data.api.RequestService;
import com.lifeflow.app.data.api.SupabaseClient;
import com.lifeflow.app.data.model.BloodRequest;
import com.lifeflow.app.utils.NetworkUtils;
import com.lifeflow.app.utils.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Blood requests list screen.
 * Task 4.2.4: fetches active requests from API, populates RecyclerView.
 * Task 4.2.5: navigation between all 4 tabs is already wired in HomeActivity (Phase 2).
 * FAB is visible only to recipients.
 */
public class RequestsListFragment extends Fragment {

    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView rvRequests;
    private LinearLayout layoutEmpty;
    private ProgressBar progressBar;
    private FloatingActionButton fabCreateRequest;

    private RequestAdapter adapter;
    private SessionManager sessionManager;
    private TextInputEditText etSearch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_requests_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sessionManager = new SessionManager(requireContext());
        bindViews(view);
        setupRecyclerView();
        setupFab();
        setupSwipeRefresh();
        setupSearch();
        fetchRequests();
    }

    // ------------------------------------------------------------------
    // View binding
    // ------------------------------------------------------------------

    private void bindViews(View view) {
        swipeRefresh     = view.findViewById(R.id.swipeRefresh);
        rvRequests       = view.findViewById(R.id.rvRequests);
        layoutEmpty      = view.findViewById(R.id.layoutEmpty);
        progressBar      = view.findViewById(R.id.progressBar);
        fabCreateRequest = view.findViewById(R.id.fabCreateRequest);
        etSearch         = view.findViewById(R.id.etSearch);
    }

    private void setupSearch() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int st, int c, int a) {}
            @Override public void onTextChanged(CharSequence s, int st, int b, int c) {}
            @Override
            public void afterTextChanged(Editable s) {
                adapter.filter(s.toString());
                showEmptyState(adapter.isEmpty());
            }
        });
    }

    private void setupSwipeRefresh() {
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(this::fetchRequests);
    }

    // ------------------------------------------------------------------
    // RecyclerView
    // ------------------------------------------------------------------

    private void setupRecyclerView() {
        adapter = new RequestAdapter(new ArrayList<>());
        adapter.setOnRequestClickListener(request -> {
            Intent intent = new Intent(getActivity(), RequestDetailActivity.class);
            intent.putExtra(RequestDetailActivity.EXTRA_ID,          request.getId());
            intent.putExtra(RequestDetailActivity.EXTRA_BLOOD_GROUP,  request.getBloodGroupNeeded());
            intent.putExtra(RequestDetailActivity.EXTRA_UNITS,        request.getUnitsNeeded());
            intent.putExtra(RequestDetailActivity.EXTRA_HOSPITAL,     request.getHospitalName());
            intent.putExtra(RequestDetailActivity.EXTRA_URGENCY,      request.getUrgency());
            intent.putExtra(RequestDetailActivity.EXTRA_PHONE,        request.getContactPhone());
            intent.putExtra(RequestDetailActivity.EXTRA_NOTES,         request.getNotes());
            intent.putExtra(RequestDetailActivity.EXTRA_CREATED_AT,    request.getCreatedAt());
            intent.putExtra(RequestDetailActivity.EXTRA_REQUESTER_ID,  request.getRequesterId());
            startActivity(intent);
        });
        rvRequests.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRequests.setAdapter(adapter);
    }

    // ------------------------------------------------------------------
    // FAB — only recipients can create requests
    // ------------------------------------------------------------------

    private void setupFab() {
        if (sessionManager.isRecipient()) {
            fabCreateRequest.setVisibility(View.VISIBLE);
            fabCreateRequest.setOnClickListener(v ->
                    startActivity(new Intent(getActivity(), CreateRequestActivity.class)));
        } else {
            fabCreateRequest.setVisibility(View.GONE);
        }
    }

    // ------------------------------------------------------------------
    // API fetch
    // ------------------------------------------------------------------

    private void fetchRequests() {
        if (!NetworkUtils.isNetworkAvailable(requireContext())) {
            com.google.android.material.snackbar.Snackbar.make(
                    requireView(),
                    getString(R.string.error_no_internet),
                    com.google.android.material.snackbar.Snackbar.LENGTH_LONG).show();
            return;
        }
        showLoading(true);
        RequestService service = SupabaseClient.getRequestService(sessionManager);
        service.getActiveRequests("eq.false", "created_at.desc")
                .enqueue(new Callback<List<BloodRequest>>() {
                    @Override
                    public void onResponse(Call<List<BloodRequest>> call,
                                           Response<List<BloodRequest>> response) {
                        if (!isAdded()) return;
                        showLoading(false);
                        swipeRefresh.setRefreshing(false);
                        if (response.isSuccessful() && response.body() != null) {
                            List<BloodRequest> requests = response.body();
                            adapter.setData(requests);
                            // Re-apply any active search filter after reload
                            String currentQuery = etSearch.getText() != null
                                    ? etSearch.getText().toString() : "";
                            if (!currentQuery.isEmpty()) {
                                adapter.filter(currentQuery);
                            }
                            showEmptyState(adapter.isEmpty());
                        } else {
                            showEmptyState(true);
                            Toast.makeText(getContext(),
                                    getString(R.string.error_generic),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<BloodRequest>> call, Throwable t) {
                        if (!isAdded()) return;
                        showLoading(false);
                        swipeRefresh.setRefreshing(false);
                        showEmptyState(true);
                        Toast.makeText(getContext(),
                                getString(R.string.error_network),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // ------------------------------------------------------------------
    // Helpers
    // ------------------------------------------------------------------

    private void showLoading(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        rvRequests.setVisibility(show ? View.GONE : View.VISIBLE);
        if (show) layoutEmpty.setVisibility(View.GONE);
    }

    private void showEmptyState(boolean show) {
        layoutEmpty.setVisibility(show ? View.VISIBLE : View.GONE);
        rvRequests.setVisibility(show ? View.GONE : View.VISIBLE);
    }

    // ------------------------------------------------------------------
    // Refresh when returning from CreateRequestActivity
    // ------------------------------------------------------------------

    @Override
    public void onResume() {
        super.onResume();
        // Re-fetch so a freshly submitted request appears immediately
        fetchRequests();
    }
}
