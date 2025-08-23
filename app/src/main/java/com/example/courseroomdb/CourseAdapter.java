package com.example.courseroomdb;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseroomdb.databinding.CourseItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private List<Course> courseList = new ArrayList<>();

    public CourseAdapter(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setCourses(List<Course> courses) {
        this.courseList = courses;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CourseItemBinding binding = CourseItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new CourseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course c = courseList.get(position);

        holder.binding.tvName.setText(c.getCourseName());
        holder.binding.tvCount.setText("Students: " + c.getNoOfStudents());


    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

     class CourseViewHolder extends RecyclerView.ViewHolder {
        private final CourseItemBinding binding;

        public CourseViewHolder(CourseItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }





     }
}
