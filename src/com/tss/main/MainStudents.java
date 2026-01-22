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
            System.out.print("Enter number of Student (1-10) only: ");
            totalNumberOfStudent = scanner.nextInt();
        } while (totalNumberOfStudent < 1 || totalNumberOfStudent > 10);

        students = new Student[totalNumberOfStudent];


        do {
            System.out.print("Enter Number of Courses (1-5) only: ");
            countNumberOfCourse = scanner.nextInt();
        } while (countNumberOfCourse < 1 || countNumberOfCourse > 5);


        //take course from admin
        for (int i = 1; i <= countNumberOfCourse; i++) {
            System.out.println("\n----- Course " + i + " -----");

            //course name

            String courseName = getCourseName();
            //course price
            System.out.print("Enter Course Price: ");
            double price = scanner.nextDouble();

            //duration
            System.out.print("Enter Duration in Year: ");
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
            course1.setFees(price);

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

            while(true)
            {
                if(choice < 0 || choice > 9){
                    System.out.print("Please Enter Valid Choice :");
                    choice = scanner.nextInt();
                }
                else break;
            }
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
                    System.out.println("\nThank You");
                    return;

            }

        }
    }

    private static Student getStudentById() {
        if (countNumberOfStudent == 0) {
            System.out.println("\nPlease Create Students First");
            return null;
        }
        System.out.print("\nEnter id of student: ");
        int id = scanner.nextInt();


        while (true) {
            for (Student student : students) {

                if (student != null && id == student.getId())
                    return student;

            }
            System.out.print("Please Enter Valid Id: ");
            id = scanner.nextInt();
        }
    }
    public static String getCourseName()
    {
        System.out.print("Enter Courses name: ");
        scanner.nextLine();
        String courseName = scanner.nextLine();



        while (true)
        {
            int flag = 0;
            for(Course course:courses)
            {
                if(course == null)
                    continue;
                else if(course.getName().toLowerCase().trim().replace(" ","").equals(courseName.toLowerCase().trim().replace(" ","")))
                {
                    System.out.print("Please Enter Unique Course Name: ");
                    courseName = scanner.nextLine();
                    flag = 1;
                }

            }
            if(flag == 0)
                return courseName;
        }
    }

    private static void addNewCourseToTotalCourses() {
        if (totalNumberOfCourse >= 5) {
            System.out.println("\nYou added all of the 5 course");
            return;
        }

        System.out.println("----- Course " + (totalNumberOfCourse + 1) + " -----");

        //course name

        String courseName = getCourseName();

        //course price
        System.out.print("Enter Course Price: ");
        double price = scanner.nextDouble();

        //duration
        System.out.print("Enter Duration in Year: ");
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
        course1.setFees(price);

        courses[totalNumberOfCourse++] = course1;
        countNumberOfCourse++;


    }

    private static void viewPendingFees() {
        Student student = getStudentById();
        if (student == null) {
            System.out.println("Please Create Student First");
            return;
        }
        double totalFees = student.getTotalFees();
        double paidFees = student.getFeesPaid();

        System.out.println("\nPending Fees :" + (totalFees - paidFees));

    }

    private static void payFees() {

        Student student = getStudentById();

        if (student != null && student.getTotalCourse() == 0) {
            System.out.println("\nPlease Assign the Course First");
            return;
        } else if (student == null) {
            System.out.println("\nPlease Create Student First");
            return;
        }

        Course[] courses1 = student.getCourse();

        System.out.println("\nCOURSE DETAILS:");
        System.out.println("+--------+------+----------------------+----------+--------------+----------+");
        System.out.printf("| %-6s | %-4s | %-20s | %-8s | %-12s | %-8s |\n",
                "Sr. No","ID", "Name", "Price", "Pending Fees", "Duration");
        System.out.println("+--------+------+----------------------+----------+--------------+----------+");

        for (int i = 0; i < student.getTotalCourse(); i++) {
            Course c = courses1[i];

            System.out.printf("| %-6d | %-4d | %-20s | %-8.2f | %-12.2f | %-8d |\n",
                    (i+1),c.getId(), c.getName(), c.getFees(), (c.getFees() - c.getFeesPaid()), c.getDuration());
        }

        System.out.println("+--------+------+----------------------+----------+--------------+----------+");

        System.out.print("Enter Sr No. of Course that you want to pay fees: ");
        int id = scanner.nextInt();

        while (true) {
//            System.out.println(student.getTotalCourse());
            if (id <= 0 || id > student.getTotalCourse()) {
                System.out.println("Enter valid id (1-" + student.getTotalCourse() + " )");
                id = scanner.nextInt();
            } else break;
        }

        Course c = courses1[id - 1];
        double pendingFee = (c.getFees() - c.getFeesPaid());

        if (pendingFee <= 0) {
            System.out.println("You already Paid all fees");
        } else {
            System.out.print("Enter Fee amount: ");
            double fees = scanner.nextDouble();

            if (pendingFee < fees) {
                System.out.println("Take your Extra money: " + (fees - pendingFee));
            }
            c.setFeesPaid(c.getFees());
            student.setFeesPaid((Math.min(fees, pendingFee)));

            System.out.println("Paid Fees Successfully");


        }

    }

    private static void displayAllCourse() {
        System.out.println("+--------+------+----------------------+----------+----------+");
        System.out.printf("| %-4s | %-4s | %-20s | %-8s | %-8s |\n",
                "Sr. No", "Id", "Course Name", "Price", "Duration");
        System.out.println("+--------+------+----------------------+----------+----------+");

        for (int i = 0; i < countNumberOfCourse; i++) {
            Course c = courses[i];

            if (c == null) continue; // safety check

            System.out.printf("| %-6d | %-4d | %-20s | %-8.2f | %-8d |\n",
                    (i + 1),
                    c.getId(),
                    c.getName(),
                    c.getFees(),
                    c.getDuration());
        }

        System.out.println("+--------+------+----------------------+----------+----------+");
    }

    private static void displayAllStudentDetails() {
        if (countNumberOfStudent == 0) {
            System.out.println("Please Create Student First");
            return;
        }

        System.out.println("+----+-----------------+---------+-------------------------+-----------+--------------+------------+");
        System.out.printf("| %-2s | %-15s | %-7s | %-23s | %-9s | %-12s | %-10s |\n",
                "ID", "Name", "Courses", "Course Names", "Fees Paid", "Pending Fees", "Total Fees");
        System.out.println("+----+-----------------+---------+-------------------------+-----------+--------------+------------+");

        for (int i = 0; i < countNumberOfStudent; i++) {
            Student s = students[i];

            StringBuilder courseNames = new StringBuilder();
            Course[] courses = s.getCourse();

            for (int j = 0; j < s.getTotalCourse(); j++) {
                courseNames.append(courses[j].getName());
                if (j < s.getTotalCourse() - 1) {
                    courseNames.append(", ");
                }
            }

            System.out.printf("| %-2d | %-15s | %-7d | %-23s | %-9.2f | %-12.2f | %-10.2f |\n",
                    s.getId(),
                    s.getName(),
                    s.getTotalCourse(),
                    courseNames.toString(),
                    s.getFeesPaid(),
                    (s.getTotalFees() - s.getFeesPaid()),
                    s.getTotalFees());
        }

        System.out.println("+----+-----------------+---------+-------------------------+-----------+--------------+------------+");
    }


    private static void displayStudentDetailsById() {

        if (countNumberOfStudent == 0) {
            System.out.println("\nPlease Create Student First");
            return;
        }
        Student student = getStudentById();

        if (student == null)
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
                    c.getId(), c.getName(), c.getFees(), c.getDuration());
        }

        System.out.println("+------+----------------------+----------+----------+");


    }


    private static boolean checkCourseTaken(Student student,Course course)
    {
        Course course1[] = student.getCourse();
        for (Course c : course1)
        {
            if(c == null)
                continue;
            else if(c.getName().toLowerCase().equals(course.getName().toLowerCase()))
                return true;
        }
        return false;
    }
    private static void assignCourse() {


        Student student = getStudentById();


        if (student == null) {
            return;
        }

        if (student.getTotalCourse() >= 3) {
            System.out.println("\nYou only take at most 3 Courses");
            return;
        }
        if(student.getTotalCourse() >= countNumberOfCourse)
        {
            System.out.println("\nYou Take all the courses \n");
            return;
        }

        displayAllCourse();

        System.out.print("Enter Sr No. of Course that you want to add: ");
        int id = scanner.nextInt();

        while (true) {
            if (id <= 0 || id > countNumberOfCourse) {
                System.out.print("Please Enter Valid id (1 to " + countNumberOfCourse + "): ");
                id = scanner.nextInt();
            } else {
                if(checkCourseTaken(student,courses[id-1]))
                {
                    System.out.println("\nYou Already Taken this Course please Select another one\n");
                    id = 0;
                    continue;
                }

                student.setCourses(courses[id - 1]);
                student.setTotalFees(courses[id - 1].getFees());

                break;
            }
        }
        System.out.println("\nCourse Assigned Successfully");
    }

    private static void createStudent() {
        if (countNumberOfStudent >= totalNumberOfStudent) {
            System.out.println("\nStudent Sloat Full");
            return;
        }

        Student student = new Student();
        countNumberOfStudent++;

        System.out.print("\nEnter Student Name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        int id = random.nextInt(lowerBound, upperBound);
        System.out.println("Student Created by id: " + id);
        lowerBound = upperBound;
        upperBound += 10;

        student.setName(name);
        student.setId(id);
        students[countNumberOfStudent - 1] = student;
        System.out.println("\nStudent Created Successfully");
    }
}