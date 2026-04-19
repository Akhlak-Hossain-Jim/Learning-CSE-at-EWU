package com.lifeflow.app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Request body for Supabase Auth signup and login endpoints.
 */
public class AuthRequest {

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public AuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
