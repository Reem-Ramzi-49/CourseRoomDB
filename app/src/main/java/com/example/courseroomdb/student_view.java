package com.example.courseroomdb;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.courseroomdb.databinding.ActivityStudentViewBinding;

import java.util.ArrayList;

public class student_view extends AppCompatActivity {

    ActivityStudentViewBinding binding;
    StudentAdapter studentAdapter;
    CourseAdapter courseAdapter;
    MyViewModel viewModel;

    boolean showingStudents = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityStudentViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        binding.recyclerMain.setLayoutManager(new LinearLayoutManager(this));

        studentAdapter = new StudentAdapter(new ArrayList<>());
        courseAdapter = new CourseAdapter(new ArrayList<>());
        showStudents();


        binding.btnShowStudents.setOnClickListener(v -> showStudents());


        binding.btnShowCourses.setOnClickListener(v -> showCourses());

        binding.btnAdd.setOnClickListener(v -> {
            if (showingStudents) {
                startActivity(new Intent(this, student_add.class));
            } else {
                startActivity(new Intent(this, courses_add.class));
            }
        });
    }

     private void showStudents() {
        showingStudents = true;
        binding.tvTitle.setText("Students List");
        binding.recyclerMain.setAdapter(studentAdapter);

        viewModel.getAllStudent().observe(this, students -> {
            studentAdapter.setStudents(students);
        });
    }

    private void showCourses() {
        showingStudents = false;
        binding.tvTitle.setText("Courses List");
        binding.recyclerMain.setAdapter(courseAdapter);

        viewModel.getAllCourse().observe(this, courses -> {
            courseAdapter.setCourses(courses);
        });
    }
}
