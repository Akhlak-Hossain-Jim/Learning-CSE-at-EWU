package com.lifeflow.app.data.api;

import com.lifeflow.app.data.model.AuthRequest;
import com.lifeflow.app.data.model.AuthResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Retrofit interface for Supabase GoTrue authentication endpoints.
 *
 * Signup:  POST /auth/v1/signup
 * Login:   POST /auth/v1/token?grant_type=password
 */
public interface AuthService {

    /**
     * Register a new user with email and password.
     * Returns an AuthResponse containing access_token, refresh_token, and user object.
     */
    @POST("auth/v1/signup")
    Call<AuthResponse> signup(@Body AuthRequest request);

    /**
     * Log in with email and password.
     * Returns an AuthResponse containing access_token, refresh_token, and user object.
     */
    @POST("auth/v1/token?grant_type=password")
    Call<AuthResponse> login(@Body AuthRequest request);
}
