/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.langcen.model;

/**
 *
 * @author Shaurya
 */
public class LangCenModel {
    private int StudentId;
    private String Student;
    private String Email;
    private String Phone;
    private String Course;

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public String getStudent() {
        return Student;
    }

    public void setStudent(String Student) {
        this.Student = Student;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }

    public LangCenModel(int StudentId, String Student, String Email, String Phone, String Course) {
        this.StudentId = StudentId;
        this.Student = Student;
        this.Email = Email;
        this.Phone = Phone;
        this.Course = Course;
    }
    
    
}
