package com.feroj.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class StudentManagementSystem {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/student_management_system";
    private static final String username = "root";
    private static final String password = "admin";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e){
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Student student = new Student(connection, scanner);
            Faculty faculty = new Faculty(connection);
            Department department = new Department(connection);
            Hostel hostel = new Hostel(connection);

            while(true){
                System.out.println("STUDENT MANAGEMENT SYSTEM");
                System.out.println("1. Add Student");
                System.out.println("2. See Student List");
                System.out.println("3. Find Student by ID");
                System.out.println("4. See Faculty List");
                System.out.println("5. Find Faculty by ID");
                System.out.println("6. See Department List");
                System.out.println("7. Find Department by ID");
                System.out.println("8. See Hostel List");
                System.out.println("9. Find Hostel by ID");
                System.out.println("10. Delete Student by ID");
                System.out.println("11. Update Student by ID");
                System.out.println("0. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        //add student
                        student.addStudent();
                        break;
                    case 2:
                        //see student list
                        student.viewStudent();
                        break;
                    case 3:
                        //find student by id
                        System.out.print("Enter the Student's ID: ");
                        int id = scanner.nextInt();
                        student.getStudentByID(id);
                        break;
                    case 4:
                        //see faculty list
                        faculty.viewFaculty();
                        break;
                    case 5:
                        //find faculty by id
                        System.out.print("Enter the Faculty's ID: ");
                        int f_id = scanner.nextInt();
                        faculty.getFacultyByID(f_id);
                        break;
                    case 6:
                        //see department list
                        department.viewDepartment();
                        break;
                    case 7:
                        //find department by ID
                        System.out.print("Enter the Department ID: ");
                        int dept_id = scanner.nextInt();
                        department.getDepartmentByID(dept_id);
                        break;
                    case 8:
                        //see hostel list
                        hostel.viewHostel();
                        break;
                    case 9:
                        //find hostel by id
                        System.out.print("Enter the Hostel ID: ");
                        int hostel_id = scanner.nextInt();
                        hostel.getHostelByID(hostel_id);
                        break;
                    case 10:
                        //delete student by id
                        System.out.print("Enter the Student ID you want to delete: ");
                        int st_id = scanner.nextInt();
                        student.deleteStudentByID(st_id);
                        break;
                    case 11:
                        //update student by id
                        System.out.print("Enter the Student ID you want to update: ");
                        int st_ID = scanner.nextInt();
                        student.updateStudentByID(st_ID);
                        break;
                    case 0:
                        System.out.println("Thank you for using our system!");
                        System.exit(0);
                    default:
                        System.out.print("Enter your choice: ");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
