package com.example.uolcoursecatalogue;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements CourseAdapter.OnItemClickListener {

    public static final String EXTRA_CODE = "extra_code";
    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_INSTRUCTOR = "extra_instructor";
    public static final String EXTRA_EMAIL = "extra_email";
    public static final String EXTRA_DESCRIPTION = "extra_description";
    public static final String EXTRA_CREDITS = "extra_credits";

    private ArrayList<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courses = new ArrayList<>();
        courses.add(new Course("CS02310", "Mobile Application Development", "Muhammad Arslan",
                "muhammad.arslan@se.uol.edu.pk", "Building Android apps using Java and Android Studio.", 3));
        courses.add(new Course("CODE-2", "Software Project Management", "Shahid Saleem",
                "shahid.saleem@se.uol.edu.pk", "Planning, scheduling, risk and team management for software projects.", 3));
        courses.add(new Course("CODE-3", "Software Quality Engineering", "Aisha Younas",
                "aisha.younas@se.uol.edu.pk", "Testing techniques, quality assurance and standards.", 3));
        courses.add(new Course("CODE-4", "Human Resource Management", "Maryam Rana",
                "maryam.rana@se.uol.edu.pk", "Managing people, recruitment and organizational behavior.", 3));
        courses.add(new Course("CODE-5", "Career Development Course", "Aaleen Shafaat",
                "aaleen.shafaat@cso.uol.edu.pk", "Professional skills, resumes, interviews and elevator pitches.", 1));
        courses.add(new Course("CODE-6", "Artificial Intelligence", "Ume Habiba",
                "ume.habiba@se.uol.edu.pk", "Search, knowledge representation and basic machine learning.", 3));
        courses.add(new Course("CODE-7", "Data Warehousing and Data Mining", "Ammar Zia",
                "ammar.zia@se.uol.edu.pk", "Building data warehouses and finding patterns in large datasets.", 3));
        courses.add(new Course("CODE-8", "Database Systems", "Babar Imran",
                "babar.imran@se.uol.edu.pk", "Relational model, SQL and normalization.", 3));
        courses.add(new Course("CODE-9", "Human Computer Interaction", "Mujahid Rafiq",
                "mujahid.rafiq@se.uol.edu.pk", "Designing usable interfaces and evaluating them with users.", 3));


        RecyclerView rvCourses = findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(new LinearLayoutManager(this));
        rvCourses.setAdapter(new CourseAdapter(courses, this));
    }

    @Override
    public void onItemClick(int position) {
        Course clicked = courses.get(position);
        Intent intent = new Intent(this, CourseDetailActivity.class);
        intent.putExtra(EXTRA_CODE, clicked.getCode());
        intent.putExtra(EXTRA_TITLE, clicked.getTitle());
        intent.putExtra(EXTRA_INSTRUCTOR, clicked.getInstructor());
        intent.putExtra(EXTRA_EMAIL, clicked.getEmail());
        intent.putExtra(EXTRA_DESCRIPTION, clicked.getDescription());
        intent.putExtra(EXTRA_CREDITS, clicked.getCreditHours());
        startActivity(intent);
    }
}