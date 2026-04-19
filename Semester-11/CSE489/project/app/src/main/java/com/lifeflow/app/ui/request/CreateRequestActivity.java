package com.lifeflow.app.ui.request;

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
import com.lifeflow.app.data.api.RequestService;
import com.lifeflow.app.data.api.SupabaseClient;
import com.lifeflow.app.data.model.BloodRequest;
import com.lifeflow.app.utils.Constants;
import com.lifeflow.app.utils.NetworkUtils;
import com.lifeflow.app.utils.SessionManager;
import com.lifeflow.app.utils.ValidationUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Form to create a new blood request.
 * Tasks 4.1.2 (UI + validation) + 4.1.3 (API call).
 */
public class CreateRequestActivity extends AppCompatActivity {

    // Views
    private MaterialButton btnTypeA, btnTypeB, btnTypeAB, btnTypeO;
    private MaterialButton btnRhPos, btnRhNeg;
    private TextView tvBloodGroupError;
    private TextInputLayout tilUnits, tilHospital, tilContactPhone, tilNotes;
    private TextInputEditText etUnits, etHospital, etContactPhone, etNotes;
    private MaterialButton btnUrgencyNormal, btnUrgencyUrgent, btnUrgencyCritical;
    private MaterialButton btnSubmit;
    private FrameLayout loadingOverlay;

    // State
    private String selectedType    = null;
    private String selectedRh      = null;
    private String selectedUrgency = Constants.URGENCY_NORMAL;   // default
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_request);

        sessionManager = new SessionManager(this);
        bindViews();
        setListeners();
        // Pre-select "Normal" urgency
        setPillSelected(btnUrgencyNormal, true);
    }

    // ------------------------------------------------------------------
    // View binding
    // ------------------------------------------------------------------

    private void bindViews() {
        btnTypeA  = findViewById(R.id.btnTypeA);
        btnTypeB  = findViewById(R.id.btnTypeB);
        btnTypeAB = findViewById(R.id.btnTypeAB);
        btnTypeO  = findViewById(R.id.btnTypeO);
        btnRhPos  = findViewById(R.id.btnRhPos);
        btnRhNeg  = findViewById(R.id.btnRhNeg);

        tvBloodGroupError = findViewById(R.id.tvBloodGroupError);

        tilUnits        = findViewById(R.id.tilUnits);
        tilHospital     = findViewById(R.id.tilHospital);
        tilContactPhone = findViewById(R.id.tilContactPhone);
        tilNotes        = findViewById(R.id.tilNotes);

        etUnits        = findViewById(R.id.etUnits);
        etHospital     = findViewById(R.id.etHospital);
        etContactPhone = findViewById(R.id.etContactPhone);
        etNotes        = findViewById(R.id.etNotes);

        btnUrgencyNormal   = findViewById(R.id.btnUrgencyNormal);
        btnUrgencyUrgent   = findViewById(R.id.btnUrgencyUrgent);
        btnUrgencyCritical = findViewById(R.id.btnUrgencyCritical);

        btnSubmit      = findViewById(R.id.btnSubmit);
        loadingOverlay = findViewById(R.id.loadingOverlay);
    }

    // ------------------------------------------------------------------
    // Listeners
    // ------------------------------------------------------------------

    private void setListeners() {
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        // Blood type pills
        btnTypeA.setOnClickListener(v  -> selectType("A",  btnTypeA));
        btnTypeB.setOnClickListener(v  -> selectType("B",  btnTypeB));
        btnTypeAB.setOnClickListener(v -> selectType("AB", btnTypeAB));
        btnTypeO.setOnClickListener(v  -> selectType("O",  btnTypeO));

        // Rh factor pills
        btnRhPos.setOnClickListener(v -> selectRh("+", btnRhPos));
        btnRhNeg.setOnClickListener(v -> selectRh("−", btnRhNeg));

        // Urgency pills
        btnUrgencyNormal.setOnClickListener(v   -> selectUrgency(Constants.URGENCY_NORMAL,   btnUrgencyNormal));
        btnUrgencyUrgent.setOnClickListener(v   -> selectUrgency(Constants.URGENCY_URGENT,   btnUrgencyUrgent));
        btnUrgencyCritical.setOnClickListener(v -> selectUrgency(Constants.URGENCY_CRITICAL, btnUrgencyCritical));

        btnSubmit.setOnClickListener(v -> onSubmitClicked());
    }

    // ------------------------------------------------------------------
    // Pill selection helpers
    // ------------------------------------------------------------------

    private void selectType(String type, MaterialButton btn) {
        selectedType = type;
        tvBloodGroupError.setVisibility(View.GONE);
        resetPills(btnTypeA, btnTypeB, btnTypeAB, btnTypeO);
        setPillSelected(btn, true);
    }

    private void selectRh(String rh, MaterialButton btn) {
        selectedRh = rh;
        tvBloodGroupError.setVisibility(View.GONE);
        resetPills(btnRhPos, btnRhNeg);
        setPillSelected(btn, true);
    }

    private void selectUrgency(String urgency, MaterialButton btn) {
        selectedUrgency = urgency;
        resetPills(btnUrgencyNormal, btnUrgencyUrgent, btnUrgencyCritical);
        setPillSelected(btn, true);
    }

    private void resetPills(MaterialButton... buttons) {
        for (MaterialButton btn : buttons) setPillSelected(btn, false);
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

        // Blood group
        if (selectedType == null || selectedRh == null) {
            tvBloodGroupError.setVisibility(View.VISIBLE);
            valid = false;
        } else {
            tvBloodGroupError.setVisibility(View.GONE);
        }

        // Contact phone
        String phone = etContactPhone.getText() != null
                ? etContactPhone.getText().toString().trim() : "";
        if (!ValidationUtils.isValidPhone(phone)) {
            tilContactPhone.setError(phone.isEmpty()
                    ? getString(R.string.error_phone_required)
                    : getString(R.string.error_phone_invalid));
            valid = false;
        } else {
            tilContactPhone.setError(null);
        }

        return valid;
    }

    // ------------------------------------------------------------------
    // Task 4.1.3 — API call
    // ------------------------------------------------------------------

    private void onSubmitClicked() {
        if (!validateForm()) return;
        if (!NetworkUtils.isNetworkAvailable(this)) {
            com.google.android.material.snackbar.Snackbar.make(
                    findViewById(android.R.id.content),
                    getString(R.string.error_no_internet),
                    com.google.android.material.snackbar.Snackbar.LENGTH_LONG).show();
            return;
        }

        String bloodGroup = selectedType + selectedRh;
        String phone      = etContactPhone.getText().toString().trim();
        String hospital   = etHospital.getText() != null
                ? etHospital.getText().toString().trim() : "";
        String notesText  = etNotes.getText() != null
                ? etNotes.getText().toString().trim() : "";
        int units = 1;
        try {
            String unitsStr = etUnits.getText() != null
                    ? etUnits.getText().toString().trim() : "1";
            units = Integer.parseInt(unitsStr);
            if (units < 1) units = 1;
        } catch (NumberFormatException ignored) {}

        BloodRequest request = new BloodRequest();
        request.setRequesterId(sessionManager.getUserId());
        request.setBloodGroupNeeded(bloodGroup);
        request.setUnitsNeeded(units);
        request.setHospitalName(hospital.isEmpty() ? null : hospital);
        request.setUrgency(selectedUrgency);
        request.setContactPhone(phone);
        request.setNotes(notesText.isEmpty() ? null : notesText);
        request.setIsFulfilled(false);

        showLoading(true);
        RequestService service = SupabaseClient.getRequestService(sessionManager);
        service.createRequest(request).enqueue(new Callback<List<BloodRequest>>() {
            @Override
            public void onResponse(Call<List<BloodRequest>> call,
                                   Response<List<BloodRequest>> response) {
                showLoading(false);
                if (response.isSuccessful()) {
                    Toast.makeText(CreateRequestActivity.this,
                            getString(R.string.msg_request_submitted),
                            Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CreateRequestActivity.this,
                            getString(R.string.error_generic),
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<BloodRequest>> call, Throwable t) {
                showLoading(false);
                Toast.makeText(CreateRequestActivity.this,
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
        btnSubmit.setEnabled(!show);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
