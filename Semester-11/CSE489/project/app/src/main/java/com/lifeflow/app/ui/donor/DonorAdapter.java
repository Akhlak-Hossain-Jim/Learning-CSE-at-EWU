package com.lifeflow.app.ui.donor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lifeflow.app.R;
import com.lifeflow.app.data.model.UserProfile;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView adapter for the donor list screen.
 * Supports click callbacks and data filtering (search + blood group).
 */
public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.ViewHolder> {

    public interface OnDonorClickListener {
        void onDonorClick(UserProfile donor);
    }

    private List<UserProfile> displayList;   // currently shown (after filter)
    private List<UserProfile> fullList;      // master copy (for filtering)
    private final OnDonorClickListener listener;

    public DonorAdapter(List<UserProfile> donors, OnDonorClickListener listener) {
        this.fullList    = new ArrayList<>(donors);
        this.displayList = new ArrayList<>(donors);
        this.listener    = listener;
    }

    // ------------------------------------------------------------------
    // RecyclerView.Adapter overrides
    // ------------------------------------------------------------------

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_donor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserProfile donor = displayList.get(position);

        holder.tvName.setText(donor.getFullName() != null ? donor.getFullName() : "—");
        holder.tvBloodGroup.setText(donor.getBloodGroup() != null ? donor.getBloodGroup() : "?");
        holder.tvCity.setText(donor.getCity() != null ? donor.getCity() : "—");
        holder.tvPhone.setText(donor.getPhone() != null ? donor.getPhone() : "—");

        // Availability dot: green = available, grey = unavailable
        int dotColor = donor.getIsAvailable()
                ? holder.itemView.getContext().getColor(R.color.colorSuccess)
                : holder.itemView.getContext().getColor(R.color.colorUnavailable);
        holder.viewAvailability.getBackground().setTint(dotColor);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onDonorClick(donor);
        });
    }

    @Override
    public int getItemCount() {
        return displayList.size();
    }

    // ------------------------------------------------------------------
    // Data management
    // ------------------------------------------------------------------

    /** Replace the full dataset (call after fresh API fetch). */
    public void setData(List<UserProfile> donors) {
        fullList    = new ArrayList<>(donors);
        displayList = new ArrayList<>(donors);
        notifyDataSetChanged();
    }

    /** Returns the current display list (used for combining filters). */
    public List<UserProfile> getFullList() {
        return fullList;
    }

    /** Apply filtered list directly (call after combining search + chip filter). */
    public void submitFilteredList(List<UserProfile> filtered) {
        displayList = new ArrayList<>(filtered);
        notifyDataSetChanged();
    }

    // ------------------------------------------------------------------
    // ViewHolder
    // ------------------------------------------------------------------

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvBloodGroup, tvCity, tvPhone;
        View viewAvailability;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName           = itemView.findViewById(R.id.tvName);
            tvBloodGroup     = itemView.findViewById(R.id.tvBloodGroup);
            tvCity           = itemView.findViewById(R.id.tvCity);
            tvPhone          = itemView.findViewById(R.id.tvPhone);
            viewAvailability = itemView.findViewById(R.id.viewAvailability);
        }
    }
}
