package com.euroTech.day01;

import java.sql.*;

public class Jdbc02_Practice {
    public static void main(String[] args) throws SQLException {
        String dbUrl="jdbc:mysql://localhost/mentoring";
        String dbUsername="root";
        String dbPassword="12345678";

        // create connection to database
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        // create statement obj
        Statement statement= connection.createStatement();

        // run query, get result and assign the result in resultset obj
        ResultSet resultSet= statement.executeQuery("select * from locations");

        resultSet.next();
        //get the locationid ,street adress and postcode of first row from locations table

        System.out.println("locationId "+resultSet.getString("locationId")
        +" /// streetAddress "+resultSet.getString("streetAddress")+
                " /// postCode "+resultSet.getString("postCode"));

        resultSet.next();
        
        // get 2nd row's info by colum index with using for loop
        for (int i = 1; i <=6; i++) {
            System.out.println("column "+i+ " "+ resultSet.getString(i));
        }


        resultSet.close();
        statement.close();
        connection.close();
    }
}
