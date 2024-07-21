package com.euroTech.day02;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jdbc03_DynamicList {
    public static void main(String[] args) {

    } String dbUrl="jdbc:mysql://localhost/mentoring";
    String dbUsername="root";
    String dbPassword="12345678";

    @Test
    public void test01() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery("select * from employees");

        List<Map<String,Object>> queryDat=new ArrayList<>();
        ResultSetMetaData metaData=resultSet.getMetaData();

        int columncount=metaData.getColumnCount();

       while (resultSet.next()){//bütün satirlarin verisini almami saglayacak-satir satir islem apmamizi sagayack
           Map<String,Object> row =new HashMap<>();
           for (int i = 0; i <=columncount ; i++) { //satirdaki verileri tek map icinde toplmamizi saglayacak
               //sütun adi key icin                  //veri value icin
               row.put(metaData.getColumnLabel(i),resultSet.getString(i));
           }
           queryDat.add(row);
       }
        System.out.println("queryDat = " + queryDat);

       //get the firstname of 10th row
        System.out.println("queryDat.get(9).get(\"firstName\") = " + queryDat.get(2).get("firstName"));


        resultSet.close();
        statement.close();
        connection.close();



    }
}
