package com.lifeflow.app.ui.profile;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.lifeflow.app.R;
import com.lifeflow.app.data.api.ProfileService;
import com.lifeflow.app.data.api.SupabaseClient;
import com.lifeflow.app.data.model.UserProfile;
import com.lifeflow.app.utils.Constants;
import com.lifeflow.app.utils.NetworkUtils;
import com.lifeflow.app.utils.SessionManager;
import com.lifeflow.app.utils.ValidationUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Edit / update the current user's profile.
 * Pre-fills existing data received via Intent extras (Constants.EXTRA_PROFILE fields).
 */
public class EditProfileActivity extends AppCompatActivity {

    // Views
    private TextInputLayout tilFullName, tilPhone, tilCity, tilDistrict;
    private TextInputEditText etFullName, etPhone, etCity, etDistrict;
    private LinearLayout layoutBloodGroup, layoutAvailability;
    private MaterialButton btnTypeA, btnTypeB, btnTypeAB, btnTypeO;
    private MaterialButton btnRhPos, btnRhNeg;
    private TextView tvBloodGroupError;
    private SwitchMaterial switchAvailability;
    private MaterialButton btnSave;
    private FrameLayout loadingOverlay;

    // State
    private String selectedType = null;
    private String selectedRh   = null;
    private SessionManager sessionManager;
    private boolean isDonor = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        sessionManager = new SessionManager(this);
        isDonor = sessionManager.isDonor();

        bindViews();
        setListeners();
        prefillFromIntent();
        showDonorFields(isDonor);
    }

    // ------------------------------------------------------------------
    // View binding
    // ------------------------------------------------------------------

    private void bindViews() {
        tilFullName  = findViewById(R.id.tilFullName);
        tilPhone     = findViewById(R.id.tilPhone);
        tilCity      = findViewById(R.id.tilCity);
        tilDistrict  = findViewById(R.id.tilDistrict);

        etFullName  = findViewById(R.id.etFullName);
        etPhone     = findViewById(R.id.etPhone);
        etCity      = findViewById(R.id.etCity);
        etDistrict  = findViewById(R.id.etDistrict);

        layoutBloodGroup  = findViewById(R.id.layoutBloodGroup);
        layoutAvailability = findViewById(R.id.layoutAvailability);
        tvBloodGroupError = findViewById(R.id.tvBloodGroupError);
        switchAvailability = findViewById(R.id.switchAvailability);

        btnTypeA  = findViewById(R.id.btnTypeA);
        btnTypeB  = findViewById(R.id.btnTypeB);
        btnTypeAB = findViewById(R.id.btnTypeAB);
        btnTypeO  = findViewById(R.id.btnTypeO);
        btnRhPos  = findViewById(R.id.btnRhPos);
        btnRhNeg  = findViewById(R.id.btnRhNeg);

        btnSave        = findViewById(R.id.btnSave);
        loadingOverlay = findViewById(R.id.loadingOverlay);
    }

    // ------------------------------------------------------------------
    // Listeners
    // ------------------------------------------------------------------

    private void setListeners() {
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        btnTypeA.setOnClickListener(v  -> selectType("A",  btnTypeA));
        btnTypeB.setOnClickListener(v  -> selectType("B",  btnTypeB));
        btnTypeAB.setOnClickListener(v -> selectType("AB", btnTypeAB));
        btnTypeO.setOnClickListener(v  -> selectType("O",  btnTypeO));

        btnRhPos.setOnClickListener(v -> selectRh("+", btnRhPos));
        btnRhNeg.setOnClickListener(v -> selectRh("-", btnRhNeg));

        btnSave.setOnClickListener(v -> onSaveClicked());
    }

    // ------------------------------------------------------------------
    // Pre-fill from Intent extras
    // ------------------------------------------------------------------

    private void prefillFromIntent() {
        // Extras passed from ProfileFragment
        String name      = getIntent().getStringExtra("name");
        String phone     = getIntent().getStringExtra("phone");
        String city      = getIntent().getStringExtra("city");
        String district  = getIntent().getStringExtra("district");
        String bg        = getIntent().getStringExtra("blood_group");
        boolean avail    = getIntent().getBooleanExtra("is_available", true);

        if (name     != null) etFullName.setText(name);
        if (phone    != null) etPhone.setText(phone);
        if (city     != null) etCity.setText(city);
        if (district != null) etDistrict.setText(district);

        switchAvailability.setChecked(avail);

        // Pre-select blood group pills
        if (bg != null && bg.length() >= 2) {
            String type = bg.replace("+", "").replace("-", "");
            String rh   = bg.contains("+") ? "+" : "-";
            preselectType(type);
            preselectRh(rh);
        }
    }

    private void preselectType(String type) {
        switch (type) {
            case "A":  selectType("A",  btnTypeA);  break;
            case "B":  selectType("B",  btnTypeB);  break;
            case "AB": selectType("AB", btnTypeAB); break;
            case "O":  selectType("O",  btnTypeO);  break;
        }
    }

    private void preselectRh(String rh) {
        if ("+".equals(rh)) selectRh("+", btnRhPos);
        else                 selectRh("-", btnRhNeg);
    }

    // ------------------------------------------------------------------
    // Show / hide donor-only fields
    // ------------------------------------------------------------------

    private void showDonorFields(boolean show) {
        layoutBloodGroup.setVisibility(show ? View.VISIBLE : View.GONE);
        layoutAvailability.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    // ------------------------------------------------------------------
    // Blood group pill selection (same pattern as SignupActivity)
    // ------------------------------------------------------------------

    private void selectType(String type, MaterialButton btn) {
        selectedType = type;
        tvBloodGroupError.setVisibility(View.GONE);
        resetTypePills();
        setPillSelected(btn, true);
    }

    private void selectRh(String rh, MaterialButton btn) {
        selectedRh = rh;
        tvBloodGroupError.setVisibility(View.GONE);
        resetRhPills();
        setPillSelected(btn, true);
    }

    private void resetTypePills() {
        setPillSelected(btnTypeA, false);
        setPillSelected(btnTypeB, false);
        setPillSelected(btnTypeAB, false);
        setPillSelected(btnTypeO, false);
    }

    private void resetRhPills() {
        setPillSelected(btnRhPos, false);
        setPillSelected(btnRhNeg, false);
    }

    private void setPillSelected(MaterialButton btn, boolean selected) {
        if (selected) {
            btn.setBackgroundTintList(ColorStateList.valueOf(
                    ContextCompat.getColor(this, R.color.colorPrimary)));
            btn.setTextColor(ContextCompat.getColor(this, R.color.white));
            btn.setStrokeColor(ColorStateList.valueOf(
                    ContextCompat.getColor(this, R.color.colorPrimary)));
        } else {
            btn.setBackgroundTintList(ColorStateList.valueOf(
                    ContextCompat.getColor(this, android.R.color.transparent)));
            btn.setTextColor(ContextCompat.getColor(this, R.color.textPrimary));
            btn.setStrokeColor(ColorStateList.valueOf(
                    ContextCompat.getColor(this, R.color.dividerColor)));
        }
    }

    // ------------------------------------------------------------------
    // Validation
    // ------------------------------------------------------------------

    private boolean validateForm() {
        boolean valid = true;

        String name  = etFullName.getText() != null ? etFullName.getText().toString().trim() : "";
        String phone = etPhone.getText() != null ? etPhone.getText().toString().trim() : "";

        if (!ValidationUtils.isNotEmpty(name)) {
            tilFullName.setError(getString(R.string.error_name_required));
            valid = false;
        } else {
            tilFullName.setError(null);
        }

        if (!ValidationUtils.isValidPhone(phone)) {
            tilPhone.setError(phone.isEmpty()
                    ? getString(R.string.error_phone_required)
                    : getString(R.string.error_phone_invalid));
            valid = false;
        } else {
            tilPhone.setError(null);
        }

        if (isDonor && (selectedType == null || selectedRh == null)) {
            tvBloodGroupError.setVisibility(View.VISIBLE);
            valid = false;
        }

        return valid;
    }

    // ------------------------------------------------------------------
    // Save (PATCH profile)
    // ------------------------------------------------------------------

    private void onSaveClicked() {
        if (!validateForm()) return;
        if (!NetworkUtils.isNetworkAvailable(this)) {
            com.google.android.material.snackbar.Snackbar.make(
                    findViewById(android.R.id.content),
                    getString(R.string.error_no_internet),
                    com.google.android.material.snackbar.Snackbar.LENGTH_LONG).show();
            return;
        }

        String name      = etFullName.getText().toString().trim();
        String phone     = etPhone.getText().toString().trim();
        String city      = etCity.getText() != null ? etCity.getText().toString().trim() : "";
        String district  = etDistrict.getText() != null ? etDistrict.getText().toString().trim() : "";
        String bloodGroup = isDonor ? selectedType + selectedRh : null;
        boolean available = switchAvailability.isChecked();

        UserProfile patch = new UserProfile();
        patch.setFullName(name);
        patch.setPhone(phone);
        patch.setCity(city);
        patch.setDistrict(district);
        patch.setBloodGroup(bloodGroup);
        patch.setIsAvailable(available);

        showLoading(true);
        String userId = sessionManager.getUserId();
        ProfileService service = SupabaseClient.getProfileService(sessionManager);
        service.updateProfile("eq." + userId, patch)
                .enqueue(new Callback<List<UserProfile>>() {
                    @Override
                    public void onResponse(Call<List<UserProfile>> call,
                                           Response<List<UserProfile>> response) {
                        showLoading(false);
                        if (response.isSuccessful()) {
                            // Refresh cached name + blood group in session
                            sessionManager.saveUserDetails(name, bloodGroup);
                            Toast.makeText(EditProfileActivity.this,
                                    getString(R.string.msg_profile_saved),
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(EditProfileActivity.this,
                                    getString(R.string.error_generic),
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserProfile>> call, Throwable t) {
                        showLoading(false);
                        Toast.makeText(EditProfileActivity.this,
                                getString(R.string.error_network),
                                Toast.LENGTH_LONG).show();
                    }
                });
    }

    // ------------------------------------------------------------------
    // Loading state
    // ------------------------------------------------------------------

    private void showLoading(boolean show) {
        loadingOverlay.setVisibility(show ? View.VISIBLE : View.GONE);
        btnSave.setEnabled(!show);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
