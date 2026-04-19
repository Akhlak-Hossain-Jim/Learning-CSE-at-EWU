package com.lifeflow.app.data.api;

import com.lifeflow.app.data.model.BloodRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Retrofit interface for Supabase PostgREST /rest/v1/blood_requests endpoint.
 */
public interface RequestService {

    /**
     * Fetch all active (unfulfilled) blood requests, newest first.
     * GET /rest/v1/blood_requests?is_fulfilled=eq.false&order=created_at.desc
     */
    @GET("rest/v1/blood_requests")
    Call<List<BloodRequest>> getActiveRequests(
            @Query("is_fulfilled") String isFulfilled,
            @Query("order") String order
    );

    /**
     * Fetch all requests made by a specific user.
     * GET /rest/v1/blood_requests?requester_id=eq.{userId}&order=created_at.desc
     */
    @GET("rest/v1/blood_requests")
    Call<List<BloodRequest>> getRequestsByUser(
            @Query("requester_id") String requesterIdFilter,
            @Query("order") String order
    );

    /**
     * Fetch active request count for the home dashboard.
     * Prefer: count=exact → read Content-Range response header for total.
     */
    @Headers("Prefer: count=exact")
    @GET("rest/v1/blood_requests")
    Call<List<BloodRequest>> getActiveRequestCount(
            @Query("is_fulfilled") String isFulfilled
    );

    /**
     * Create a new blood request.
     * POST /rest/v1/blood_requests
     * Prefer: return=representation → returns the inserted row.
     */
    @Headers("Prefer: return=representation")
    @POST("rest/v1/blood_requests")
    Call<List<BloodRequest>> createRequest(@Body BloodRequest request);

    /**
     * Update an existing blood request (e.g. mark as fulfilled).
     * PATCH /rest/v1/blood_requests?id=eq.{requestId}
     */
    @Headers("Prefer: return=representation")
    @PATCH("rest/v1/blood_requests")
    Call<List<BloodRequest>> updateRequest(
            @Query("id") String idFilter,
            @Body BloodRequest request
    );

    /**
     * Delete a blood request by ID.
     * DELETE /rest/v1/blood_requests?id=eq.{requestId}
     * RLS ensures only the requester can delete their own row.
     */
    @DELETE("rest/v1/blood_requests")
    Call<Void> deleteRequest(@Query("id") String idFilter);
}
