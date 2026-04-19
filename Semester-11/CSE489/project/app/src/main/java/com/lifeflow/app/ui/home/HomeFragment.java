package com.lifeflow.app.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.lifeflow.app.R;
import com.lifeflow.app.data.api.SupabaseClient;
import com.lifeflow.app.data.api.ProfileService;
import com.lifeflow.app.data.api.RequestService;
import com.lifeflow.app.data.model.BloodRequest;
import com.lifeflow.app.data.model.UserProfile;
import com.lifeflow.app.ui.request.CreateRequestActivity;
import com.lifeflow.app.utils.Constants;
import com.lifeflow.app.utils.NetworkUtils;
import com.lifeflow.app.utils.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Home dashboard fragment.
 * Displays greeting, blood type, donor/request stats, quick actions, recent requests.
 */
public class HomeFragment extends Fragment {

    private TextView tvGreeting, tvAvatar, tvBloodType, tvDonorCount;
    private MaterialCardView cardDonateDonors, cardRequestBlood;
    private TextView tvSeeAll;
    private RecyclerView rvRecentRequests;
    private LinearLayout layoutEmptyRequests;
    private ProgressBar progressStats;

    private SessionManager sessionManager;
    private HomeRequestPreviewAdapter previewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sessionManager = new SessionManager(requireContext());
        bindViews(view);
        populateGreeting();
        setupQuickActions();
        setupRecentRequests();
        fetchStats();
        fetchRecentRequests();
    }

    // ------------------------------------------------------------------
    // View binding
    // ------------------------------------------------------------------

    private void bindViews(View view) {
        tvGreeting          = view.findViewById(R.id.tvGreeting);
        tvAvatar            = view.findViewById(R.id.tvAvatar);
        tvBloodType         = view.findViewById(R.id.tvBloodType);
        tvDonorCount        = view.findViewById(R.id.tvDonorCount);
        cardDonateDonors    = view.findViewById(R.id.cardDonateDonors);
        cardRequestBlood    = view.findViewById(R.id.cardRequestBlood);
        tvSeeAll            = view.findViewById(R.id.tvSeeAll);
        rvRecentRequests    = view.findViewById(R.id.rvRecentRequests);
        layoutEmptyRequests = view.findViewById(R.id.layoutEmptyRequests);
        progressStats       = view.findViewById(R.id.progressStats);
    }

    // ------------------------------------------------------------------
    // Greeting + blood type from session
    // ------------------------------------------------------------------

    private void populateGreeting() {
        String name = sessionManager.getUserName();
        if (name != null && !name.isEmpty()) {
            String firstName = name.split(" ")[0];
            tvGreeting.setText(getString(R.string.greeting_prefix, firstName));
            tvAvatar.setText(String.valueOf(firstName.charAt(0)).toUpperCase());
        }

        String bloodGroup = sessionManager.getBloodGroup();
        if (bloodGroup != null && !bloodGroup.isEmpty()) {
            tvBloodType.setText(bloodGroup);
        }
    }

    // ------------------------------------------------------------------
    // Quick action cards
    // ------------------------------------------------------------------

    private void setupQuickActions() {
        // "Donate Blood" → switch to Donors tab
        cardDonateDonors.setOnClickListener(v -> {
            if (getActivity() instanceof HomeActivity) {
                ((HomeActivity) getActivity()).switchToTab(R.id.nav_donors);
            }
        });

        // "Request Blood" → open CreateRequestActivity
        cardRequestBlood.setOnClickListener(v ->
                startActivity(new Intent(getActivity(), CreateRequestActivity.class)));

        // "See All >" → switch to Requests tab
        tvSeeAll.setOnClickListener(v -> {
            if (getActivity() instanceof HomeActivity) {
                ((HomeActivity) getActivity()).switchToTab(R.id.nav_requests);
            }
        });
    }

    // ------------------------------------------------------------------
    // Recent requests RecyclerView setup
    // ------------------------------------------------------------------

    private void setupRecentRequests() {
        previewAdapter = new HomeRequestPreviewAdapter(new ArrayList<>());
        rvRecentRequests.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRecentRequests.setAdapter(previewAdapter);
        rvRecentRequests.setNestedScrollingEnabled(false);
    }

    // ------------------------------------------------------------------
    // API: fetch donor count + active request count (task 2.2.3)
    // ------------------------------------------------------------------

    private void fetchStats() {
        if (!NetworkUtils.isNetworkAvailable(requireContext())) {
            progressStats.setVisibility(View.GONE);
            return;
        }
        progressStats.setVisibility(View.VISIBLE);

        ProfileService profileService = SupabaseClient.getProfileService(sessionManager);
        profileService.getDonorCount("eq." + Constants.ROLE_DONOR, "eq.true")
                .enqueue(new Callback<List<UserProfile>>() {
                    @Override
                    public void onResponse(Call<List<UserProfile>> call,
                                           Response<List<UserProfile>> response) {
                        progressStats.setVisibility(View.GONE);
                        if (response.isSuccessful()) {
                            int count = parseTotalCount(
                                    response.headers().get("Content-Range"),
                                    response.body() != null ? response.body().size() : 0
                            );
                            if (isAdded()) tvDonorCount.setText(String.valueOf(count));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserProfile>> call, Throwable t) {
                        progressStats.setVisibility(View.GONE);
                    }
                });
    }

    // ------------------------------------------------------------------
    // API: fetch 3 most recent active requests for the preview list
    // ------------------------------------------------------------------

    private void fetchRecentRequests() {
        if (!NetworkUtils.isNetworkAvailable(requireContext())) return;
        RequestService requestService = SupabaseClient.getRequestService(sessionManager);
        requestService.getActiveRequests("eq.false", "created_at.desc")
                .enqueue(new Callback<List<BloodRequest>>() {
                    @Override
                    public void onResponse(Call<List<BloodRequest>> call,
                                           Response<List<BloodRequest>> response) {
                        if (!isAdded()) return;
                        if (response.isSuccessful() && response.body() != null) {
                            List<BloodRequest> all = response.body();
                            // Show at most 3 items on the home dashboard
                            List<BloodRequest> preview = all.size() > 3
                                    ? all.subList(0, 3)
                                    : all;
                            if (preview.isEmpty()) {
                                layoutEmptyRequests.setVisibility(View.VISIBLE);
                                rvRecentRequests.setVisibility(View.GONE);
                            } else {
                                layoutEmptyRequests.setVisibility(View.GONE);
                                rvRecentRequests.setVisibility(View.VISIBLE);
                                previewAdapter.updateData(preview);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<BloodRequest>> call, Throwable t) {
                        // Silently fail — home screen degrades gracefully
                    }
                });
    }

    // ------------------------------------------------------------------
    // Helpers
    // ------------------------------------------------------------------

    /**
     * Parses the total count from a PostgREST Content-Range header.
     * Format: "0-49/150"  → returns 150
     * Falls back to listSize if header is missing or malformed.
     */
    private int parseTotalCount(@Nullable String contentRange, int listSize) {
        if (contentRange == null) return listSize;
        try {
            return Integer.parseInt(contentRange.split("/")[1]);
        } catch (Exception e) {
            return listSize;
        }
    }

    // ------------------------------------------------------------------
    // Inner adapter for recent request preview cards
    // ------------------------------------------------------------------

    private static class HomeRequestPreviewAdapter
            extends RecyclerView.Adapter<HomeRequestPreviewAdapter.ViewHolder> {

        private List<BloodRequest> items;

        HomeRequestPreviewAdapter(List<BloodRequest> items) {
            this.items = items;
        }

        void updateData(List<BloodRequest> newItems) {
            this.items = newItems;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_request_preview, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            BloodRequest req = items.get(position);
            holder.tvBloodGroup.setText(req.getBloodGroupNeeded());
            holder.tvHospital.setText(
                    req.getHospitalName() != null && !req.getHospitalName().isEmpty()
                            ? req.getHospitalName()
                            : "Unknown Hospital");
            holder.tvUnits.setText(
                    holder.itemView.getContext()
                            .getString(R.string.label_units_format, req.getUnitsNeeded()));

            // Urgency tag text + background
            applyUrgencyTag(holder, req.getUrgency());
        }

        private void applyUrgencyTag(ViewHolder holder, String urgency) {
            if (urgency == null) urgency = Constants.URGENCY_NORMAL;
            switch (urgency) {
                case Constants.URGENCY_CRITICAL:
                    holder.tvUrgency.setText(R.string.urgency_critical);
                    holder.tvUrgency.setBackgroundResource(R.drawable.bg_tag_critical);
                    holder.tvUrgency.setTextColor(
                            holder.itemView.getContext().getColor(R.color.colorCritical));
                    break;
                case Constants.URGENCY_URGENT:
                    holder.tvUrgency.setText(R.string.urgency_urgent);
                    holder.tvUrgency.setBackgroundResource(R.drawable.bg_tag_urgent);
                    holder.tvUrgency.setTextColor(
                            holder.itemView.getContext().getColor(R.color.colorUrgent));
                    break;
                default:
                    holder.tvUrgency.setText(R.string.urgency_normal);
                    holder.tvUrgency.setBackgroundResource(R.drawable.bg_tag_normal);
                    holder.tvUrgency.setTextColor(
                            holder.itemView.getContext().getColor(R.color.colorNormal));
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvBloodGroup, tvHospital, tvUnits, tvUrgency;

            ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvBloodGroup = itemView.findViewById(R.id.tvBloodGroup);
                tvHospital   = itemView.findViewById(R.id.tvHospital);
                tvUnits      = itemView.findViewById(R.id.tvUnits);
                tvUrgency    = itemView.findViewById(R.id.tvUrgency);
            }
        }
    }
}
