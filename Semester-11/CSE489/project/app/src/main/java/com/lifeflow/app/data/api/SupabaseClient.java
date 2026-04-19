package com.lifeflow.app.data.api;

import android.content.Context;

import com.lifeflow.app.utils.Constants;
import com.lifeflow.app.utils.SessionManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Singleton Retrofit client wired to the Supabase REST API.
 *
 * Authenticated calls use {@link AuthInterceptor} which:
 *   - Injects apikey + Authorization headers
 *   - Redirects to WelcomeActivity on 401 (Task 6.4.1)
 *
 * Usage:
 *   AuthService    auth    = SupabaseClient.getAuthService();
 *   ProfileService profile = SupabaseClient.getProfileService(sessionManager, context);
 *   RequestService request = SupabaseClient.getRequestService(sessionManager, context);
 */
public class SupabaseClient {

    private SupabaseClient() {}

    // ------------------------------------------------------------------
    // Internal Retrofit builders
    // ------------------------------------------------------------------

    /**
     * Unauthenticated client — for signup / login only.
     * Injects apikey header but no Bearer token.
     */
    private static Retrofit getUnauthenticatedClient() {
        Interceptor apiKeyInterceptor = chain -> {
            Request original = chain.request();
            Request request  = original.newBuilder()
                    .header("apikey",       Constants.SUPABASE_ANON_KEY)
                    .header("Content-Type", "application/json")
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        };

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(apiKeyInterceptor)
                .addInterceptor(logging)
                .build();

        return new Retrofit.Builder()
                .baseUrl(Constants.SUPABASE_URL + "/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Authenticated client — injects token and handles 401 auto-logout.
     */
    private static Retrofit getAuthenticatedClient(SessionManager sessionManager,
                                                    Context context) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor(sessionManager, context))
                .addInterceptor(logging)
                .build();

        return new Retrofit.Builder()
                .baseUrl(Constants.SUPABASE_URL + "/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // ------------------------------------------------------------------
    // Service factories
    // ------------------------------------------------------------------

    /**
     * Auth service — no token needed (signup / login).
     */
    public static AuthService getAuthService() {
        return getUnauthenticatedClient().create(AuthService.class);
    }

    /**
     * Profile service — requires a valid session token.
     */
    public static ProfileService getProfileService(SessionManager sessionManager,
                                                    Context context) {
        return getAuthenticatedClient(sessionManager, context).create(ProfileService.class);
    }

    /**
     * Blood request service — requires a valid session token.
     */
    public static RequestService getRequestService(SessionManager sessionManager,
                                                    Context context) {
        return getAuthenticatedClient(sessionManager, context).create(RequestService.class);
    }

    // ------------------------------------------------------------------
    // Legacy overloads (kept for backwards compatibility with existing call sites)
    // Sessions without context cannot do 401 redirect — use context overloads where available.
    // ------------------------------------------------------------------

    /** @deprecated Prefer {@link #getProfileService(SessionManager, Context)} */
    @Deprecated
    public static ProfileService getProfileService(SessionManager sessionManager) {
        Interceptor authInterceptor = chain -> {
            String token = sessionManager != null ? sessionManager.getToken() : "";
            Request original = chain.request();
            Request request  = original.newBuilder()
                    .header("apikey",        Constants.SUPABASE_ANON_KEY)
                    .header("Authorization", "Bearer " + (token != null ? token : ""))
                    .header("Content-Type",  "application/json")
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        };
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(authInterceptor).build();
        return new Retrofit.Builder()
                .baseUrl(Constants.SUPABASE_URL + "/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProfileService.class);
    }

    /** @deprecated Prefer {@link #getRequestService(SessionManager, Context)} */
    @Deprecated
    public static RequestService getRequestService(SessionManager sessionManager) {
        Interceptor authInterceptor = chain -> {
            String token = sessionManager != null ? sessionManager.getToken() : "";
            Request original = chain.request();
            Request request  = original.newBuilder()
                    .header("apikey",        Constants.SUPABASE_ANON_KEY)
                    .header("Authorization", "Bearer " + (token != null ? token : ""))
                    .header("Content-Type",  "application/json")
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        };
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(authInterceptor).build();
        return new Retrofit.Builder()
                .baseUrl(Constants.SUPABASE_URL + "/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RequestService.class);
    }
}
