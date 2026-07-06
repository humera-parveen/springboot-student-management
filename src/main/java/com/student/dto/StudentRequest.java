package com.student.dto;

public class StudentRequest {
    private String studentName;
    private String email;
    private String course;
    private int fees;
    private String college;

    public StudentRequest(String studentName, String email, String course, int fees, String college) {
        this.studentName = studentName;
        this.email = email;
        this.course = course;
        this.fees = fees;
        this.college = college;
    }

    public StudentRequest() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
