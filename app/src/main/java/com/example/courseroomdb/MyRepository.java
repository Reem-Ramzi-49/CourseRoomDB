package com.example.courseroomdb;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

class MyRepository {

    private StudentDao studentDao;
    private CourseDao courseDao ;


    MyRepository(Application application) {
        MyDataBase db = MyDataBase.getDatabase(application);
        studentDao = db.studentDao();
        courseDao = db.courseDao();

    }



     void  insertStudent (Student student) {
         MyDataBase.databaseWriteExecutor.execute(() -> {
             studentDao.insertStudent(student);
         });
     };

     void  deleteStudent (Student student) {
         MyDataBase.databaseWriteExecutor.execute(() -> {
             studentDao.deleteStudent(student);
         });
     };

    void  updateStudent (Student student) {
        MyDataBase.databaseWriteExecutor.execute(() -> {
            studentDao.updateStudent(student);
        });
    };

     LiveData<List<Student>> getAllStudent () {
         return studentDao.getAllStudent();
     };

     LiveData<List<Student>> getStudentByCourseId (int CourseId)  {
         return studentDao.getStudentByCourseId(CourseId);
     };



     void  insertCourse (Course course) {
        MyDataBase.databaseWriteExecutor.execute(() -> {
            courseDao.insertCourse(course);
        });
    };


    void  deleteCourse (Course course){
        MyDataBase.databaseWriteExecutor.execute(() -> {
            courseDao.deleteCourse(course);
        });

    };

    void  updateCourse (Course course) {
        MyDataBase.databaseWriteExecutor.execute(() -> {
            courseDao.updateCourse(course);
        });
    };

     LiveData<List<Course>> getAllCourse () {
         return courseDao.getAllCourse();
     };


     LiveData<List<Course>> getCourseById (int CourseId){
         return courseDao.getCourseById(CourseId);
     }



}