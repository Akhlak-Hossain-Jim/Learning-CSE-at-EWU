package com.lifeflow.app.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.lifeflow.app.R;
import com.lifeflow.app.data.api.ProfileService;
import com.lifeflow.app.data.api.SupabaseClient;
import com.lifeflow.app.data.model.UserProfile;
import com.lifeflow.app.ui.auth.WelcomeActivity;
import com.lifeflow.app.ui.request.MyRequestsActivity;
import com.lifeflow.app.utils.Constants;
import com.lifeflow.app.utils.NetworkUtils;
import com.lifeflow.app.utils.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Profile tab — shows current user's info, Edit Profile, My Requests, and Logout.
 * Task 5.1.2: fetch profile from API and populate all views.
 * Task 5.1.3: "My Requests" button wired for recipients.
 */
public class ProfileFragment extends Fragment {

    private TextView tvAvatar, tvName, tvRoleBadge;
    private TextView tvEmail, tvPhone;
    private TextView tvBloodGroup, tvLocation, tvAvailability;
    private MaterialCardView cardDonorInfo;
    private MaterialButton btnEditProfile, btnDonationInfo, btnDonateMoney, btnMyRequests, btnLogout;
    private FrameLayout loadingOverlay;

    private SessionManager sessionManager;
    private UserProfile cachedProfile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sessionManager = new SessionManager(requireContext());
        bindViews(view);
        setupButtons();
        fetchProfile();
    }

    @Override
    public void onResume() {
        super.onResume();
        // Re-fetch after returning from EditProfileActivity so changes are reflected
        fetchProfile();
    }

    // ------------------------------------------------------------------
    // View binding
    // ------------------------------------------------------------------

    private void bindViews(View view) {
        tvAvatar       = view.findViewById(R.id.tvAvatar);
        tvName         = view.findViewById(R.id.tvName);
        tvRoleBadge    = view.findViewById(R.id.tvRoleBadge);
        tvEmail        = view.findViewById(R.id.tvEmail);
        tvPhone        = view.findViewById(R.id.tvPhone);
        tvBloodGroup   = view.findViewById(R.id.tvBloodGroup);
        tvLocation     = view.findViewById(R.id.tvLocation);
        tvAvailability = view.findViewById(R.id.tvAvailability);
        cardDonorInfo  = view.findViewById(R.id.cardDonorInfo);
        btnEditProfile  = view.findViewById(R.id.btnEditProfile);
        btnDonationInfo = view.findViewById(R.id.btnDonationInfo);
        btnDonateMoney  = view.findViewById(R.id.btnDonateMoney);
        btnMyRequests   = view.findViewById(R.id.btnMyRequests);
        btnLogout       = view.findViewById(R.id.btnLogout);
        loadingOverlay = view.findViewById(R.id.loadingOverlay);
    }

    // ------------------------------------------------------------------
    // Button wiring
    // ------------------------------------------------------------------

    private void setupButtons() {
        btnEditProfile.setOnClickListener(v -> openEditProfile());
        btnDonationInfo.setOnClickListener(v ->
                startActivity(new Intent(getActivity(), DonationInfoActivity.class)));
        btnDonateMoney.setOnClickListener(v ->
                startActivity(new Intent(getActivity(), DonateMoneyActivity.class)));
        btnLogout.setOnClickListener(v -> logout());

        if (sessionManager.isRecipient()) {
            btnMyRequests.setVisibility(View.VISIBLE);
            btnMyRequests.setOnClickListener(v -> openMyRequests());
        } else {
            btnMyRequests.setVisibility(View.GONE);
        }
    }

    // ------------------------------------------------------------------
    // API fetch
    // ------------------------------------------------------------------

    private void fetchProfile() {
        if (!NetworkUtils.isNetworkAvailable(requireContext())) {
            com.google.android.material.snackbar.Snackbar.make(
                    requireView(),
                    getString(R.string.error_no_internet),
                    com.google.android.material.snackbar.Snackbar.LENGTH_LONG).show();
            return;
        }
        showLoading(true);
        String userId = sessionManager.getUserId();
        ProfileService service = SupabaseClient.getProfileService(sessionManager);
        service.getProfileById("eq." + userId)
                .enqueue(new Callback<List<UserProfile>>() {
                    @Override
                    public void onResponse(Call<List<UserProfile>> call,
                                           Response<List<UserProfile>> response) {
                        if (!isAdded()) return;
                        showLoading(false);
                        if (response.isSuccessful() && response.body() != null
                                && !response.body().isEmpty()) {
                            cachedProfile = response.body().get(0);
                            populateViews(cachedProfile);
                        } else {
                            Toast.makeText(getContext(),
                                    getString(R.string.error_generic),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserProfile>> call, Throwable t) {
                        if (!isAdded()) return;
                        showLoading(false);
                        Toast.makeText(getContext(),
                                getString(R.string.error_network),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // ------------------------------------------------------------------
    // Populate views from profile
    // ------------------------------------------------------------------

    private void populateViews(UserProfile p) {
        // Avatar: first letter of name (uppercase)
        String name = p.getFullName() != null ? p.getFullName() : "";
        tvAvatar.setText(name.isEmpty() ? "?" : String.valueOf(name.charAt(0)).toUpperCase());

        tvName.setText(name.isEmpty() ? "—" : name);

        // Role badge
        boolean isDonor = Constants.ROLE_DONOR.equals(p.getRole());
        tvRoleBadge.setText(isDonor
                ? getString(R.string.label_donor_badge)
                : getString(R.string.label_recipient_badge));

        // Contact
        tvEmail.setText(p.getEmail() != null ? p.getEmail() : "—");
        tvPhone.setText(p.getPhone() != null && !p.getPhone().isEmpty() ? p.getPhone() : "—");

        // Donor-only card
        if (isDonor) {
            cardDonorInfo.setVisibility(View.VISIBLE);

            tvBloodGroup.setText(
                    p.getBloodGroup() != null ? p.getBloodGroup() : "—");

            tvLocation.setText(p.getLocationDisplay());

            if (p.getIsAvailable()) {
                tvAvailability.setText(getString(R.string.label_available));
                tvAvailability.setTextColor(
                        requireContext().getColor(R.color.colorSuccess));
            } else {
                tvAvailability.setText(getString(R.string.label_unavailable));
                tvAvailability.setTextColor(
                        requireContext().getColor(R.color.colorUnavailable));
            }
        } else {
            cardDonorInfo.setVisibility(View.GONE);
        }
    }

    // ------------------------------------------------------------------
    // Navigation helpers
    // ------------------------------------------------------------------

    private void openEditProfile() {
        Intent intent = new Intent(getActivity(), EditProfileActivity.class);
        if (cachedProfile != null) {
            intent.putExtra("name",         cachedProfile.getFullName());
            intent.putExtra("phone",        cachedProfile.getPhone());
            intent.putExtra("city",         cachedProfile.getCity());
            intent.putExtra("district",     cachedProfile.getDistrict());
            intent.putExtra("blood_group",  cachedProfile.getBloodGroup());
            intent.putExtra("is_available", cachedProfile.getIsAvailable());
        }
        startActivity(intent);
    }

    private void openMyRequests() {
        startActivity(new Intent(getActivity(), MyRequestsActivity.class));
    }

    private void logout() {
        sessionManager.clearSession();
        Intent intent = new Intent(getActivity(), WelcomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    // ------------------------------------------------------------------
    // Loading overlay
    // ------------------------------------------------------------------

    private void showLoading(boolean show) {
        loadingOverlay.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
