package com.lifeflow.app.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
import com.lifeflow.app.utils.NetworkUtils;
import com.lifeflow.app.utils.SessionManager;
import com.lifeflow.app.utils.ValidationUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Login screen.
 * Flow: validate → login (GoTrue) → fetch profile (role) → navigate home.
 */
public class LoginActivity extends AppCompatActivity {

    private TextInputLayout tilEmail, tilPassword;
    private TextInputEditText etEmail, etPassword;
    private MaterialButton btnLogin;
    private TextView tvSignupLink;
    private FrameLayout loadingOverlay;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);
        bindViews();
        setListeners();
    }

    // ------------------------------------------------------------------
    // View binding
    // ------------------------------------------------------------------

    private void bindViews() {
        tilEmail    = findViewById(R.id.tilEmail);
        tilPassword = findViewById(R.id.tilPassword);
        etEmail     = findViewById(R.id.etEmail);
        etPassword  = findViewById(R.id.etPassword);
        btnLogin    = findViewById(R.id.btnLogin);
        tvSignupLink   = findViewById(R.id.tvSignupLink);
        loadingOverlay = findViewById(R.id.loadingOverlay);
    }

    // ------------------------------------------------------------------
    // Listeners
    // ------------------------------------------------------------------

    private void setListeners() {
        btnLogin.setOnClickListener(v -> onLoginClicked());

        tvSignupLink.setOnClickListener(v -> {
            startActivity(new Intent(this, SignupActivity.class));
            finish();
        });
    }

    // ------------------------------------------------------------------
    // Validation
    // ------------------------------------------------------------------

    private boolean validateForm() {
        boolean valid = true;

        String email    = etEmail.getText() != null ? etEmail.getText().toString().trim() : "";
        String password = etPassword.getText() != null ? etPassword.getText().toString() : "";

        if (!ValidationUtils.isValidEmail(email)) {
            tilEmail.setError(email.isEmpty()
                    ? getString(R.string.error_email_required)
                    : getString(R.string.error_email_invalid));
            valid = false;
        } else {
            tilEmail.setError(null);
        }

        if (!ValidationUtils.isNotEmpty(password)) {
            tilPassword.setError(getString(R.string.error_password_required));
            valid = false;
        } else {
            tilPassword.setError(null);
        }

        return valid;
    }

    // ------------------------------------------------------------------
    // Login flow
    // ------------------------------------------------------------------

    private void onLoginClicked() {
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
        authService.login(new AuthRequest(email, password))
                .enqueue(new Callback<AuthResponse>() {
                    @Override
                    public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            AuthResponse auth = response.body();
                            sessionManager.saveSession(
                                    auth.getAccessToken(),
                                    auth.getRefreshToken(),
                                    auth.getUser().getId()
                            );
                            fetchProfile(auth.getUser().getId());
                        } else {
                            showLoading(false);
                            // 400 = invalid credentials, anything else = server error
                            if (response.code() == 400) {
                                Toast.makeText(LoginActivity.this,
                                        getString(R.string.error_login_failed),
                                        Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(LoginActivity.this,
                                        getString(R.string.error_generic),
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthResponse> call, Throwable t) {
                        showLoading(false);
                        Toast.makeText(LoginActivity.this,
                                getString(R.string.error_network),
                                Toast.LENGTH_LONG).show();
                    }
                });
    }

    /**
     * After login, fetch the user's profile to get their role and display name.
     */
    private void fetchProfile(String userId) {
        ProfileService profileService = SupabaseClient.getProfileService(sessionManager);
        profileService.getProfileById("eq." + userId)
                .enqueue(new Callback<List<UserProfile>>() {
                    @Override
                    public void onResponse(Call<List<UserProfile>> call, Response<List<UserProfile>> response) {
                        showLoading(false);
                        if (response.isSuccessful()
                                && response.body() != null
                                && !response.body().isEmpty()) {

                            UserProfile profile = response.body().get(0);
                            sessionManager.saveRole(profile.getRole());
                            sessionManager.saveUserDetails(
                                    profile.getFullName(),
                                    profile.getBloodGroup()
                            );
                        }
                        // Navigate home even if profile fetch fails —
                        // the profile screen will retry.
                        navigateHome();
                    }

                    @Override
                    public void onFailure(Call<List<UserProfile>> call, Throwable t) {
                        showLoading(false);
                        // Still navigate; partial session is better than staying on login.
                        navigateHome();
                    }
                });
    }

    private void navigateHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    // ------------------------------------------------------------------
    // Loading state
    // ------------------------------------------------------------------

    private void showLoading(boolean show) {
        loadingOverlay.setVisibility(show ? View.VISIBLE : View.GONE);
        btnLogin.setEnabled(!show);
    }
}
