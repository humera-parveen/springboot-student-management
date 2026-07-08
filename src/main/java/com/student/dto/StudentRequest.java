package com.student.dto;

import jakarta.validation.constraints.*;

public class StudentRequest {
    @NotNull(message = "Student Name Should Not be null")
    private String studentName;
    @Email(message = "Enter Valid Email Address")
    @NotBlank
    private String email;
    @NotBlank(message = "Course is Required")
    private String course;
    @Min(message = "Minimum fees is 40000", value = 40000)
    @Max(message = "Maximum fees is 70000", value = 70000)
    private int fees;
    @NotBlank(message = "College is Required")
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
