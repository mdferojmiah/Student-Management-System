package com.feroj.sms;

import java.sql.*;

public class Faculty {
    private final Connection connection;

    public Faculty(Connection connection) {
        this.connection = connection;
    }


    public void viewFaculty(){
        String query = "select * from faculty";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Faculties: ");
            System.out.println("+-----+--------------+-------------+-----------+--------------+");
            System.out.println("|ID   | First Name   | Last Name   | Dept_ID   | Password     |");
            System.out.println("+-----+--------------+-------------+-----------+--------------+");
            while (resultSet.next()){
                int ID = resultSet.getInt("f_ID");
                String Fname = resultSet.getString("first_name");
                String Lname = resultSet.getString("last_name");
                int DeptID = resultSet.getInt("dept_ID");
                String Password = resultSet.getString("password");
                System.out.printf("|%-5s|%-14s|%-13s|%-11s|%-15s|\n", ID, Fname, Lname, DeptID, Password);
                System.out.println("+-----+--------------+-------------+-----------+--------------+");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getFacultyByID(int id){
        String query = "select * from faculty where f_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int ID = resultSet.getInt("f_ID");
                String Fname = resultSet.getString("first_name");
                String Lname = resultSet.getString("last_name");
                int DeptID = resultSet.getInt("dept_ID");
                String Password = resultSet.getString("password");

                System.out.println("Faculty ID: " + ID);
                System.out.println("Faculty's Name: " + Fname + " " + Lname);
                System.out.println("Department ID: " + DeptID);
            } else {
                System.out.println("Faculty not found!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
