package com.lifeflow.app.utils;

public final class Constants {

    private Constants() {
    }

    // ------------------------------------------------------------------
    // Supabase project credentials
    // Replace these two values with your actual Supabase project details:
    // Dashboard → Settings → API → Project URL / anon public key
    // ------------------------------------------------------------------
    public static final String SUPABASE_URL = "https://zurroucufmvqfbntbqxb.supabase.co";
    public static final String SUPABASE_ANON_KEY = "sb_publishable_n0UQIJwF3FXyuMxdZ2KTdw_q3QEaKO7";

    // ------------------------------------------------------------------
    // Supabase REST endpoints (derived from SUPABASE_URL — do not edit)
    // ------------------------------------------------------------------
    public static final String AUTH_SIGNUP = SUPABASE_URL + "/auth/v1/signup";
    public static final String AUTH_LOGIN = SUPABASE_URL + "/auth/v1/token?grant_type=password";
    public static final String REST_BASE_URL = SUPABASE_URL + "/rest/v1/";

    // ------------------------------------------------------------------
    // Table names
    // ------------------------------------------------------------------
    public static final String TABLE_PROFILES = "profiles";
    public static final String TABLE_BLOOD_REQUESTS = "blood_requests";

    // ------------------------------------------------------------------
    // SharedPreferences
    // ------------------------------------------------------------------
    public static final String PREFS_NAME = "lifeflow_prefs";
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_REFRESH_TOKEN = "refresh_token";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_USER_ROLE = "user_role";
    public static final String KEY_USER_NAME = "user_name";
    public static final String KEY_BLOOD_GROUP = "blood_group";

    // ------------------------------------------------------------------
    // User roles
    // ------------------------------------------------------------------
    public static final String ROLE_DONOR = "donor";
    public static final String ROLE_RECIPIENT = "recipient";

    // ------------------------------------------------------------------
    // Urgency levels
    // ------------------------------------------------------------------
    public static final String URGENCY_NORMAL = "normal";
    public static final String URGENCY_URGENT = "urgent";
    public static final String URGENCY_CRITICAL = "critical";

    // ------------------------------------------------------------------
    // Intent extras keys
    // ------------------------------------------------------------------
    public static final String EXTRA_DONOR_ID = "extra_donor_id";
    public static final String EXTRA_PROFILE = "extra_profile";
}
