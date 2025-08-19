package com.example.courseroomdb;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.courseroomdb.databinding.ActivityCoursesAddBinding;

public class courses_add extends AppCompatActivity {

    ActivityCoursesAddBinding binding;
    MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCoursesAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        binding.btnSaveCourse.setOnClickListener(v -> {
            String name = binding.etCourseName.getText().toString().trim();
            String countText = binding.etStudentsCount.getText().toString().trim();

            if (name.isEmpty()) {
                binding.etCourseName.setError("Enter course name");
                return;
            }

            int count = countText.isEmpty() ? 0 : Integer.parseInt(countText);

             Course course = new Course(name, count);
            viewModel.insertCourse(course);

            Toast.makeText(this, "Course added successfully", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
