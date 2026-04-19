package com.lifeflow.app.ui.profile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lifeflow.app.R;
import com.lifeflow.app.ui.profile.DonationHistoryAdapter.DonationRecord;
import com.lifeflow.app.utils.SessionManager;

import java.util.Arrays;
import java.util.List;

/**
 * Shows the current user's blood donation history and statistics.
 * Data is static/dummy until a donation_records table is added to the backend.
 */
public class DonationInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_info);

        SessionManager sessionManager = new SessionManager(this);
        String bloodGroup = sessionManager.getBloodGroup();
        if (bloodGroup == null || bloodGroup.isEmpty()) bloodGroup = "?";

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        List<DonationRecord> records = Arrays.asList(
                new DonationRecord("Mar 15, 2026", "Dhaka Medical College Hospital",   bloodGroup, "1 unit"),
                new DonationRecord("Dec 10, 2025", "Square Hospital, Dhaka",           bloodGroup, "1 unit"),
                new DonationRecord("Sep 05, 2025", "BIRDEM General Hospital",          bloodGroup, "1 unit"),
                new DonationRecord("Jun 01, 2025", "National Heart Foundation",        bloodGroup, "1 unit"),
                new DonationRecord("Feb 14, 2025", "Bangabandhu Sheikh Mujib Med Uni", bloodGroup, "1 unit")
        );

        RecyclerView rv = findViewById(R.id.rvDonationHistory);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rv.setAdapter(new DonationHistoryAdapter(records));
    }
}
