package com.euroTech.day01;

import java.sql.*;

public class Jdbc01_Intro {
    public static void main(String[] args) throws SQLException {

    String dbUrl="jdbc:mysql://localhost/mentoring";
    String dbUsername="root";
    String dbPassword="12345678";

        // create connection to database
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        // create statement obj
        Statement statement= connection.createStatement();

        // run query, get result and assign the result in resultset obj
       ResultSet resultSet= statement.executeQuery("select * from employees");

       resultSet.next();
    // getting info by the column name
        System.out.println("resultSet.getString(\"firstname\") = " + resultSet.getString("firstName"));
        System.out.println("resultSet.getString(\"employeeId\") = " + resultSet.getInt("employeeId"));
        System.out.println("resultSet.getString(\"jobId\") = " + resultSet.getString("jobId"));

        // getting info by column index

        System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
        System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
        System.out.println("resultSet.getString(6) = " + resultSet.getString(6));

        // 2nd row
        resultSet.next();
        System.out.println("resultSet.getString(\"firstname\") = " + resultSet.getString("firstName"));
        System.out.println("resultSet.getString(\"employeeId\") = " + resultSet.getInt("employeeId"));
        System.out.println("resultSet.getString(\"jobId\") = " + resultSet.getString("jobId"));

        // get all table starts with 3 rd row
        System.out.println("-------------------------");

        while (resultSet.next()){
            System.out.println("resultSet.getString(\"firstname\") = " + resultSet.getString("firstName"));
            System.out.println("resultSet.getString(\"employeeId\") = " + resultSet.getInt("employeeId"));
            System.out.println("resultSet.getString(\"jobId\") = " + resultSet.getString("jobId"));

        }

        resultSet.close();
       statement.close();
       connection.close();

    }
}
