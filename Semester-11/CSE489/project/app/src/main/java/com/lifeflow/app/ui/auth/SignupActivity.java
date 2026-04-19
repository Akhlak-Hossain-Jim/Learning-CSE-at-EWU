package com.lifeflow.app.ui.auth;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.lifeflow.app.R;
import com.lifeflow.app.data.api.SupabaseClient;
import com.lifeflow.app.data.api.AuthService;
import com.lifeflow.app.data.api.ProfileService;
import com.lifeflow.app.data.model.AuthRequest;
import com.lifeflow.app.data.model.AuthResponse;
import com.lifeflow.app.data.model.UserProfile;
import com.lifeflow.app.ui.home.HomeActivity;
import com.lifeflow.app.utils.Constants;
import com.lifeflow.app.utils.NetworkUtils;
import com.lifeflow.app.utils.SessionManager;
import com.lifeflow.app.utils.ValidationUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Handles new user registration.
 * Flow: validate form → signup (GoTrue) → insert profile → navigate home.
 */
public class SignupActivity extends AppCompatActivity {

    // Views
    private TextInputLayout tilFullName, tilEmail, tilPassword, tilConfirmPassword, tilPhone;
    private TextInputEditText etFullName, etEmail, etPassword, etConfirmPassword, etPhone;
    private MaterialButton btnRoleDonor, btnRoleRecipient;
    private MaterialButton btnTypeA, btnTypeB, btnTypeAB, btnTypeO;
    private MaterialButton btnRhPos, btnRhNeg;
    private View layoutBloodGroup;
    private TextView tvBloodGroupError;
    private MaterialButton btnSignup;
    private TextView tvLoginLink;
    private FrameLayout loadingOverlay;

    // State
    private String selectedRole = null;       // Constants.ROLE_DONOR or ROLE_RECIPIENT
    private String selectedType = null;       // "A", "B", "AB", "O"
    private String selectedRh   = null;       // "+", "−"
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        sessionManager = new SessionManager(this);
        bindViews();
        setListeners();
    }

    // ------------------------------------------------------------------
    // View binding
    // ------------------------------------------------------------------

    private void bindViews() {
        tilFullName        = findViewById(R.id.tilFullName);
        tilEmail           = findViewById(R.id.tilEmail);
        tilPassword        = findViewById(R.id.tilPassword);
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword);
        tilPhone           = findViewById(R.id.tilPhone);

        etFullName        = findViewById(R.id.etFullName);
        etEmail           = findViewById(R.id.etEmail);
        etPassword        = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etPhone           = findViewById(R.id.etPhone);

        btnRoleDonor     = findViewById(R.id.btnRoleDonor);
        btnRoleRecipient = findViewById(R.id.btnRoleRecipient);

        btnTypeA  = findViewById(R.id.btnTypeA);
        btnTypeB  = findViewById(R.id.btnTypeB);
        btnTypeAB = findViewById(R.id.btnTypeAB);
        btnTypeO  = findViewById(R.id.btnTypeO);
        btnRhPos  = findViewById(R.id.btnRhPos);
        btnRhNeg  = findViewById(R.id.btnRhNeg);

        layoutBloodGroup  = findViewById(R.id.layoutBloodGroup);
        tvBloodGroupError = findViewById(R.id.tvBloodGroupError);

        btnSignup    = findViewById(R.id.btnSignup);
        tvLoginLink  = findViewById(R.id.tvLoginLink);
        loadingOverlay = findViewById(R.id.loadingOverlay);
    }

    // ------------------------------------------------------------------
    // Click listeners
    // ------------------------------------------------------------------

    private void setListeners() {
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        // Role pills
        btnRoleDonor.setOnClickListener(v -> selectRole(Constants.ROLE_DONOR));
        btnRoleRecipient.setOnClickListener(v -> selectRole(Constants.ROLE_RECIPIENT));

        // Blood type pills
        btnTypeA.setOnClickListener(v  -> selectType("A",  btnTypeA));
        btnTypeB.setOnClickListener(v  -> selectType("B",  btnTypeB));
        btnTypeAB.setOnClickListener(v -> selectType("AB", btnTypeAB));
        btnTypeO.setOnClickListener(v  -> selectType("O",  btnTypeO));

        // Rh factor pills
        btnRhPos.setOnClickListener(v -> selectRh("+", btnRhPos));
        btnRhNeg.setOnClickListener(v -> selectRh("-", btnRhNeg));

        btnSignup.setOnClickListener(v -> onSignupClicked());
        tvLoginLink.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }

    // ------------------------------------------------------------------
    // Role / blood group pill selection
    // ------------------------------------------------------------------

    private void selectRole(String role) {
        selectedRole = role;
        boolean isDonor = Constants.ROLE_DONOR.equals(role);

        setPillSelected(btnRoleDonor,     isDonor);
        setPillSelected(btnRoleRecipient, !isDonor);

        layoutBloodGroup.setVisibility(isDonor ? View.VISIBLE : View.GONE);
        if (!isDonor) {
            // Reset blood group selection when switching to recipient
            selectedType = null;
            selectedRh   = null;
            resetTypePills();
            resetRhPills();
        }
    }

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
        setPillSelected(btnTypeA,  false);
        setPillSelected(btnTypeB,  false);
        setPillSelected(btnTypeAB, false);
        setPillSelected(btnTypeO,  false);
    }

    private void resetRhPills() {
        setPillSelected(btnRhPos, false);
        setPillSelected(btnRhNeg, false);
    }

    /**
     * Toggles a pill button between selected (red filled) and unselected (outlined) state.
     */
    private void setPillSelected(MaterialButton btn, boolean selected) {
        if (selected) {
            btn.setBackgroundTintList(
                    ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorPrimary)));
            btn.setTextColor(ContextCompat.getColor(this, R.color.white));
            btn.setStrokeColor(
                    ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorPrimary)));
        } else {
            btn.setBackgroundTintList(
                    ColorStateList.valueOf(ContextCompat.getColor(this, android.R.color.transparent)));
            btn.setTextColor(ContextCompat.getColor(this, R.color.textPrimary));
            btn.setStrokeColor(
                    ColorStateList.valueOf(ContextCompat.getColor(this, R.color.dividerColor)));
        }
    }

    // ------------------------------------------------------------------
    // Form validation
    // ------------------------------------------------------------------

    private boolean validateForm() {
        boolean valid = true;

        String name     = etFullName.getText() != null ? etFullName.getText().toString().trim() : "";
        String email    = etEmail.getText() != null ? etEmail.getText().toString().trim() : "";
        String password = etPassword.getText() != null ? etPassword.getText().toString() : "";
        String confirm  = etConfirmPassword.getText() != null ? etConfirmPassword.getText().toString() : "";
        String phone    = etPhone.getText() != null ? etPhone.getText().toString().trim() : "";

        // Name
        if (!ValidationUtils.isNotEmpty(name)) {
            tilFullName.setError(getString(R.string.error_name_required));
            valid = false;
        } else {
            tilFullName.setError(null);
        }

        // Email
        if (!ValidationUtils.isValidEmail(email)) {
            tilEmail.setError(email.isEmpty()
                    ? getString(R.string.error_email_required)
                    : getString(R.string.error_email_invalid));
            valid = false;
        } else {
            tilEmail.setError(null);
        }

        // Password
        if (!ValidationUtils.isNotEmpty(password)) {
            tilPassword.setError(getString(R.string.error_password_required));
            valid = false;
        } else if (!ValidationUtils.isPasswordStrong(password)) {
            tilPassword.setError(getString(R.string.error_password_short));
            valid = false;
        } else {
            tilPassword.setError(null);
        }

        // Confirm password
        if (!password.equals(confirm)) {
            tilConfirmPassword.setError(getString(R.string.error_passwords_no_match));
            valid = false;
        } else {
            tilConfirmPassword.setError(null);
        }

        // Role
        if (selectedRole == null) {
            Toast.makeText(this, getString(R.string.error_select_role), Toast.LENGTH_SHORT).show();
            valid = false;
        }

        // Blood group — required only for donors
        if (Constants.ROLE_DONOR.equals(selectedRole)) {
            if (selectedType == null || selectedRh == null) {
                tvBloodGroupError.setVisibility(View.VISIBLE);
                valid = false;
            } else {
                tvBloodGroupError.setVisibility(View.GONE);
            }
        }

        // Phone
        if (!ValidationUtils.isValidPhone(phone)) {
            tilPhone.setError(phone.isEmpty()
                    ? getString(R.string.error_phone_required)
                    : getString(R.string.error_phone_invalid));
            valid = false;
        } else {
            tilPhone.setError(null);
        }

        return valid;
    }

    // ------------------------------------------------------------------
    // Signup flow
    // ------------------------------------------------------------------

    private void onSignupClicked() {
        if (!validateForm()) return;
        if (!NetworkUtils.isNetworkAvailable(this)) {
            com.google.android.material.snackbar.Snackbar.make(
                    findViewById(android.R.id.content),
                    getString(R.string.error_no_internet),
                    com.google.android.material.snackbar.Snackbar.LENGTH_LONG).show();
            return;
        }

        String email    = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString();

        showLoading(true);
        AuthService authService = SupabaseClient.getAuthService();
        authService.signup(new AuthRequest(email, password))
                .enqueue(new Callback<AuthResponse>() {
                    @Override
                    public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            AuthResponse auth = response.body();
                            // Save tokens and user ID
                            sessionManager.saveSession(
                                    auth.getAccessToken(),
                                    auth.getRefreshToken(),
                                    auth.getUser().getId()
                            );
                            insertProfile(auth.getUser().getId(), auth.getAccessToken());
                        } else {
                            showLoading(false);
                            Toast.makeText(SignupActivity.this,
                                    getString(R.string.error_signup_failed),
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthResponse> call, Throwable t) {
                        showLoading(false);
                        Toast.makeText(SignupActivity.this,
                                getString(R.string.error_network),
                                Toast.LENGTH_LONG).show();
                    }
                });
    }

    /**
     * After successful auth signup, insert the user's profile row.
     */
    private void insertProfile(String userId, String accessToken) {
        String name       = etFullName.getText().toString().trim();
        String email      = etEmail.getText().toString().trim();
        String phone      = etPhone.getText().toString().trim();
        String bloodGroup = Constants.ROLE_DONOR.equals(selectedRole)
                ? selectedType + selectedRh
                : null;

        UserProfile profile = new UserProfile();
        profile.setId(userId);
        profile.setFullName(name);
        profile.setEmail(email);
        profile.setPhone(phone);
        profile.setRole(selectedRole);
        profile.setBloodGroup(bloodGroup);
        profile.setIsAvailable(true);

        ProfileService profileService = SupabaseClient.getProfileService(sessionManager);
        profileService.insertProfile(profile).enqueue(new Callback<List<UserProfile>>() {
            @Override
            public void onResponse(Call<List<UserProfile>> call, Response<List<UserProfile>> response) {
                showLoading(false);
                if (response.isSuccessful()) {
                    // Save display details for home screen
                    sessionManager.saveRole(selectedRole);
                    sessionManager.saveUserDetails(name, bloodGroup);

                    // Navigate to home, clearing the back stack
                    Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignupActivity.this,
                            getString(R.string.error_generic),
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<UserProfile>> call, Throwable t) {
                showLoading(false);
                Toast.makeText(SignupActivity.this,
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
        btnSignup.setEnabled(!show);
    }
}
