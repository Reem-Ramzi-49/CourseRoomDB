package com.example.courseroomdb;

import android.app.DatePickerDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.courseroomdb.databinding.ActivityStudentAddBinding;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class student_add extends AppCompatActivity {
    ActivityStudentAddBinding binding;
    MyViewModel viewModel;
    byte[] imageBytes = null;
    int selectedCourseId = -1;
    Date selectedDob = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityStudentAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);


        viewModel.getAllCourse().observe(this, courses -> {
            List<String> courseNames = new ArrayList<>();
            for (Course c : courses) {
                courseNames.add(c.getCourseName());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, courseNames);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            binding.spinnerCourses.setAdapter(adapter);

            binding.spinnerCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    selectedCourseId = courses.get(position).getCourseId();
                }
                @Override public void onNothingSelected(AdapterView<?> parent) {}
            });
        });

         ActivityResultLauncher<String> imagePicker = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri != null) {
                        binding.imgPreview.setImageURI(uri);
                        imageBytes = uriToBytes(uri);
                    }
                });
        binding.btnChooseImage.setOnClickListener(v -> imagePicker.launch("image/*"));

         binding.etDob.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog dp = new DatePickerDialog(this, (view, year, month, day) -> {
                Calendar c = Calendar.getInstance();
                c.set(year, month, day);
                selectedDob = c.getTime();
                binding.etDob.setText(day + "/" + (month+1) + "/" + year);
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            dp.show();
        });


         binding.btnSaveStudent.setOnClickListener(v -> {
            String name = binding.etName.getText().toString().trim();
            String dept = binding.etDepartment.getText().toString().trim();

            if (name.isEmpty() || dept.isEmpty() || selectedCourseId == -1 || selectedDob == null) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Student student = new Student(name, dept, selectedDob, imageBytes, selectedCourseId);
            viewModel.insertStudent(student);
            finish();
        });
    }

    private byte[] uriToBytes(Uri uri) {
        try {
            InputStream inputStream = getContentResolver().openInputStream(uri);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            return stream.toByteArray();
        } catch (Exception e) { e.printStackTrace(); return null; }
    }
}
