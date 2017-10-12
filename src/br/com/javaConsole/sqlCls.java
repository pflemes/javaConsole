/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.javaConsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Adivar
 */
public class sqlCls {
    
    public void selectAll() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");            
            String selectSQL = "SELECT * FROM persons";
            PreparedStatement ps = conn.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();
            //Result loop
            while(rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("ID");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                int age = rs.getInt("Age");
                // Display values
                System.out.print("ID: " + id);
                System.out.print(", LastName: " + lastName);
                System.out.print(", First Name: " + firstName);
                System.out.print(", Age: " + age);
            }
        }
        catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    public void insert() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");            
            String insertSQL = "INSERT INTO Persons(LastName, FirstName, Age) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(insertSQL);
            ps.setString(1, "Cristina");
            ps.setString(2, "Pedro");
            ps.setInt(3, 30);
            ps.execute();
        }
        catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
}
