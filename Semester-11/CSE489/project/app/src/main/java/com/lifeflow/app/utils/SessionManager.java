package com.lifeflow.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Manages the user's auth session using SharedPreferences.
 *
 * Stores: access_token, refresh_token, user_id, user_role, user_name, blood_group.
 * All Activities and Fragments that need auth state should use this class.
 */
public class SessionManager {

    private final SharedPreferences prefs;
    private final SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        prefs = context.getApplicationContext()
                .getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    // ------------------------------------------------------------------
    // Save session after login / signup
    // ------------------------------------------------------------------

    /**
     * Persist the full auth session returned by Supabase.
     */
    public void saveSession(String accessToken, String refreshToken, String userId) {
        editor.putString(Constants.KEY_ACCESS_TOKEN, accessToken);
        editor.putString(Constants.KEY_REFRESH_TOKEN, refreshToken);
        editor.putString(Constants.KEY_USER_ID, userId);
        editor.apply();
    }

    /**
     * Save the user's role (donor / recipient) after fetching the profile.
     */
    public void saveRole(String role) {
        editor.putString(Constants.KEY_USER_ROLE, role);
        editor.apply();
    }

    /**
     * Save the user's display name and blood group for quick access on the home screen.
     */
    public void saveUserDetails(String name, String bloodGroup) {
        editor.putString(Constants.KEY_USER_NAME, name);
        editor.putString(Constants.KEY_BLOOD_GROUP, bloodGroup);
        editor.apply();
    }

    // ------------------------------------------------------------------
    // Read session values
    // ------------------------------------------------------------------

    public String getToken() {
        return prefs.getString(Constants.KEY_ACCESS_TOKEN, null);
    }

    public String getRefreshToken() {
        return prefs.getString(Constants.KEY_REFRESH_TOKEN, null);
    }

    public String getUserId() {
        return prefs.getString(Constants.KEY_USER_ID, null);
    }

    public String getRole() {
        return prefs.getString(Constants.KEY_USER_ROLE, null);
    }

    public String getUserName() {
        return prefs.getString(Constants.KEY_USER_NAME, null);
    }

    public String getBloodGroup() {
        return prefs.getString(Constants.KEY_BLOOD_GROUP, null);
    }

    // ------------------------------------------------------------------
    // Auth state helpers
    // ------------------------------------------------------------------

    /**
     * Returns true if a valid access token is stored (user is logged in).
     */
    public boolean isLoggedIn() {
        String token = getToken();
        return token != null && !token.isEmpty();
    }

    /**
     * Returns true if the current user has the donor role.
     */
    public boolean isDonor() {
        return Constants.ROLE_DONOR.equals(getRole());
    }

    /**
     * Returns true if the current user has the recipient role.
     */
    public boolean isRecipient() {
        return Constants.ROLE_RECIPIENT.equals(getRole());
    }

    // ------------------------------------------------------------------
    // Clear session on logout
    // ------------------------------------------------------------------

    /**
     * Wipes all stored session data. Call before navigating to WelcomeActivity.
     */
    public void clearSession() {
        editor.clear();
        editor.apply();
    }
}
