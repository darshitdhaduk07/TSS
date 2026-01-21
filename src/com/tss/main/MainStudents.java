package com.tss.main;

import com.tss.oop.Course;
import com.tss.oop.Student;

import java.util.Random;
import java.util.Scanner;

public class MainStudents {
    public static Course courses[] = new Course[5];
    public static Random random = new Random();
    public static int totalNumberOfCourse = 0;
    public static int countNumberOfCourse = 0;
    public static int countNumberOfStudent = 0;
    public static int totalNumberOfStudent = 0;
    public static Student students[] = null;
    public static Scanner scanner = new Scanner(System.in);
    public static int lowerBound = 1, upperBound = 11;

    public static void main(String[] args) {

        //validation of countNumberOfStudent
        do {
            System.out.println("Enter number of Student (1-10) only:");
            totalNumberOfStudent = scanner.nextInt();
        } while (totalNumberOfStudent < 1 || totalNumberOfStudent > 10);

        students = new Student[totalNumberOfStudent];


        do {
            System.out.println("Enter Number of Courses (1-5) only");
            countNumberOfCourse = scanner.nextInt();
        } while (countNumberOfCourse < 1 || countNumberOfCourse > 5);


        //take course from admin
        for (int i = 1; i <= countNumberOfCourse; i++) {
            System.out.println("----- Course " + i + " -----");

            //course name
            System.out.println("Enter Courses name:");
            scanner.nextLine();
            String courseName = scanner.nextLine();

            //course price
            System.out.println("Enter Course Price:");
            double price = scanner.nextDouble();

            //duration
            System.out.println("Enter Duration in Year:");
            int duration = scanner.nextInt();

            // generate id
            int id = random.nextInt(lowerBound, upperBound);
            lowerBound = upperBound;
            upperBound += 10;

            //create new course
            Course course1 = new Course();

            //assign value
            course1.setId(id);
            course1.setName(courseName);
            course1.setDuration(duration);
            course1.setPrice(price);

            courses[totalNumberOfCourse] = course1;
            totalNumberOfCourse++;
        }

        lowerBound = 1;
        upperBound = 11;

        while (true) {

            System.out.println();
            System.out.println("------------------------------------------");
            System.out.println("|        STUDENT MANAGEMENT SYSTEM        |");
            System.out.println("------------------------------------------");
            System.out.println("| 1. Create Student                       |");
            System.out.println("| 2. Assign Course to Student             |");
            System.out.println("| 3. Display Student Details by id        |");
            System.out.println("| 4. Display All Students Details         |");
            System.out.println("| 5. Display All Courses                  |");
            System.out.println("| 6. Pay Fees                             |");
            System.out.println("| 7. View Pending Fees                    |");
            System.out.println("| 8. Add new Course to total Course       |");
            System.out.println("| 9. Exit                                 |\n");

            System.out.print("-> Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    assignCourse();
                    break;
                case 3:
                    displayStudentDetailsById();
                    break;
                case 4:
                    displayAllStudentDetails();
                    break;
                case 5:
                    displayAllCourse();
                    break;
                case 6:
                    payFees();
                    break;
                case 7:
                    viewPendingFees();
                    break;
                case 8:
                    addNewCourseToTotalCourses();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Please Enter Valid Choice");
            }
        }
    }

    private static void addNewCourseToTotalCourses() {
        if(totalNumberOfCourse >= 5){
            System.out.println("You added all of the 5 course");
            return;
        }

        System.out.println("----- Course " + (totalNumberOfCourse+1) + " -----");

        //course name
        System.out.println("Enter Courses name:");
        scanner.nextLine();
        String courseName = scanner.nextLine();

        //course price
        System.out.println("Enter Course Price:");
        double price = scanner.nextDouble();

        //duration
        System.out.println("Enter Duration in Year:");
        int duration = scanner.nextInt();

        // generate id
        int id = random.nextInt(lowerBound, upperBound);
        lowerBound = upperBound;
        upperBound += 10;

        //create new course
        Course course1 = new Course();

        //assign value
        course1.setId(id);
        course1.setName(courseName);
        course1.setDuration(duration);
        course1.setPrice(price);

        courses[totalNumberOfCourse++] = course1;
        countNumberOfCourse++;



    }

    private static void viewPendingFees() {
        Student student = getStudentById();

        double totalFees = student.getTotalFees();
        double paidFees = student.getFeesPaid();

        System.out.println("Pending Fees :"+(totalFees-paidFees));

    }

    private static void payFees() {

        Student student = getStudentById();

        if(student != null && student.getTotalCourse() == 0)
        {
            System.out.println("First Create Course");
            return;
        }
        else if(student == null)
        {
            System.out.println("First Create Student");
            return;
        }

        System.out.println("\nCOURSE DETAILS:");
        System.out.println("+------+----------------------+----------+----------+");
        System.out.printf("| %-4s | %-20s | %-8s | %-8s | %-8s \n",
                "ID", "Name", "Price", "Pending Fees", "Duration");
        System.out.println("+------+----------------------+----------+----------+");

        Course[] courses1 = student.getCourse();



        for (int i = 0; i < student.getTotalCourse(); i++) {
            Course c = courses1[i];

            System.out.printf("| %-4d | %-20s | %-8.2f | %-8.2f | %-8d |\n",
                    c.getId(), c.getName(), c.getPrice(),(c.getPrice()-c.getFeesPaid()) ,c.getDuration());
        }

        System.out.println("+------+----------------------+----------+----------+");

        System.out.println("Enter course id that you want to pay fees");
        int id = scanner.nextInt();

        while (true)
        {
            System.out.println(student.getTotalCourse());
            if(id < 0 || id > student.getTotalCourse())
            {
                System.out.println("Enter valid id (1-"+student.getTotalCourse()+" )");
                id = scanner.nextInt();
            }
            else break;
        }

        Course c = courses1[id];
        double pendingFee = (c.getPrice() - c.getFeesPaid());

        if(pendingFee <= 0)
        {
            System.out.println("You already Paid all fees");
        }
        else
        {
            double fees = scanner.nextDouble();

            if(pendingFee < fees)
            {
                System.out.println("Take your Extra money:"+(fees-pendingFee));
            }
            c.setFeesPaid(c.getPrice());
            System.out.println("You Paid Fees Successfully");


        }

    }

    private static void displayAllCourse() {
        System.out.println("+------+----------------------+----------+----------+");
        System.out.printf("| %-4s | %-20s | %-8s | %-8s |\n",
                "ID", "Course Name", "Price", "Duration");
        System.out.println("+------+----------------------+----------+----------+");

        for (int i = 0; i < countNumberOfCourse; i++) {
            Course c = courses[i];

            if (c == null) continue; // safety check

            System.out.printf("| %-4d | %-20s | %-8.2f | %-8d |\n",
                    c.getId(),
                    c.getName(),
                    c.getPrice(),
                    c.getDuration());
        }

        System.out.println("+------+----------------------+----------+----------+");
    }

    private static void displayAllStudentDetails() {
        if(countNumberOfStudent == 0)
        {
            System.out.println("Please Create Student First");
            return;
        }
        System.out.println("+----+--------------+---------+-------------------------+-----------+------------+");
        System.out.printf("| %-2s | %-12s | %-7s | %-23s | %-9s | %-10s |\n",
                "ID", "Name", "Courses", "Course Names", "Fees Paid", "Total Fees");
        System.out.println("+----+--------------+---------+-------------------------+-----------+------------+");

        for (int i = 0; i < countNumberOfStudent; i++) {
            Student s = students[i];

            // build course names
            StringBuilder courseNames = new StringBuilder();
            Course[] courses = s.getCourse();

            for (int j = 0; j < s.getTotalCourse(); j++) {
                courseNames.append(courses[j].getName());
                if (j < s.getTotalCourse() - 1) {
                    courseNames.append(", ");
                }
            }

            System.out.printf("| %-2d | %-12s | %-7d | %-23s | %-9.2f | %-10.2f |\n",
                    s.getId(),
                    s.getName(),
                    s.getTotalCourse(),
                    courseNames.toString(),
                    s.getFeesPaid(),
                    s.getTotalFees());
        }

        System.out.println("+----+--------------+---------+-------------------------+-----------+------------+");

    }

    private static void displayStudentDetailsById() {

        if(countNumberOfStudent == 0)
        {
            System.out.println("\nFirst Create Student");
            return;
        }
        Student student = getStudentById();

        if(student == null)
            return;

        System.out.println("+------------------------------------------------+");
        System.out.printf("| %-46s |\n", "STUDENT DETAILS");
        System.out.println("+------------------------------------------------+");

        System.out.printf("| %-20s : %-21d |\n", "Student ID", student.getId());
        System.out.printf("| %-20s : %-21s |\n", "Student Name", student.getName());
        System.out.printf("| %-20s : %-21d |\n", "Total Courses", student.getTotalCourse());
        System.out.printf("| %-20s : %-21.2f |\n", "Fees Paid", student.getFeesPaid());
        System.out.printf("| %-20s : %-21.2f |\n", "Total Fees", student.getTotalFees());

        System.out.println("+------------------------------------------------+");

        System.out.println("\nCOURSE DETAILS:");
        System.out.println("+------+----------------------+----------+----------+");
        System.out.printf("| %-4s | %-20s | %-8s | %-8s |\n",
                "ID", "Name", "Price", "Duration");
        System.out.println("+------+----------------------+----------+----------+");

        Course[] courses = student.getCourse();

        for (int i = 0; i < student.getTotalCourse(); i++) {
            Course c = courses[i];

            System.out.printf("| %-4d | %-20s | %-8.2f | %-8d |\n",
                    c.getId(), c.getName(), c.getPrice(), c.getDuration());
        }

        System.out.println("+------+----------------------+----------+----------+");


    }

    private static Student getStudentById() {
        if (countNumberOfStudent == 0) {
            System.out.println("Please Create Students First");
            return null;
        }
        System.out.println("Enter id of student");
        int id = scanner.nextInt();


        while (true) {
            for (Student student : students) {

                if (student != null && id == student.getId())
                    return student;

            }
            System.out.println("Please Enter Valid Id");
            id = scanner.nextInt();
        }
    }

    private static void assignCourse() {


        Student student = getStudentById();
        if(student == null)
        {
            return;
        }

        if (student.getTotalCourse() >= 3) {
            System.out.println("You only take at most 3 Courses");
            return;
        }

        displayAllCourse();

        System.out.println("Enter Which Course you want to add");
        int id = scanner.nextInt();

        while (true) {
            if (id <= 0 || id > countNumberOfStudent) {
                System.out.println("Please Enter Valid id (1 to " + countNumberOfCourse + ") :");
                id = scanner.nextInt();
            } else {
                student.setCourses(courses[id]);
                student.setTotalFees(courses[id].getPrice());

                break;
            }
        }
    }

    private static void createStudent() {
        if (countNumberOfStudent >= totalNumberOfStudent) {
            System.out.println("Student Sloat Full");
            return;
        }

        Student student = new Student();
        countNumberOfStudent++;

        System.out.println("Enter Student Name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        int id = random.nextInt(lowerBound, upperBound);
        System.out.println("Student Created by id :"+id);
        lowerBound = upperBound;
        upperBound += 10;

        student.setName(name);
        student.setId(id);
        students[countNumberOfStudent-1] = student;
        System.out.println("Student Successfully Created");
    }
}