package com.feroj.sms;


import java.sql.*;
import java.util.*;

public class Student {
    private final Connection connection;
    private final Scanner scanner;

    public Student(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addStudent(){
        System.out.print("Student's ID: ");
        int ID = scanner.nextInt();
        System.out.print("First Name: ");
        String FirstName = scanner.next();
        System.out.print("Last Name: ");
        String LastName = scanner.next();
        System.out.print("Postal code: ");
        String PostCode = scanner.next();
        System.out.print("District: ");
        String District = scanner.next();
        System.out.print("Division: ");
        String Division = scanner.next();
        System.out.print("Date of Birth: ");
        String DOB = scanner.next();
        System.out.print("\n1 for CSE\n2 for EEE\n3 for TE\n4 for IPE\n5 for FDAE\n");
        System.out.print("Select department: ");
        int DeptID = scanner.nextInt();
        System.out.println("Allocated hostel: ");
        int HostelID = scanner.nextInt();

        try {
            String query = "INSERT INTO student(st_ID, first_name, last_name, postal_code, district, division, DOB, dept_ID, hostel_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ID);
            preparedStatement.setString(2, FirstName);
            preparedStatement.setString(3, LastName);
            preparedStatement.setString(4, PostCode);
            preparedStatement.setString(5, District);
            preparedStatement.setString(6, Division);
            preparedStatement.setString(7, DOB);
            preparedStatement.setInt(8, DeptID);
            preparedStatement.setInt(9, HostelID);
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows > 0){
                System.out.println("Student data added Successfully!");
            }else {
                System.out.println("Failed to add student data!");
            }


        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void viewStudent(){
        String query = "select * from student";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Students: ");
            System.out.println("+-----+--------------+-------------+------+------------+------------+--------------+--------------+------+------+");
            System.out.println("|ID   | First Name   | Last Name   | P.C  | District   | Division   | DOB          | Password     | D_ID | H_ID |");
            System.out.println("+-----+--------------+-------------+------+------------+------------+--------------+--------------+------+------+");
            while (resultSet.next()){
                int ID = resultSet.getInt("st_ID");
                String Fname = resultSet.getString("first_name");
                String Lname = resultSet.getString("last_name");
                String PostCode = resultSet.getString("postal_code");
                String District = resultSet.getString("district");
                String Division = resultSet.getString("division");
                String DOB = resultSet.getString("DOB");
                String Password = resultSet.getString("password");
                int DeptID = resultSet.getInt("dept_ID");
                int HostelID = resultSet.getInt("hostel_ID");
                System.out.printf("|%-5s|%-14s|%-13s|%-6s|%-12s|%-12s|%-14s|%-14s|%-6s|%-6s|\n", ID, Fname, Lname, PostCode, District, Division, DOB, Password, DeptID, HostelID);
                System.out.println("+-----+--------------+-------------+------+------------+------------+--------------+--------------+------+------+");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getStudentByID(int id){
        String query = "select * from student where st_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int ID = resultSet.getInt("st_ID");
                String Fname = resultSet.getString("first_name");
                String Lname = resultSet.getString("last_name");
                String PostCode = resultSet.getString("postal_code");
                String District = resultSet.getString("district");
                String Division = resultSet.getString("division");
                String DOB = resultSet.getString("DOB");
                String Password = resultSet.getString("password");
                int DeptID = resultSet.getInt("dept_ID");
                int HostelID = resultSet.getInt("hostel_ID");

                System.out.println("Student ID: " + ID);
                System.out.println("Student's Name: " + Fname + " " + Lname);
                System.out.println("Address: " + PostCode + "-" + District + ", " + Division);
                System.out.println("Date of Birth: " + DOB);
                System.out.println("Department ID: " + DeptID);
                System.out.println("Hostel ID: " + HostelID);
            } else {
                System.out.println("Student not found!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteStudentByID(int id){
        String query = "delete from student where st_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows > 0){
                System.out.println("Student data deleted Successfully!");
            }else {
                System.out.println("Failed to delete student data!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateStudentByID(int id){
        System.out.print("First Name: ");
        String FirstName = scanner.next();
        System.out.print("Last Name: ");
        String LastName = scanner.next();
        System.out.print("Postal code: ");
        String PostCode = scanner.next();
        System.out.print("District: ");
        String District = scanner.next();
        System.out.print("Division: ");
        String Division = scanner.next();
        System.out.print("Date of Birth: ");
        String DOB = scanner.next();
        System.out.print("\n1 for CSE\n2 for EEE\n3 for TE\n4 for IPE\n5 for FDAE\n");
        System.out.print("Select department: ");
        int DeptID = scanner.nextInt();
        System.out.println("Allocated hostel: ");
        int HostelID = scanner.nextInt();

        try {
            String query = "update student set first_name = ?, last_name = ?, postal_code = ?, district = ?, division = ?, DOB = ?, dept_ID = ?, hostel_ID = ? where st_ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, FirstName);
            preparedStatement.setString(2, LastName);
            preparedStatement.setString(3, PostCode);
            preparedStatement.setString(4, District);
            preparedStatement.setString(5, Division);
            preparedStatement.setString(6, DOB);
            preparedStatement.setInt(7, DeptID);
            preparedStatement.setInt(8, HostelID);
            preparedStatement.setInt(9, id);
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows > 0){
                System.out.println("Student data updated Successfully!");
            }else {
                System.out.println("Failed to update student data!");
            }


        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}