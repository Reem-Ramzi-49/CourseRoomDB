package com.example.courseroomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
      void  insertStudent (Student student);

    @Delete
        void  deleteStudent (Student student);
    @Update
        void  updateStudent (Student student);

    @Query("Select * from StudentTable")
    LiveData<List<Student>> getAllStudent () ;

  @Query("Select * from StudentTable where courseId = :CourseId")
    LiveData<List<Student>> getStudentByCourseId (int CourseId) ;


}
