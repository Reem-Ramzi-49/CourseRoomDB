package com.example.courseroomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CourseDao {

    @Insert
    void  insertCourse (Course course);

    @Delete
    void  deleteCourse (Course course);
    @Update
    void  updateCourse (Course course);

    @Query("Select * from CourseTable")
    LiveData<List<Course>> getAllCourse () ;


    @Query("Select * from CourseTable where courseId = :CourseId")
    LiveData<List<Course>> getCourseById (int CourseId) ;



}
