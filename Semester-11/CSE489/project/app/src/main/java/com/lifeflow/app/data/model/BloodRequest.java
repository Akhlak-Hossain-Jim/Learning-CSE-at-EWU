package com.lifeflow.app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Maps to the public.blood_requests table in Supabase.
 */
public class BloodRequest {

    @SerializedName("id")
    private String id;

    @SerializedName("requester_id")
    private String requesterId;

    @SerializedName("blood_group_needed")
    private String bloodGroupNeeded;

    @SerializedName("units_needed")
    private Integer unitsNeeded;

    @SerializedName("hospital_name")
    private String hospitalName;

    @SerializedName("urgency")
    private String urgency;

    @SerializedName("contact_phone")
    private String contactPhone;

    @SerializedName("notes")
    private String notes;

    @SerializedName("is_fulfilled")
    private Boolean isFulfilled;

    @SerializedName("created_at")
    private String createdAt;

    // Default constructor required for Gson deserialization
    public BloodRequest() {}

    // Getters
    public String getId() { return id; }
    public String getRequesterId() { return requesterId; }
    public String getBloodGroupNeeded() { return bloodGroupNeeded; }
    public int getUnitsNeeded() { return unitsNeeded != null ? unitsNeeded : 1; }
    public String getHospitalName() { return hospitalName; }
    public String getUrgency() { return urgency; }
    public String getContactPhone() { return contactPhone; }
    public String getNotes() { return notes; }
    public boolean getIsFulfilled() { return isFulfilled != null ? isFulfilled : false; }
    public String getCreatedAt() { return createdAt; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setRequesterId(String requesterId) { this.requesterId = requesterId; }
    public void setBloodGroupNeeded(String bloodGroupNeeded) { this.bloodGroupNeeded = bloodGroupNeeded; }
    public void setUnitsNeeded(Integer unitsNeeded) { this.unitsNeeded = unitsNeeded; }
    public void setHospitalName(String hospitalName) { this.hospitalName = hospitalName; }
    public void setUrgency(String urgency) { this.urgency = urgency; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }
    public void setNotes(String notes) { this.notes = notes; }
    public void setIsFulfilled(Boolean isFulfilled) { this.isFulfilled = isFulfilled; }
}
