package com.example.demo;

public class DatabaseConnection {
    public static void main(String[] args)throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/HotelReservationSystem";
        String username = "root";
        String password = "trapti@123";


        try {
            Class.forName("com.sql.dbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
