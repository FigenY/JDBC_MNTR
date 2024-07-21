package com.euroTech.day02;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jdbc02_ListOfMap {
    public static void main(String[] args) {

    } String dbUrl="jdbc:mysql://localhost/mentoring";
    String dbUsername="root";
    String dbPassword="12345678";

    @Test
    public void test01() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery("select * from employees");

        resultSet.next();
        System.out.println("resultSet.getString(\"firstname\") = " + resultSet.getString("firstname"));
        System.out.println("resultSet.getString(\"lastnamelastname\") = " + resultSet.getString("lastname"));
        System.out.println("resultSet.getString(\"salary\") = " + resultSet.getString("salary"));
        System.out.println("resultSet.getString(\"jobid\") = " + resultSet.getString("jobid"));

        List<Map<String, Object>> queryData=new ArrayList<>();
        Map<String, Object> row1= new HashMap<>();
        row1.put("firstname", "Samet");
        row1.put("lastname", "Emsen");
        row1.put("salary", "100000");
        row1.put("jobid", "QA");

        Map<String, Object> row2= new HashMap<>();
        row2.put("firstname", "Ahmet");
        row2.put("lastname", "Yilmaz");
        row2.put("salary", "150000");
        row2.put("jobid", "DEV");

        System.out.println(row1);
        System.out.println(row2);

        queryData.add(row1);
        queryData.add(row2);

        System.out.println("queryData = " + queryData);

        //get samet lastname

        System.out.println(" samet soyisim"+ queryData.get(0).get("lastname"));

        System.out.println("Ahmet Yilmaz maas = " + queryData.get(1).get("salary"));

        //get the same data from database

        //how to fill list of map with data that comes from database dynamically-- objeleri metadatadan cekcem, digerlerini

        List<Map<String, Object>> querydata2=new ArrayList<>();

        //first get the metadata of table
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

        resultSet.next();
        Map<String, Object> row1Dynamic=new HashMap<>();

        row1Dynamic.put(resultSetMetaData.getColumnName(1), resultSet.getString(1));
        row1Dynamic.put(resultSetMetaData.getColumnName(2), resultSet.getString(2));
        row1Dynamic.put(resultSetMetaData.getColumnName(3), resultSet.getString(3));
        row1Dynamic.put(resultSetMetaData.getColumnName(4), resultSet.getString(4));

        System.out.println("row1Dynamic = " + row1Dynamic);

        resultSet.next();
        Map<String, Object> row2Dynamic=new HashMap<>();
        row2Dynamic.put(resultSetMetaData.getColumnName(1), resultSet.getString(1));
        row2Dynamic.put(resultSetMetaData.getColumnName(2), resultSet.getString(2));
        row2Dynamic.put(resultSetMetaData.getColumnName(3), resultSet.getString(3));
        row2Dynamic.put(resultSetMetaData.getColumnName(4), resultSet.getString(4));

        System.out.println("row2Dynamic = " + row2Dynamic);

        //aynisini tablodan cekerek yaptik
        querydata2.add(row1Dynamic);
        querydata2.add(row2Dynamic);

        System.out.println("querydata2 = " + querydata2);


        resultSet.close();
        statement.close();
        connection.close();


    }
}
