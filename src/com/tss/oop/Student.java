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
        if (totalCourse >= 3) {
            System.out.println("You take at most 3 Course can't take more");
            return;
        }

        this.courses[totalCourse] = course;


        this.totalCourse++;
    }

    public void getCourse() {
        System.out.println("------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-10s | %-10s|\n",
                "Course ID", "Course Name", "Fees", "Duration");
        System.out.println("------------------------------------------------------------");
        for (Course course : courses) {
            if (course == null) return;
            System.out.printf("| %-10d | %-20s | %-10.2f | %-10s |\n",
                    course.getId(),
                    course.getName(),
                    course.getPrice(), course.getDuration());
        }
        System.out.println("------------------------------------------------------------");
    }

    public int getId() {
        return id;
    }

    public int getTotalCourse() {
        return totalCourse;
    }
    public void setTotalCourse(int totalCourse)
    {
        this.totalCourse += totalCourse;
    }
    public double getTotalFees() {
        return totalFees;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void setTotalFees(double totalFees) {
        double fees = 0;
        for(Course course:courses)
        {
            if(course == null)
                return;
            else{
                fees += course.getPrice();
            }
        }
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid += feesPaid;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}