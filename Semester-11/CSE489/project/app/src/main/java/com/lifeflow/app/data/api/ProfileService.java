package com.lifeflow.app.data.api;

import com.lifeflow.app.data.model.UserProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Retrofit interface for Supabase PostgREST /rest/v1/profiles endpoint.
 *
 * PostgREST filtering uses query parameters:
 *   ?role=eq.donor              → WHERE role = 'donor'
 *   ?is_available=eq.true       → WHERE is_available = true
 *   ?id=eq.{uuid}               → WHERE id = '{uuid}'
 *   &order=created_at.desc      → ORDER BY created_at DESC
 */
public interface ProfileService {

    /**
     * Fetch all available donors.
     * GET /rest/v1/profiles?role=eq.donor&is_available=eq.true&order=created_at.desc
     */
    @GET("rest/v1/profiles")
    Call<List<UserProfile>> getDonors(
            @Query("role") String roleFilter,
            @Query("is_available") String isAvailable,
            @Query("order") String order
    );

    /**
     * Fetch a single profile by user ID.
     * GET /rest/v1/profiles?id=eq.{userId}
     */
    @GET("rest/v1/profiles")
    Call<List<UserProfile>> getProfileById(@Query("id") String idFilter);

    /**
     * Insert (or update on conflict) a profile row.
     * POST /rest/v1/profiles
     * resolution=merge-duplicates handles the case where the Supabase
     * handle_new_user trigger already created a skeleton row — the UPSERT
     * overwrites it with the real data supplied by the app.
     */
    @Headers({
        "Prefer: return=representation",
        "Prefer: resolution=merge-duplicates"
    })
    @POST("rest/v1/profiles")
    Call<List<UserProfile>> insertProfile(@Body UserProfile profile);

    /**
     * Update (PATCH) an existing profile row by user ID.
     * PATCH /rest/v1/profiles?id=eq.{userId}
     * Prefer: return=representation  → returns the updated row
     */
    @Headers("Prefer: return=representation")
    @PATCH("rest/v1/profiles")
    Call<List<UserProfile>> updateProfile(
            @Query("id") String idFilter,
            @Body UserProfile profile
    );

    /**
     * Fetch all donors (no filter) — used for count on home dashboard.
     * GET /rest/v1/profiles?role=eq.donor&is_available=eq.true
     * with header Prefer: count=exact → read Content-Range for total count.
     */
    @Headers("Prefer: count=exact")
    @GET("rest/v1/profiles")
    Call<List<UserProfile>> getDonorCount(
            @Query("role") String roleFilter,
            @Query("is_available") String isAvailable
    );
}
