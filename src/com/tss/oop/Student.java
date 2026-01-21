package com.tss.oop;


import java.util.Random;
import java.util.zip.CheckedOutputStream;

public class Student {
    private int id = 0;
    private String name = "";
    private Course courses[] = new Course[3];
    private int totalCourse = 0;
    private double totalFees = 0;
    private double feesPaid = 0;

    public void setCourses(Course course) {
        this.courses[totalCourse++] = course;
    }

    public Course[]  getCourse() {
        return this.courses;
    }

    public int getId() {
        return id;
    }

    public int getTotalCourse() {
        return this.totalCourse;
    }
    public double getTotalFees() {
        return this.totalFees;
    }

    public double getFeesPaid() {
        return this.feesPaid;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees += totalFees;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid += feesPaid;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}