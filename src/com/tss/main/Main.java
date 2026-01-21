package com.tss.main;

import com.tss.oop.Course;
import com.tss.oop.Student;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Course courses[] = new Course[5];
    public static Random random = new Random();
    public static int numberOfCourse = 0;
    public static int numberOfStudent = 0;
    public static int totalNumberOfStudent = 0;
    public static Student students[] = null;
    public static Scanner takeInput = new Scanner(System.in);

    public static Student getStudentById(int id) {
        for (Student student : students) {
            if (student != null && student.getId() == id)
                return student;
        }
        return null;
    }
    public static void createStudent() {

        if (numberOfStudent >= totalNumberOfStudent) {
            System.out.println("Slot Full");
            return;
        }

        System.out.println("Enter name :");
        takeInput.nextLine();
        String name = takeInput.nextLine();


        int id = random.nextInt(1, 100);

        //Duplicate id validation
        while (true) {
            int flag = 0;
            for (Student student : students) {
                if (student != null && student.getId() == id) {

                    id = random.nextInt(1, 1000);
                    flag = 1;

                }
            }
            if (flag == 0)
                break;
        }


        Student student = new Student();
        student.setId(id);
        student.setName(name);

        students[numberOfStudent] = student;
        numberOfStudent++;


    }

    public static void selectCourse() {
        System.out.println("Enter id of Student for select course: ");
        int id = takeInput.nextInt();

        Student student = getStudentById(id);

        while (true)
        {
            if(student == null)
            {
                System.out.println("Enter Valid id:");
                id = takeInput.nextInt();

                student = getStudentById(id);
            }
            else break;
        }

        if(student.getTotalCourse() >= 3){
            System.out.println("You take Maximum Course");
            return;
        }

        displayAllCourse();

        System.out.println("Enter id that you want to add");
        int tempId = takeInput.nextInt();

        while (true) {
            for (Course course : courses) {
                if (course != null && course.getId() == tempId) {
                    student.setCourses(course);
                    return;
                }
            }
            System.out.println("Please Enter valid id");
        }

    }


    public static void displayStudentDetails(Student student) {

        System.out.println("+----------------------------+");
        System.out.printf ("| %-26s |\n", "STUDENT DETAILS");
        System.out.println("+----------------------------+");
        System.out.printf ("| %-12s : %-9d |\n", "Student ID", student.getId());
        System.out.printf ("| %-12s : %-9s |\n", "Name", student.getName());
        System.out.println("+----------------------------+");

        System.out.println("\nSTUDENT COURSES");
        student.getCourse();
    }

    public static void displayAllStudentDetails()
    {
        if(numberOfStudent == 0){
            System.out.println("There is no Student");
            return;
        }
        for (Student student:students)
        {
            if(student == null)
                return;
            else {
                displayStudentDetails(student);
            }
        }
    }
    public static void displayAllCourse() {

        System.out.println("+-----------------------------------------------------------+");
        System.out.printf("| %-10s | %-20s | %-10s | %-10s |\n",
                "Course ID", "Course Name", "Fees", "Duration");
        System.out.println("+-----------------------------------------------------------+");

        for (Course course : courses) {
            if (course == null)
                continue;

            System.out.printf("| %-10d | %-20s | %-10.2f | %-10s |\n",
                    course.getId(),
                    course.getName(),
                    course.getPrice(),
                    course.getDuration());
        }

        System.out.println("+-----------------------------------------------------------+");
    }

    public static void payFees()
    {
        if(numberOfStudent == 0)
        {
            System.out.println("There is no student");
            return;
        }
        System.out.println("Enter Student id for pay Fees:");
        int id = takeInput.nextInt();

        Student student = getStudentById(id);

        if(student.getTotalCourse() == 0)
        {
            System.out.println("First Take any Course");
            return;
        }

        while (true)
        {
            if(student == null)
            {
                System.out.println("Enter Valid id:");
                id = takeInput.nextInt();

                student = getStudentById(id);
            }
            else break;
        }

        while (true)
        {
            System.out.println("Enter Amount that you want to pay");
            double amount = takeInput.nextDouble();

            if(amount < 0){
                System.out.println("Amount Can't be negative");
                continue;
            }

            if(amount + student.getFeesPaid() > student.getTotalFees())
            {
                System.out.println("Please Enter Valid Amount");
            }else
            {
                student.setFeesPaid(amount);
                break;
            }
        }

    }
    public static void viewPendingFees(){
        System.out.println("Enter Student id for pay Fees:");
        int id = takeInput.nextInt();

        Student student = getStudentById(id);

        while (true)
        {
            if(student == null)
            {
                System.out.println("Enter Valid id:");
                id = takeInput.nextInt();

                student = getStudentById(id);
            }
            else break;
        }

        System.out.println("Pending Fees :"+(student.getTotalFees() - student.getFeesPaid()));
    }
    public static void updateCourse()
    {
        displayAllCourse();
        System.out.println("Enter id that you want to update Course");
        int id = takeInput.nextInt();

        while(true)
        {
            for(Course course:courses)
            {
                if(course != null && course.getId() == id)
                {
                    takeInput.nextLine();
                    System.out.println("Enter New Course Name :");
                    String name = takeInput.nextLine();

                    System.out.println("Enter Course Price:");
                    double price = takeInput.nextDouble();

                    System.out.println("Enter Duration (in year):");
                    int year = takeInput.nextInt();

                    course.setPrice(price);
                    course.setName(name);
                    course.setDuration(year);
                    return;
                }

            }
            System.out.println("Please Enter Valid Id");
            id = takeInput.nextInt();
        }
    }
    public static void printStudentId() {
        if(numberOfStudent == 0)
            return;
        System.out.println("+--------------+");
        System.out.printf("| %-12s |\n", "Student ID");
        System.out.println("+--------------+");

        for (Student student : students) {
            if (student == null)
                continue;

            System.out.printf("| %-12d |\n", student.getId());
        }

        System.out.println("+--------------+");
    }

    public static void printCourseId() {

        System.out.println("+--------------+");
        System.out.printf("| %-12s |\n", "Course ID");
        System.out.println("+--------------+");

        for (Course course : courses) {
            if (course == null)
                continue;

            System.out.printf("| %-12d |\n", course.getId());
        }

        System.out.println("+--------------+");
    }

    public static void main(String[] args) {

        System.out.println("Enter number of Student:");

        totalNumberOfStudent = takeInput.nextInt();

        //validation of numberOfStudent
        while (true) {
            if (totalNumberOfStudent > 0 && totalNumberOfStudent <= 10) {
                break;
            } else {
                System.out.println("Please Enter Student between 1-10");
                totalNumberOfStudent = takeInput.nextInt();
            }
        }
        students = new Student[totalNumberOfStudent];
        System.out.println("Enter Number of Courses");
        int numberOfCourse1 = takeInput.nextInt();

        for (int i = 1; i <= numberOfCourse1; i++) {
            System.out.println("----- Course "+ i+" -----");

            //course name
            System.out.println("Enter Courses name:");
            takeInput.nextLine();
            String courseName = takeInput.nextLine();

            //course price
            System.out.println("Enter Course Price:");
            double price = takeInput.nextDouble();

            //duration
            System.out.println("Enter Duration in Year:");
            int duration = takeInput.nextInt();

            //id
            int id = random.nextInt(1, 100);

            Course course1 = new Course();

            while (true) {
                int flag = 0;
                for (Course course : courses) {
                    if (course == null)
                        break;
                    if (course.getId() == id) {
                        id = random.nextInt(1, 1000);

                        flag = 1;
                        break;
                    }
                }
                if (flag == 0)
                    break;
            }

            //assign value

            course1.setId(id);
            course1.setName(courseName);
            course1.setDuration(duration);
            course1.setPrice(price);

            courses[numberOfCourse] = course1;
            numberOfCourse++;
        }

        while (true) {

            System.out.println();
            System.out.println("==========================================");
            System.out.println("         STUDENT MANAGEMENT SYSTEM        ");
            System.out.println("==========================================");
            System.out.println("| 1. Create Student                       |");
            System.out.println("| 2. Select Courses                       |");
            System.out.println("| 3. Display Student Details              |");
            System.out.println("| 4. Display All Students Details         |");
            System.out.println("| 5. Display All Courses                  |");
            System.out.println("| 6. Pay Fees                             |");
            System.out.println("| 7. View Pending Fees                    |");
            System.out.println("| 8. Update Course                        |");
            System.out.println("| 9. Exit                                 |");
            System.out.println("==========================================");
            System.out.print("-> Enter your choice: ");

            int choice = takeInput.nextInt();
            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    if(numberOfStudent == 0)
                    {
                        System.out.println("There is no Student");
                        break;
                    }
                    System.out.println("ALL Students");
                    displayAllStudentDetails();
                    System.out.println("All Course");
                    displayAllCourse();
                    selectCourse();
                    break;
                case 3:
                    if(numberOfStudent == 0){
                        System.out.println("There is no Student");
                        break;
                    }
                    System.out.println("Enter student id that you want to get details :");
                    printStudentId();
                    int id = takeInput.nextInt();
                    Student student = getStudentById(id);
                    //id validation
                    while (true)
                    {
                        if(student == null)
                        {
                            System.out.println("Please Enter Valid Id");
                            id = takeInput.nextInt();
                            student = getStudentById(id);
                        }
                        else break;
                    }
                    displayStudentDetails(student);
                    break;
                case 4:
                    displayAllStudentDetails();
                    break;
                case 5:
                    displayAllCourse();
                    break;
                case 6:
                    printStudentId();
                    payFees();
                    break;
                case 7:
                    if(numberOfStudent == 0)
                    {
                        System.out.println("There is No Student");
                        break;
                    }
                    printStudentId();
                    viewPendingFees();
                    break;
                case 8:
                    printCourseId();
                    updateCourse();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Please Enter Valid Choice");
            }
        }
    }
}