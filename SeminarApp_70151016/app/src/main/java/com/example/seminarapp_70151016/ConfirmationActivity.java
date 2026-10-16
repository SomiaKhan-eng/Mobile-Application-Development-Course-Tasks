package com.example.seminarapp_70151016;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");

        TextView textView = findViewById(R.id.textConfirmation);
        textView.setText("Registration successful\nName: " + name + "\nEmail: " + email);
    }
}