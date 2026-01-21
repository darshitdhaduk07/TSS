//import com.tss.oop.Student;
//
//import java.util.Scanner;
//
//public class MainApp {
//    public static void displayStudentProfile(Student student)
//    {
//        System.out.println("Student Name: "+student.getName());
//        System.out.println("Course Name: "+student.getCourseName());
//        System.out.println("Course Price: "+student.getTotalFees());
//        System.out.println("Pending Fees: "+ student.getPendingFees());
//    }
//    public static void payFees(Student student)
//    {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter Fee amount");
//        int fee = scanner.nextInt();
//
//        student.payFees(fee);
//
//    }
//    public static void updateCourse(Student student)
//    {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter Course Name:");
//        String courseName = scanner.nextLine();
//
//        System.out.println("Enter total Fees:");
//        int totalFees = scanner.nextInt();
//
//        System.out.println("Enter fees Paid");
//        int feesPaid = scanner.nextInt();
//
//        student.setCourseName(courseName);
//        student.setTotalFees(totalFees);
//        student.setFeesPaid(feesPaid);
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Student student = new Student();
//
//        System.out.println("Enter Name: ");
//        String name = scanner.nextLine();
//
//        System.out.println("Enter Course Name: ");
//        String courseName = scanner.nextLine();
//
//        System.out.println("Enter Total Fees");
//        int totalFees = scanner.nextInt();
//
//        System.out.println("Enter Fees that you Paid:");
//        int feesPaid = scanner.nextInt();
//
//        student.setName(name);
//        student.setCourseName(courseName);
//        student.setTotalFees(totalFees);
//        student.setFeesPaid(feesPaid);
//
//        while (true)
//        {
//            System.out.println("1. Display Student Profile");
//            System.out.println("2. Pay Fees");
//            System.out.println("3. View Panding Fees");
//            System.out.println("4. Update Course");
//            System.out.println("5. Exit");
//
//            int choice = scanner.nextInt();
//
//            switch (choice)
//            {
//                case 1:
//                    displayStudentProfile(student);
//                    break;
//                case 2:
//                    payFees(student);
//                    break;
//                case 3:
//                    System.out.println("Pending Fees :"+student.getPendingFees());
//                    break;
//                case 4:
//                    updateCourse(student);
//                    break;
//                case 5:
//                    return;
//            }
//
//        }
