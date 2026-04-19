package com.lifeflow.app.ui.profile;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.lifeflow.app.R;

/**
 * Shows payment methods (bKash, Nagad, Rocket, Bank Transfer) so users
 * can donate money to support LifeFlow. Copy buttons put the account
 * number on the clipboard.
 */
public class DonateMoneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_money);

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        String bkash  = getString(R.string.bkash_number);
        String nagad  = getString(R.string.nagad_number);
        String rocket = getString(R.string.rocket_number);
        String bank   = getString(R.string.bank_account_number);

        MaterialButton btnCopyBkash  = findViewById(R.id.btnCopyBkash);
        MaterialButton btnCopyNagad  = findViewById(R.id.btnCopyNagad);
        MaterialButton btnCopyRocket = findViewById(R.id.btnCopyRocket);
        MaterialButton btnCopyBank   = findViewById(R.id.btnCopyBank);

        btnCopyBkash.setOnClickListener(v  -> copyToClipboard("bKash number",  bkash));
        btnCopyNagad.setOnClickListener(v  -> copyToClipboard("Nagad number",  nagad));
        btnCopyRocket.setOnClickListener(v -> copyToClipboard("Rocket number", rocket));
        btnCopyBank.setOnClickListener(v   -> copyToClipboard("Account number", bank));
    }

    private void copyToClipboard(String label, String text) {
        ClipboardManager clipboard =
                (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(ClipData.newPlainText(label, text));
        Toast.makeText(this, label + " copied", Toast.LENGTH_SHORT).show();
    }
}
