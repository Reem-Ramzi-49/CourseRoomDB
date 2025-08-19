package com.example.courseroomdb;

import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.Date;
@Entity(
        tableName = "StudentTable",
        foreignKeys = @ForeignKey(
                entity = Course.class,
                parentColumns = {"courseId"},
                childColumns = {"courseId"},
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index(value = "courseId")}
)
@TypeConverters(Converter.class)

public class Student {

    @PrimaryKey(autoGenerate = true)
    private  int studentID ;
    private  String name ;
    private  String department ;
    private Date dateOfBirth ;

//    private Bitmap photo ;
private byte[] photo;

    private int courseId ;



    public Student( String name, String department, Date dateOfBirth, byte[] photo, int courseId) {
         this.name = name;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.photo = photo;
        this.courseId = courseId;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
