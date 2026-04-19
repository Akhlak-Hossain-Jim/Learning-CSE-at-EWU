package com.lifeflow.app.ui.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lifeflow.app.R;

import java.util.List;

/**
 * Adapter for the donation history RecyclerView in DonationInfoActivity.
 * Each item holds: date, hospital/location, blood group, units donated.
 */
public class DonationHistoryAdapter
        extends RecyclerView.Adapter<DonationHistoryAdapter.ViewHolder> {

    public static class DonationRecord {
        public final String date;
        public final String hospital;
        public final String bloodGroup;
        public final String units;

        public DonationRecord(String date, String hospital, String bloodGroup, String units) {
            this.date       = date;
            this.hospital   = hospital;
            this.bloodGroup = bloodGroup;
            this.units      = units;
        }
    }

    private final List<DonationRecord> items;

    public DonationHistoryAdapter(List<DonationRecord> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_donation_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DonationRecord record = items.get(position);
        holder.tvBloodGroup.setText(record.bloodGroup);
        holder.tvHospital.setText(record.hospital);
        holder.tvDate.setText(record.date);
        holder.tvUnits.setText(record.units);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBloodGroup, tvHospital, tvDate, tvUnits;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBloodGroup = itemView.findViewById(R.id.tvDonationBloodGroup);
            tvHospital   = itemView.findViewById(R.id.tvDonationHospital);
            tvDate       = itemView.findViewById(R.id.tvDonationDate);
            tvUnits      = itemView.findViewById(R.id.tvDonationUnits);
        }
    }
}
