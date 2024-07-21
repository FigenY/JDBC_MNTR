package com.euroTech.day01;

import org.testng.annotations.Test;

import java.sql.*;

public class Jdbc03_MovingCursor {
    String dbUrl="jdbc:mysql://localhost/mentoring";
    String dbUsername="root";
    String dbPassword="12345678";

    @Test
    public void test01() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        // create statement obj
        Statement statement= connection.createStatement();

        // run query, get result and assign the result in resultset obj
        ResultSet resultSet= statement.executeQuery("select * from employees");

        // find how many rows that we have

        resultSet.last();
        int row = resultSet.getRow();
        System.out.println("row = " + row);


        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void test02() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        // create statement obj
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        // run query, get result and assign the result in resultset obj
        ResultSet resultSet= statement.executeQuery("select * from employees");

        // find how many rows that we have

        resultSet.last();
        int row = resultSet.getRow();
        System.out.println("row = " + row);

        // how to go to the first lane

        resultSet.first();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        // how to go to particular row

        resultSet.absolute(5);
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        resultSet.previous();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());



        resultSet.close();
        statement.close();
        connection.close();
    }
}
