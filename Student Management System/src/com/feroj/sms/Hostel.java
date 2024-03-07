package com.feroj.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hostel {
    private final Connection connection;

    public Hostel(Connection connection) {
        this.connection = connection;
    }


    public void viewHostel(){
        String query = "select * from hostel";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Hostels: ");
            System.out.println("+-----+-------------------------------+----------------+");
            System.out.println("|ID   | Hostel Name                   | No of Seats    |");
            System.out.println("+-----+-------------------------------+----------------+");
            while (resultSet.next()){
                int ID = resultSet.getInt("hostel_ID");
                String HostelName = resultSet.getString("hostel_name");
                int noOfSeats = resultSet.getInt("no_of_seats");
                System.out.printf("|%-5s|%-31s|%-16s|\n", ID, HostelName, noOfSeats);
                System.out.println("+-----+-------------------------------+----------------+");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getHostelByID(int id){
        String query = "select * from hostel where hostel_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int ID = resultSet.getInt("hostel_ID");
                String HostelName = resultSet.getString("hostel_name");
                int noOfSeats = resultSet.getInt("no_of_seats");

                System.out.println("Hostel ID: " + ID);
                System.out.println("Hostel Name: " + HostelName);
                System.out.println("No of seats: " + noOfSeats);
            } else {
                System.out.println("Hostel not found!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
