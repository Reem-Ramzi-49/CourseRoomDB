package com.example.courseroomdb;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.courseroomdb.databinding.ActivityCoursesViewBinding;

import java.util.ArrayList;

public class courses_view extends AppCompatActivity {

    ActivityCoursesViewBinding binding;
    CourseAdapter adapter;
    MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityCoursesViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new CourseAdapter(new ArrayList<>());
        binding.rvCourses.setAdapter(adapter);
        binding.rvCourses.setLayoutManager(new LinearLayoutManager(this));

         viewModel = new ViewModelProvider(this).get(MyViewModel.class);

         viewModel.getAllCourse().observe(this, courses -> {
            adapter.setCourses(courses);
        });


        binding.btnAddCourse.setOnClickListener(v -> {
            Intent intent = new Intent(courses_view.this, courses_add.class);
            startActivity(intent);
        });


    }
}
