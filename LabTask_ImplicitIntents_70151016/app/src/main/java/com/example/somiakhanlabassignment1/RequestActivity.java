package com.example.somiakhanlabassignment1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        TextView tvGreeting = findViewById(R.id.tvGreeting);
        EditText etPhone = findViewById(R.id.etPhone);
        Button btnCallNumber = findViewById(R.id.btnCallNumber);
        EditText etLink = findViewById(R.id.etLink);
        Button btnOpenLink = findViewById(R.id.btnOpenLink);

        String name = getIntent().getStringExtra(MainActivity.EXTRA_NAME);
        if (name == null || name.isEmpty()) {
            name = "Student";
        }
        tvGreeting.setText("Hello, " + name + "! How can we help you today?");

        btnCallNumber.setOnClickListener(v -> {
            String number = etPhone.getText().toString().trim();
            if (number.length() == 11 && number.startsWith("03")) {
                MainActivity.openIntent(this, new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number)));
            } else {
                etPhone.setError("Enter 11 digits starting with 03");
            }
        });

        btnOpenLink.setOnClickListener(v -> {
            String link = etLink.getText().toString().trim();
            if (link.isEmpty()) {
                etLink.setError("Please enter a link");
                return;
            }
            if (!link.startsWith("http://") && !link.startsWith("https://")) {
                link = "https://" + link;
            }
            MainActivity.openIntent(this, new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
        });
    }
}