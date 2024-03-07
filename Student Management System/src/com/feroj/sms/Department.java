package com.feroj.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Department {
    private final Connection connection;

    public Department(Connection connection) {
        this.connection = connection;
    }


    public void viewDepartment(){
        String query = "select * from department";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Departments: ");
            System.out.println("+-----+---------------------------------------------------+");
            System.out.println("|ID   | Department Name                                   |");
            System.out.println("+-----+---------------------------------------------------+");
            while (resultSet.next()){
                int ID = resultSet.getInt("dept_ID");
                String DeptName = resultSet.getString("dept_name");
                System.out.printf("|%-5s|%-51s|\n", ID, DeptName);
                System.out.println("+-----+---------------------------------------------------+");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getDepartmentByID(int id){
        String query = "select * from department where dept_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int ID = resultSet.getInt("dept_ID");
                String DeptName = resultSet.getString("dept_name");

                System.out.println("Department ID: " + ID);
                System.out.println("Department Name: " + DeptName);
            } else {
                System.out.println("Department not found!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
