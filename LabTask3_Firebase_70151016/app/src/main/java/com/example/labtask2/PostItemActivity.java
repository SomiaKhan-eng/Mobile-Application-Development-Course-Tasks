package com.example.labtask2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostItemActivity extends AppCompatActivity {

    EditText etItemName, etLocation, etContact;
    RadioGroup rgType;
    Button btnPost;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_item);
        setTitle("Post an Item");

        etItemName = findViewById(R.id.etItemName);
        etLocation = findViewById(R.id.etLocation);
        etContact = findViewById(R.id.etContact);
        rgType = findViewById(R.id.rgType);
        btnPost = findViewById(R.id.btnPost);

        ref = FirebaseDatabase.getInstance("https://lab-task-02-95da3-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("LostFound");

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postItem();
            }
        });
    }

    private void postItem() {
        String name = etItemName.getText().toString().trim();
        String location = etLocation.getText().toString().trim();
        String contact = etContact.getText().toString().trim();

        // empty fields are not allowed
        if (name.isEmpty()) {
            etItemName.setError("Item name is required");
            return;
        }
        if (location.isEmpty()) {
            etLocation.setError("Location is required");
            return;
        }
        if (contact.isEmpty()) {
            etContact.setError("Contact is required");
            return;
        }

        String type = "Lost";
        if (rgType.getCheckedRadioButtonId() == R.id.rbFound) {
            type = "Found";
        }

        // push() makes a new unique key
        String key = ref.push().getKey();
        LostItem item = new LostItem(key, name, type, location, contact, "Open");

        ref.child(key).setValue(item).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(PostItemActivity.this, "Item posted", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(PostItemActivity.this,
                            task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
