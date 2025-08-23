package com.example.courseroomdb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseroomdb.databinding.StudentItemBinding;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StudentItemBinding binding1 = StudentItemBinding.inflate
                (LayoutInflater.from(parent.getContext()), parent, false);
        return new StudentViewHolder(binding1);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        int pos =position ;
        Student s =students.get(pos);
        holder.binding.tvName.setText(s.getName());
        holder.binding.tvDepartment.setText(s.getDepartment());
        holder.binding.tvCourseOfStudent.setText("Course Num : " + s.getCourseId());

        if (s.getDateOfBirth() != null) {
             CharSequence shown = android.text.format.DateFormat.format("dd/MM/yyyy", s.getDateOfBirth());
            holder.binding.tvDate.setText(shown);
        } else {
            holder.binding.tvDate.setText("—");
        }

        Bitmap bmp = Converter.getByteAsBitmap(s.getPhoto());
        if (bmp != null) {
            holder.binding.img.setImageBitmap(bmp);
        } else {
            holder.binding.img.setImageResource(R.drawable.ic_launcher_foreground);
        }
     }

    @Override
    public int getItemCount() {
        return students.size();
    }


    public void setStudents(List<Student> newList) {
        this.students = newList;
        notifyDataSetChanged();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        private final StudentItemBinding binding;

        public StudentViewHolder(StudentItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

//        public void bind(Student student) {
//            binding.tvName.setText(student.getName());
//            binding.tvDepartment.setText(student.getDepartment());
//            binding.tvCourseOfStudent.setText("Coures Num : " + student.getCourseId());
//
//            if (student.getDateOfBirth() != null) {
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
//                binding.tvDate.setText(sdf.format(student.getDateOfBirth()));
//            }
//
//
//            byte[] photoBytes = student.getPhoto();
//            if (photoBytes != null) {
//                Bitmap bmp = BitmapFactory.decodeByteArray(photoBytes, 0, photoBytes.length);
//                binding.img.setImageBitmap(bmp);
//            } else {
//                binding.img.setImageResource(R.drawable.ic_launcher_foreground);
//            }
//        }
    }
}
