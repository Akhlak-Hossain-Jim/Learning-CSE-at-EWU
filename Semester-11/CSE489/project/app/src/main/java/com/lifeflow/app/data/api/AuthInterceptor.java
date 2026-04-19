package com.lifeflow.app.data.api;

import android.content.Context;
import android.content.Intent;

import com.lifeflow.app.ui.auth.WelcomeActivity;
import com.lifeflow.app.utils.Constants;
import com.lifeflow.app.utils.SessionManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttp interceptor that:
 *  1. Injects apikey + Authorization headers on every request.
 *  2. Detects 401 Unauthorized responses → clears session → redirects to WelcomeActivity.
 *
 * Task 6.4.1
 */
public class AuthInterceptor implements Interceptor {

    private final SessionManager sessionManager;
    private final Context appContext;

    public AuthInterceptor(SessionManager sessionManager, Context appContext) {
        this.sessionManager = sessionManager;
        this.appContext     = appContext.getApplicationContext();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String token = sessionManager != null ? sessionManager.getToken() : "";

        Request original = chain.request();
        Request request  = original.newBuilder()
                .header("apikey",         Constants.SUPABASE_ANON_KEY)
                .header("Authorization",  "Bearer " + (token != null ? token : ""))
                .header("Content-Type",   "application/json")
                .method(original.method(), original.body())
                .build();

        Response response = chain.proceed(request);

        // 401 → session is stale; clear and send user back to login
        if (response.code() == 401 && sessionManager != null) {
            sessionManager.clearSession();
            Intent intent = new Intent(appContext, WelcomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            appContext.startActivity(intent);
        }

        return response;
    }
}
