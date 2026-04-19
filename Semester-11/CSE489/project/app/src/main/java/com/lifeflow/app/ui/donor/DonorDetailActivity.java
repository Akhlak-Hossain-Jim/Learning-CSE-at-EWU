package com.lifeflow.app.ui.donor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.lifeflow.app.R;
import com.lifeflow.app.data.api.ProfileService;
import com.lifeflow.app.data.api.SupabaseClient;
import com.lifeflow.app.data.model.UserProfile;
import com.lifeflow.app.utils.Constants;
import com.lifeflow.app.utils.NetworkUtils;
import com.lifeflow.app.utils.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Shows a donor's full profile.
 * Receives donor ID via Intent extra Constants.EXTRA_DONOR_ID.
 * "Call Donor" button triggers an ACTION_DIAL intent.
 */
public class DonorDetailActivity extends AppCompatActivity {

    private TextView tvBloodGroupLarge, tvName, tvAvailabilityStatus;
    private TextView tvPhone, tvEmail, tvLocation;
    private MaterialButton btnCallDonor;
    private FrameLayout loadingOverlay;

    private String donorPhone = null;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_detail);

        sessionManager = new SessionManager(this);
        bindViews();

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
        btnCallDonor.setOnClickListener(v -> callDonor());

        String donorId = getIntent().getStringExtra(Constants.EXTRA_DONOR_ID);
        if (donorId != null) {
            fetchProfile(donorId);
        } else {
            Toast.makeText(this, getString(R.string.error_generic), Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    // ------------------------------------------------------------------
    // View binding
    // ------------------------------------------------------------------

    private void bindViews() {
        tvBloodGroupLarge    = findViewById(R.id.tvBloodGroupLarge);
        tvName               = findViewById(R.id.tvName);
        tvAvailabilityStatus = findViewById(R.id.tvAvailabilityStatus);
        tvPhone              = findViewById(R.id.tvPhone);
        tvEmail              = findViewById(R.id.tvEmail);
        tvLocation           = findViewById(R.id.tvLocation);
        btnCallDonor         = findViewById(R.id.btnCallDonor);
        loadingOverlay       = findViewById(R.id.loadingOverlay);
    }

    // ------------------------------------------------------------------
    // Fetch donor profile
    // ------------------------------------------------------------------

    private void fetchProfile(String donorId) {
        if (!NetworkUtils.isNetworkAvailable(this)) {
            com.google.android.material.snackbar.Snackbar.make(
                    findViewById(android.R.id.content),
                    getString(R.string.error_no_internet),
                    com.google.android.material.snackbar.Snackbar.LENGTH_LONG).show();
            return;
        }
        showLoading(true);
        ProfileService service = SupabaseClient.getProfileService(sessionManager);
        service.getProfileById("eq." + donorId)
                .enqueue(new Callback<List<UserProfile>>() {
                    @Override
                    public void onResponse(Call<List<UserProfile>> call,
                                           Response<List<UserProfile>> response) {
                        showLoading(false);
                        if (response.isSuccessful()
                                && response.body() != null
                                && !response.body().isEmpty()) {
                            populateViews(response.body().get(0));
                        } else {
                            Toast.makeText(DonorDetailActivity.this,
                                    getString(R.string.error_generic), Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserProfile>> call, Throwable t) {
                        showLoading(false);
                        Toast.makeText(DonorDetailActivity.this,
                                getString(R.string.error_network), Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }

    // ------------------------------------------------------------------
    // Populate views from profile
    // ------------------------------------------------------------------

    private void populateViews(UserProfile donor) {
        donorPhone = donor.getPhone();

        tvBloodGroupLarge.setText(
                donor.getBloodGroup() != null ? donor.getBloodGroup() : "?");
        tvName.setText(
                donor.getFullName() != null ? donor.getFullName() : "—");
        tvPhone.setText(
                donor.getPhone() != null ? donor.getPhone() : "—");
        if (donorPhone != null && !donorPhone.isEmpty()) {
            tvPhone.setClickable(true);
            tvPhone.setPaintFlags(tvPhone.getPaintFlags() | android.graphics.Paint.UNDERLINE_TEXT_FLAG);
            tvPhone.setOnClickListener(v -> callDonor());
        }
        tvEmail.setText(
                donor.getEmail() != null ? donor.getEmail() : "—");
        tvLocation.setText(donor.getLocationDisplay());

        // Availability pill
        boolean available = donor.getIsAvailable();
        tvAvailabilityStatus.setText(
                available ? getString(R.string.label_available)
                          : getString(R.string.label_unavailable));
        tvAvailabilityStatus.setTextColor(getColor(
                available ? R.color.colorSuccess : R.color.colorUnavailable));
        tvAvailabilityStatus.setBackgroundResource(
                available ? R.drawable.bg_tag_normal : R.drawable.bg_badge_rounded);

        // Disable call button if no phone
        if (donorPhone == null || donorPhone.isEmpty()) {
            btnCallDonor.setEnabled(false);
            btnCallDonor.setAlpha(0.5f);
        }
    }

    // ------------------------------------------------------------------
    // Call donor via dialer
    // ------------------------------------------------------------------

    private void callDonor() {
        if (donorPhone == null || donorPhone.isEmpty()) return;
        Intent dialIntent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + donorPhone));
        startActivity(dialIntent);
    }

    // ------------------------------------------------------------------
    // Loading state
    // ------------------------------------------------------------------

    private void showLoading(boolean show) {
        loadingOverlay.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
