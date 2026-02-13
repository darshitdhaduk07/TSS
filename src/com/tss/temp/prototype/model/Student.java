package com.tss.temp.prototype.model;

public class Student {
    private  int id;
    private String name;
    private int age;
    private static int counter = 0;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++counter;
    }

    public Student clone() {
        Student student = new Student(this.name, this.age);
        student.id = this.id;
        return student;
    }

    public String toString()
    {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
