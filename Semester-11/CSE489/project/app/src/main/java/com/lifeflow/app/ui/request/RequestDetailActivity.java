package com.lifeflow.app.ui.request;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.lifeflow.app.R;
import com.lifeflow.app.data.api.RequestService;
import com.lifeflow.app.data.api.SupabaseClient;
import com.lifeflow.app.utils.Constants;
import com.lifeflow.app.utils.NetworkUtils;
import com.lifeflow.app.utils.SessionManager;
import com.lifeflow.app.utils.TimeUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Shows full details of a single blood request.
 * Delete button is shown only if the logged-in user is the requester.
 */
public class RequestDetailActivity extends AppCompatActivity {

    public static final String EXTRA_ID           = "req_id";
    public static final String EXTRA_BLOOD_GROUP  = "req_blood_group";
    public static final String EXTRA_UNITS        = "req_units";
    public static final String EXTRA_HOSPITAL     = "req_hospital";
    public static final String EXTRA_URGENCY      = "req_urgency";
    public static final String EXTRA_PHONE        = "req_phone";
    public static final String EXTRA_NOTES        = "req_notes";
    public static final String EXTRA_CREATED_AT   = "req_created_at";
    public static final String EXTRA_REQUESTER_ID = "req_requester_id";

    private SessionManager sessionManager;
    private ProgressBar progressBar;
    private MaterialButton btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_detail);

        sessionManager = new SessionManager(this);
        progressBar    = new ProgressBar(this); // used programmatically for delete loading

        Intent intent = getIntent();
        String requestId    = intent.getStringExtra(EXTRA_ID);
        String bloodGroup   = intent.getStringExtra(EXTRA_BLOOD_GROUP);
        int    units        = intent.getIntExtra(EXTRA_UNITS, 1);
        String hospital     = intent.getStringExtra(EXTRA_HOSPITAL);
        String urgency      = intent.getStringExtra(EXTRA_URGENCY);
        String phone        = intent.getStringExtra(EXTRA_PHONE);
        String notes        = intent.getStringExtra(EXTRA_NOTES);
        String createdAt    = intent.getStringExtra(EXTRA_CREATED_AT);
        String requesterId  = intent.getStringExtra(EXTRA_REQUESTER_ID);

        bindViews(requestId, bloodGroup, units, hospital, urgency, phone, notes, createdAt, requesterId);
    }

    private void bindViews(String requestId, String bloodGroup, int units, String hospital,
                           String urgency, String phone, String notes, String createdAt,
                           String requesterId) {
        // Back button
        ImageView btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        // Blood group badge
        TextView tvBloodGroup = findViewById(R.id.tvBloodGroup);
        tvBloodGroup.setText(bloodGroup != null ? bloodGroup : "?");

        // Urgency tag
        TextView tvUrgency = findViewById(R.id.tvUrgency);
        applyUrgencyTag(tvUrgency, urgency);

        // Hospital
        TextView tvHospital = findViewById(R.id.tvHospital);
        tvHospital.setText(hospital != null && !hospital.isEmpty() ? hospital : "Unknown Hospital");

        // Units
        TextView tvUnits = findViewById(R.id.tvUnits);
        tvUnits.setText(getString(R.string.label_units_format, units));

        // Contact phone
        TextView tvPhone = findViewById(R.id.tvContactPhone);
        tvPhone.setText(phone != null ? phone : "—");

        // Notes — hide section if empty
        TextView labelNotes = findViewById(R.id.labelNotes);
        TextView tvNotes    = findViewById(R.id.tvNotes);
        if (notes != null && !notes.isEmpty()) {
            tvNotes.setText(notes);
        } else {
            labelNotes.setVisibility(View.GONE);
            tvNotes.setVisibility(View.GONE);
        }

        // Time ago
        TextView tvTimeAgo = findViewById(R.id.tvTimeAgo);
        tvTimeAgo.setText(TimeUtils.getTimeAgo(createdAt));

        // Call button
        MaterialButton btnCall = findViewById(R.id.btnCall);
        if (phone != null && !phone.isEmpty()) {
            btnCall.setOnClickListener(v -> {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                startActivity(dialIntent);
            });
        } else {
            btnCall.setEnabled(false);
        }

        // Delete button — only visible to the requester
        btnDelete = findViewById(R.id.btnDelete);
        String currentUserId = sessionManager.getUserId();
        if (requestId != null && requesterId != null && requesterId.equals(currentUserId)) {
            btnDelete.setVisibility(View.VISIBLE);
            btnDelete.setOnClickListener(v -> confirmDelete(requestId));
        }
    }

    private void confirmDelete(String requestId) {
        new AlertDialog.Builder(this)
                .setTitle("Delete Request")
                .setMessage("Are you sure you want to delete this blood request? This cannot be undone.")
                .setPositiveButton("Delete", (dialog, which) -> deleteRequest(requestId))
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void deleteRequest(String requestId) {
        if (!NetworkUtils.isNetworkAvailable(this)) {
            Toast.makeText(this, getString(R.string.error_no_internet), Toast.LENGTH_SHORT).show();
            return;
        }

        btnDelete.setEnabled(false);
        btnDelete.setText("Deleting…");

        RequestService service = SupabaseClient.getRequestService(sessionManager, this);
        service.deleteRequest("eq." + requestId)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(RequestDetailActivity.this,
                                    "Request deleted", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            btnDelete.setEnabled(true);
                            btnDelete.setText("Delete Request");
                            Toast.makeText(RequestDetailActivity.this,
                                    getString(R.string.error_generic), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        btnDelete.setEnabled(true);
                        btnDelete.setText("Delete Request");
                        Toast.makeText(RequestDetailActivity.this,
                                getString(R.string.error_network), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void applyUrgencyTag(TextView tvUrgency, String urgency) {
        if (urgency == null) urgency = Constants.URGENCY_NORMAL;
        switch (urgency) {
            case Constants.URGENCY_CRITICAL:
                tvUrgency.setText(R.string.urgency_critical);
                tvUrgency.setBackgroundResource(R.drawable.bg_tag_critical);
                tvUrgency.setTextColor(getColor(R.color.colorCritical));
                break;
            case Constants.URGENCY_URGENT:
                tvUrgency.setText(R.string.urgency_urgent);
                tvUrgency.setBackgroundResource(R.drawable.bg_tag_urgent);
                tvUrgency.setTextColor(getColor(R.color.colorUrgent));
                break;
            default:
                tvUrgency.setText(R.string.urgency_normal);
                tvUrgency.setBackgroundResource(R.drawable.bg_tag_normal);
                tvUrgency.setTextColor(getColor(R.color.colorNormal));
                break;
        }
    }
}
