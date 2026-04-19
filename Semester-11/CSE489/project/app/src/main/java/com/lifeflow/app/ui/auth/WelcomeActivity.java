package com.lifeflow.app.ui.auth;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.lifeflow.app.R;

/**
 * First screen shown to unauthenticated users.
 * Routes to LoginActivity or SignupActivity.
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        MaterialButton btnLogin  = findViewById(R.id.btnLogin);
        MaterialButton btnSignup = findViewById(R.id.btnSignup);

        btnLogin.setOnClickListener(v ->
                startActivity(new Intent(this, LoginActivity.class)));

        btnSignup.setOnClickListener(v ->
                startActivity(new Intent(this, SignupActivity.class)));
    }
}
