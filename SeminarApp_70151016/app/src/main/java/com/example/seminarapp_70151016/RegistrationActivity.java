package com.example.seminarapp_70151016;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    EditText editName, editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
    }

    public void registerStudent(View view) {
        String name = editName.getText().toString();
        String email = editEmail.getText().toString();

        Registration registration = new Registration(name, email);

        if (!registration.isValid()) {
            Toast.makeText(this, "Please enter a valid name and email",
                    Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(RegistrationActivity.this, ConfirmationActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            startActivity(intent);
        }
    }
}