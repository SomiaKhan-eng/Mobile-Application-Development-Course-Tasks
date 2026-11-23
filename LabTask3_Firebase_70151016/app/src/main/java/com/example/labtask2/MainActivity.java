package com.example.labtask2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView tvEmpty;
    Button btnAdd;

    ArrayList<LostItem> list = new ArrayList<>();
    LostItemAdapter adapter;

    DatabaseReference ref;
    ValueEventListener listener;   // saved so we can remove it later

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("UOL Lost & Found");

        recyclerView = findViewById(R.id.recyclerView);
        tvEmpty = findViewById(R.id.tvEmpty);
        btnAdd = findViewById(R.id.btnAdd);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new LostItemAdapter(list, new LostItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(LostItem item) {
                // only the status child is changed
                ref.child(item.getId()).child("status").setValue("Returned");
            }
        });
        recyclerView.setAdapter(adapter);

        ref = FirebaseDatabase.getInstance("https://lab-task-02-95da3-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("LostFound");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PostItemActivity.class));
            }
        });

        // live listener: runs now and again every time the data changes
        listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot child : snapshot.getChildren()) {
                    LostItem item = child.getValue(LostItem.class);
                    list.add(item);
                }
                // keys are in time order, so reverse to show newest first
                Collections.reverse(list);
                adapter.notifyDataSetChanged();

                if (snapshot.getChildrenCount() == 0) {
                    tvEmpty.setVisibility(View.VISIBLE);
                } else {
                    tvEmpty.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
        ref.addValueEventListener(listener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ref.removeEventListener(listener);
    }
}