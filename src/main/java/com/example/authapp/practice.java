package com.example.authapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class practice {
    public static void main(String args[]) throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/authdb", "root", "");
        PreparedStatement pst=con.prepareStatement("create table if not exists mounika(name varchar(255),reg_no varchar(255),city varchar(255),marks int)");
       int result= pst.executeUpdate();
       if (result == 0) {
        System.out.println("Table created successfully or already exists.");
    } else {
        System.out.println("Table creation affected rows: " + result);
    }
        
    }
}
