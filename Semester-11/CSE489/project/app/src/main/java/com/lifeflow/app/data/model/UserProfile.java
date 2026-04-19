package com.lifeflow.app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Maps to the public.profiles table in Supabase.
 * Used for both reading donor/recipient profiles and writing profile updates.
 */
public class UserProfile {

    @SerializedName("id")
    private String id;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("email")
    private String email;

    @SerializedName("phone")
    private String phone;

    @SerializedName("role")
    private String role;

    @SerializedName("blood_group")
    private String bloodGroup;

    @SerializedName("city")
    private String city;

    @SerializedName("district")
    private String district;

    @SerializedName("is_available")
    private Boolean isAvailable;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    // Default constructor required for Gson deserialization
    public UserProfile() {}

    // Getters
    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getRole() { return role; }
    public String getBloodGroup() { return bloodGroup; }
    public String getCity() { return city; }
    public String getDistrict() { return district; }
    public Boolean getIsAvailable() { return isAvailable != null ? isAvailable : true; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setRole(String role) { this.role = role; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public void setCity(String city) { this.city = city; }
    public void setDistrict(String district) { this.district = district; }
    public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }

    /**
     * Returns a display-friendly location string, e.g. "Dhaka, Dhaka District"
     * or just the city/district if only one is available.
     */
    public String getLocationDisplay() {
        if (city != null && district != null && !city.isEmpty() && !district.isEmpty()) {
            return city + ", " + district;
        } else if (city != null && !city.isEmpty()) {
            return city;
        } else if (district != null && !district.isEmpty()) {
            return district;
        }
        return "Location not set";
    }
}
