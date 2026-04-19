package com.lifeflow.app.ui.request;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
 * Shows the current recipient's own blood requests.
 * Task 5.1.3: fetches requests filtered by requester_id = current user.
 */
public class MyRequestsActivity extends AppCompatActivity {

    private RecyclerView rvMyRequests;
    private LinearLayout layoutEmpty;
    private ProgressBar progressBar;

    private RequestAdapter adapter;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_requests);

        sessionManager = new SessionManager(this);
        bindViews();
        setupRecyclerView();
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
        fetchMyRequests();
    }

    // ------------------------------------------------------------------
    // View binding
    // ------------------------------------------------------------------

    private void bindViews() {
        rvMyRequests = findViewById(R.id.rvMyRequests);
        layoutEmpty  = findViewById(R.id.layoutEmpty);
        progressBar  = findViewById(R.id.progressBar);
    }

    // ------------------------------------------------------------------
    // RecyclerView
    // ------------------------------------------------------------------

    private void setupRecyclerView() {
        adapter = new RequestAdapter(new ArrayList<>());
        adapter.setOnRequestClickListener(request -> {
            Intent intent = new Intent(this, RequestDetailActivity.class);
            intent.putExtra(RequestDetailActivity.EXTRA_ID,           request.getId());
            intent.putExtra(RequestDetailActivity.EXTRA_BLOOD_GROUP,  request.getBloodGroupNeeded());
            intent.putExtra(RequestDetailActivity.EXTRA_UNITS,        request.getUnitsNeeded());
            intent.putExtra(RequestDetailActivity.EXTRA_HOSPITAL,     request.getHospitalName());
            intent.putExtra(RequestDetailActivity.EXTRA_URGENCY,      request.getUrgency());
            intent.putExtra(RequestDetailActivity.EXTRA_PHONE,        request.getContactPhone());
            intent.putExtra(RequestDetailActivity.EXTRA_NOTES,        request.getNotes());
            intent.putExtra(RequestDetailActivity.EXTRA_CREATED_AT,   request.getCreatedAt());
            intent.putExtra(RequestDetailActivity.EXTRA_REQUESTER_ID, request.getRequesterId());
            startActivity(intent);
        });
        rvMyRequests.setLayoutManager(new LinearLayoutManager(this));
        rvMyRequests.setAdapter(adapter);
    }

    // ------------------------------------------------------------------
    // API fetch — only this user's requests
    // ------------------------------------------------------------------

    private void fetchMyRequests() {
        if (!NetworkUtils.isNetworkAvailable(this)) {
            com.google.android.material.snackbar.Snackbar.make(
                    findViewById(android.R.id.content),
                    getString(R.string.error_no_internet),
                    com.google.android.material.snackbar.Snackbar.LENGTH_LONG).show();
            return;
        }
        showLoading(true);
        String userId = sessionManager.getUserId();
        RequestService service = SupabaseClient.getRequestService(sessionManager);
        service.getRequestsByUser("eq." + userId, "created_at.desc")
                .enqueue(new Callback<List<BloodRequest>>() {
                    @Override
                    public void onResponse(Call<List<BloodRequest>> call,
                                           Response<List<BloodRequest>> response) {
                        showLoading(false);
                        if (response.isSuccessful() && response.body() != null) {
                            List<BloodRequest> requests = response.body();
                            adapter.setData(requests);
                            showEmptyState(requests.isEmpty());
                        } else {
                            showEmptyState(true);
                            Toast.makeText(MyRequestsActivity.this,
                                    getString(R.string.error_generic),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<BloodRequest>> call, Throwable t) {
                        showLoading(false);
                        showEmptyState(true);
                        Toast.makeText(MyRequestsActivity.this,
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
        rvMyRequests.setVisibility(show ? View.GONE : View.VISIBLE);
        if (show) layoutEmpty.setVisibility(View.GONE);
    }

    private void showEmptyState(boolean show) {
        layoutEmpty.setVisibility(show ? View.VISIBLE : View.GONE);
        rvMyRequests.setVisibility(show ? View.GONE : View.VISIBLE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
