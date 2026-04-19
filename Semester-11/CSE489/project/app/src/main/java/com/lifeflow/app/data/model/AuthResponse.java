package com.lifeflow.app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Response body from Supabase Auth signup and login endpoints.
 *
 * Relevant fields extracted from the GoTrue JWT response:
 *   access_token  — Bearer token for all subsequent API calls
 *   refresh_token — Used to obtain a new access_token when it expires
 *   user.id       — The auth user's UUID (matches profiles.id)
 */
public class AuthResponse {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private int expiresIn;

    @SerializedName("user")
    private AuthUser user;

    public String getAccessToken() { return accessToken; }
    public String getRefreshToken() { return refreshToken; }
    public String getTokenType() { return tokenType; }
    public int getExpiresIn() { return expiresIn; }
    public AuthUser getUser() { return user; }

    // ------------------------------------------------------------------
    // Nested user object
    // ------------------------------------------------------------------

    public static class AuthUser {

        @SerializedName("id")
        private String id;

        @SerializedName("email")
        private String email;

        public String getId() { return id; }
        public String getEmail() { return email; }
    }
}
