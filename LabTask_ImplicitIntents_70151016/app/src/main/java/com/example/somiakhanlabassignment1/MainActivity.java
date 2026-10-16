package com.example.somiakhanlabassignment1;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra_name";

    public static void openIntent(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "No app found for this action", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etName = findViewById(R.id.etName);
        Button btnWebsite = findViewById(R.id.btnWebsite);
        Button btnCall = findViewById(R.id.btnCall);
        Button btnMap = findViewById(R.id.btnMap);
        Button btnRequest = findViewById(R.id.btnRequest);

        btnWebsite.setOnClickListener(v ->
                openIntent(this, new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uol.edu.pk"))));

        btnCall.setOnClickListener(v ->
                openIntent(this, new Intent(Intent.ACTION_DIAL, Uri.parse("tel:04212345678"))));

        btnMap.setOnClickListener(v ->
                openIntent(this, new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=University+of+Lahore"))));

        btnRequest.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            if (name.isEmpty()) {
                etName.setError("Please enter your name");
            } else {
                Intent intent = new Intent(this, RequestActivity.class);
                intent.putExtra(EXTRA_NAME, name);
                startActivity(intent);
            }
        });
    }
}