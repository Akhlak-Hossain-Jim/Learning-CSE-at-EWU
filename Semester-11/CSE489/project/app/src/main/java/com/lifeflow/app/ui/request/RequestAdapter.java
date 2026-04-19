package com.lifeflow.app.ui.request;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lifeflow.app.R;
import com.lifeflow.app.data.model.BloodRequest;
import com.lifeflow.app.utils.Constants;
import com.lifeflow.app.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView adapter for the blood requests list screen.
 * Binds BloodRequest data to item_request.xml.
 */
public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ViewHolder> {

    public interface OnRequestClickListener {
        void onRequestClick(BloodRequest request);
    }

    private List<BloodRequest> items;
    private List<BloodRequest> allItems; // full unfiltered list
    private OnRequestClickListener listener;

    public RequestAdapter(List<BloodRequest> items) {
        this.items    = new ArrayList<>(items);
        this.allItems = new ArrayList<>(items);
    }

    public void setOnRequestClickListener(OnRequestClickListener listener) {
        this.listener = listener;
    }

    // ------------------------------------------------------------------
    // RecyclerView.Adapter overrides
    // ------------------------------------------------------------------

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_request, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BloodRequest req = items.get(position);
        android.content.Context ctx = holder.itemView.getContext();

        // Blood group badge
        holder.tvBloodGroup.setText(
                req.getBloodGroupNeeded() != null ? req.getBloodGroupNeeded() : "?");

        // Hospital name
        holder.tvHospital.setText(
                req.getHospitalName() != null && !req.getHospitalName().isEmpty()
                        ? req.getHospitalName()
                        : "Unknown Hospital");

        // Units needed
        holder.tvUnits.setText(
                ctx.getString(R.string.label_units_format, req.getUnitsNeeded()));

        // Contact phone
        holder.tvContactPhone.setText(
                req.getContactPhone() != null ? req.getContactPhone() : "—");

        // Time ago
        holder.tvTimeAgo.setText(TimeUtils.getTimeAgo(req.getCreatedAt()));

        // Urgency tag (text + background + text color)
        applyUrgencyTag(holder, req.getUrgency(), ctx);

        // Item click → detail screen
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onRequestClick(req);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // ------------------------------------------------------------------
    // Data management
    // ------------------------------------------------------------------

    public void setData(List<BloodRequest> newItems) {
        this.items    = new ArrayList<>(newItems);
        this.allItems = new ArrayList<>(newItems);
        notifyDataSetChanged();
    }

    public void filter(String query) {
        if (query == null || query.trim().isEmpty()) {
            items = new ArrayList<>(allItems);
        } else {
            String q = query.trim().toLowerCase();
            List<BloodRequest> filtered = new ArrayList<>();
            for (BloodRequest r : allItems) {
                boolean matchBlood    = r.getBloodGroupNeeded() != null
                        && r.getBloodGroupNeeded().toLowerCase().contains(q);
                boolean matchHospital = r.getHospitalName() != null
                        && r.getHospitalName().toLowerCase().contains(q);
                if (matchBlood || matchHospital) filtered.add(r);
            }
            items = filtered;
        }
        notifyDataSetChanged();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    // ------------------------------------------------------------------
    // Urgency tag styling
    // ------------------------------------------------------------------

    private void applyUrgencyTag(ViewHolder holder, String urgency,
                                  android.content.Context ctx) {
        if (urgency == null) urgency = Constants.URGENCY_NORMAL;
        switch (urgency) {
            case Constants.URGENCY_CRITICAL:
                holder.tvUrgency.setText(R.string.urgency_critical);
                holder.tvUrgency.setBackgroundResource(R.drawable.bg_tag_critical);
                holder.tvUrgency.setTextColor(ctx.getColor(R.color.colorCritical));
                break;
            case Constants.URGENCY_URGENT:
                holder.tvUrgency.setText(R.string.urgency_urgent);
                holder.tvUrgency.setBackgroundResource(R.drawable.bg_tag_urgent);
                holder.tvUrgency.setTextColor(ctx.getColor(R.color.colorUrgent));
                break;
            default:
                holder.tvUrgency.setText(R.string.urgency_normal);
                holder.tvUrgency.setBackgroundResource(R.drawable.bg_tag_normal);
                holder.tvUrgency.setTextColor(ctx.getColor(R.color.colorNormal));
                break;
        }
    }

    // ------------------------------------------------------------------
    // ViewHolder
    // ------------------------------------------------------------------

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBloodGroup, tvHospital, tvUnits, tvUrgency, tvContactPhone, tvTimeAgo;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBloodGroup    = itemView.findViewById(R.id.tvBloodGroup);
            tvHospital      = itemView.findViewById(R.id.tvHospital);
            tvUnits         = itemView.findViewById(R.id.tvUnits);
            tvUrgency       = itemView.findViewById(R.id.tvUrgency);
            tvContactPhone  = itemView.findViewById(R.id.tvContactPhone);
            tvTimeAgo       = itemView.findViewById(R.id.tvTimeAgo);
        }
    }
}
