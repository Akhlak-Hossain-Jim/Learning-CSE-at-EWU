package com.lifeflow.app.utils;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Parses Supabase error response bodies and returns user-friendly messages.
 *
 * Supabase error format:
 *   {"code": "...", "message": "...", "hint": "..."}
 * or GoTrue format:
 *   {"error": "invalid_grant", "error_description": "..."}
 */
public final class ApiErrorHandler {

    private ApiErrorHandler() {}

    /**
     * Extracts a human-readable error message from a failed Retrofit response.
     * Falls back to a generic message if parsing fails.
     */
    public static String getErrorMessage(Response<?> response, String fallback) {
        ResponseBody errorBody = response.errorBody();
        if (errorBody == null) return fallback;
        try {
            String raw = errorBody.string();
            JSONObject json = new JSONObject(raw);

            // GoTrue / Auth error format
            if (json.has("error_description")) {
                return json.getString("error_description");
            }
            // PostgREST error format
            if (json.has("message")) {
                return json.getString("message");
            }
            // Generic Supabase error
            if (json.has("error")) {
                return json.getString("error");
            }
        } catch (IOException | org.json.JSONException ignored) {}
        return fallback;
    }
}
