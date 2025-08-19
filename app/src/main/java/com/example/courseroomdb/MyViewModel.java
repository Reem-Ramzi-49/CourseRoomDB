package com.example.courseroomdb;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    MyRepository myRepository ;
    public MyViewModel(@NonNull Application application) {
        super(application);
        myRepository =new MyRepository(application);
    }



    void  insertStudent (Student student) {
             myRepository.insertStudent(student);
     }

    void  deleteStudent (Student student) {
        myRepository.deleteStudent(student);
     }

    void  updateStudent (Student student) {
        myRepository.updateStudent(student);

    }

    LiveData<List<Student>> getAllStudent () {
        return myRepository.getAllStudent();
    }

    LiveData<List<Student>> getStudentByCourseId (int CourseId)  {
        return myRepository.getStudentByCourseId(CourseId);
    }



     void  insertCourse (Course course) {
        myRepository.insertCourse(course);

    }


    void  deleteCourse (Course course){
        myRepository.deleteCourse(course);


    }

    void  updateCourse (Course course) {
        myRepository.updateCourse(course);

    }

    LiveData<List<Course>> getAllCourse () {
        return myRepository.getAllCourse();
    }


    LiveData<List<Course>> getCourseById (int CourseId){
        return myRepository.getCourseById(CourseId);
    }



}
