package com.euroTech.day02;

import org.testng.annotations.Test;

import java.sql.*;

public class Jdbc01_MetaData {
    public static void main(String[] args) {

    } String dbUrl="jdbc:mysql://localhost/mentoring";
    String dbUsername="root";
    String dbPassword="12345678";

    @Test
    public void test01() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery("select * from employees");

        DatabaseMetaData databaseMetaData=connection.getMetaData();

        System.out.println("databaseMetaData.getUserName() = " + databaseMetaData.getUserName());
        System.out.println("databaseMetaData.getDatabaseProductVersion() = " + databaseMetaData.getDatabaseProductVersion());
        System.out.println("databaseMetaData.getDriverName() = " + databaseMetaData.getDriverName());
        System.out.println("databaseMetaData.getDriverVersion() = " + databaseMetaData.getDriverVersion());


        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

        //how many column that we have
        int columcount=resultSetMetaData.getColumnCount();
        System.out.println("columcount = " + columcount);

        //get the furst column name
        String columnLabel = resultSetMetaData.getColumnLabel(1);
        System.out.println("columnLabel = " + columnLabel);

        String columnLabel2 = resultSetMetaData.getColumnLabel(2);
        System.out.println("columnLabel2 = " + columnLabel2);

        for (int i = 0; i <=columcount; i++) {
            System.out.println("columnName: "+ resultSetMetaData.getColumnName(i));
        }




        resultSet.close();
        statement.close();
        connection.close();
    }
    }
