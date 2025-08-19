package com.example.courseroomdb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "CourseTable")
public class Course {

    @PrimaryKey(autoGenerate = true)
    private int courseId;
    private String courseName;
    private int noOfStudents;


    public Course(String courseName, int noOfStudents) {
        this.courseName = courseName;
        this.noOfStudents = noOfStudents;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}
