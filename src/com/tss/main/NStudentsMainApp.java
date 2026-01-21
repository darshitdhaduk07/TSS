//import com.tss.oop.Student;
//
//import java.util.Scanner;
//
//public class NStudentsMainApp {
//    private static void addNewStudents(Student []students)
//    {
//        Student student = new Student();
//        int numberOfStudents = Student.getNumberOfStudents();
//        if(numberOfStudents > Student.getTotalStudents())
//        {
//            System.out.println("Slot Full");
//            return;
//        }
//
//        Scanner takeInput = new Scanner(System.in);
//
//
//        System.out.println("Enter Name: ");
//        String name = takeInput.nextLine();
//
//        System.out.println("Enter Course Name: ");
//        String courseName = takeInput.nextLine();
//
//        System.out.println("Enter Total Fees");
//        int totalFees = takeInput.nextInt();
//
//
//        System.out.println("Enter Fees that you Paid:");
//        int feesPaid = takeInput.nextInt();
//
//        student.setName(name);
//        student.setCourseName(courseName);
//        student.setTotalFees(totalFees);
//        student.setFeesPaid(feesPaid);
//
//        students[numberOfStudents-1] = student;
//
//
//    }
//    public static Student getStudent(Student students[])
//    {
//        Scanner takeInput = new Scanner(System.in);
//
//        System.out.println("Enter student id");
//
//        int id = 0;
//
//        while(true)
//        {
//            id = takeInput.nextInt();
//
//            if(id < 1 || id > Student.getNumberOfStudents())
//                System.out.println("Please Enter valid id");
//            else
//                break;
//        }
//        return students[id-1];
//    }
//    public static void payFees(Student students[])
//    {
//        Scanner takeInput = new Scanner(System.in);
//
//
//        Student student = getStudent(students);
//        System.out.println("Enter Fee amount");
//        int fee = takeInput.nextInt();
//
//
//        student.payFees(fee);
//
//    }
//    public static void viewPandingFees(Student students[])
//    {
//        Student student = getStudent(students);
//        System.out.println("Pending Fees :"+student.getPendingFees());
//    }
//    public static void displayStudentProfile(Student student)
//    {
//        System.out.println("--------------------------------------");
//        System.out.println("Student Name: "+student.getName());
//        System.out.println("Course Name: "+student.getCourseName());
//        System.out.println("Course Price: "+student.getTotalFees());
//        System.out.println("Pending Fees: "+ student.getPendingFees());
//        System.out.println("--------------------------------------");
//
//    }
//    public static void displayStudent(Student students[])
//    {
//            Student student = getStudent(students);
//            displayStudentProfile(student);
//    }
//    public static void displayAllStudent(Student students[]){
//        for(Student student :students)
//        {
//            displayStudentProfile(student);
//        }
//    }
//    public static void main(String[] args) {
//
//        System.out.println("Enter Student Number:");
//
//        Scanner inputTaker = new Scanner(System.in);
//
//        int numberOfStudent = 0;
//
//
//
//        while(true)
//        {
//            if(!inputTaker.hasNextInt())
//            {
//                System.out.println("Please Enter a Number");
//                inputTaker.next();
//            }
//
//            numberOfStudent = inputTaker.nextInt();
//
//            if(numberOfStudent <= 0)
//            {
//                System.out.println("Student must be greater than 0");
//            }else
//                break;
//        }
//        Student students[] = new Student[numberOfStudent];
//        Student.setTotalStudents(numberOfStudent);
//        while (true) {
//            System.out.println("1. Add new Student");
//            System.out.println("2. Pay Fees");
//            System.out.println("3. View Panding Fees");
//            System.out.println("4. Display a Student");
//            System.out.println("5. Display all Students");
//            System.out.println("6. Exit");
//
//            int choice = inputTaker.nextInt();
//
//            switch (choice) {
//                case 1:
//                    addNewStudents(students);
//                    break;
//                case 2:
//                    payFees(students);
//                    break;
//                case 3:
//                   viewPandingFees(students);
//                    break;
//                case 4:
//                    displayStudent(students);
//                    break;
//                case 5:
//                    displayAllStudent(students);
//                    break;
//                case 6:
//                    return;
//            }
//
//        }
//
//
//    }
//}
