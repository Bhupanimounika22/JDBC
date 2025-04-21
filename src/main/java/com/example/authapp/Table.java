package com.example.authapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Table {
    public static void main(String[] args) throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/authdb","root"," ");

        PreparedStatement pst=con.prepareStatement("CREATE TABLE IF NOT EXISTS student (reg_num INT, name VARCHAR(255), city VARCHAR(255), marks INT);");
        pst.executeUpdate();
        PreparedStatement insertData=con.prepareStatement("INSERT INTO student VALUES(?,?,?,?);");

         Scanner sc=new Scanner(System.in);
         System.out.print("How many students do you want to insert? ");

         int n=sc.nextInt();
        for(int i=0;i<n;i++){

            int reg=sc.nextInt();
            sc.nextLine(); 
            String name=sc.nextLine();
            String city=sc.nextLine();
            int marks=sc.nextInt();
            insertData.setInt(1, reg);
            insertData.setString(2,name);
            insertData.setString(3,city);
            insertData.setInt(4,marks);
            int rowsInserted = insertData.executeUpdate();

        }
        System.out.println("✅ Table 'students' created successfully using PreparedStatement!");

    }
}
