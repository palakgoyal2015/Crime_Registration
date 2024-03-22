package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import exceptions.Invalidcrimenumber;
import exceptions.Invalidcriminalnumber;
import utility.DBUtil;

public class getdatadaoIMPL implements getdatadao{
    @Override
    public String getdatabycrimenumber(int crimeNumber) throws Invalidcrimenumber {
       String message = "Crime information not found";
    try (Connection conn = DBUtil.provideConnection()) {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM crimeplace WHERE crimeNumber = ?");
        ps.setInt(1, crimeNumber);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
           
            int retrievedCrimeNumber = rs.getInt("crimeNumber");
            Date date = rs.getDate("date");
            String place = rs.getString("place");
            String description = rs.getString("description");
            String victims = rs.getString("victims");
            String details = rs.getString("details");
            String mainSuspects = rs.getString("mainSuspects");

           
            message = "Crime Information:\n" +
                      "Crime Number: " + retrievedCrimeNumber + "\n" +
                      "Date: " + date.toString() + "\n" +
                      "Place: " + place + "\n" +
                      "Description: " + description + "\n" +
                      "Victims: " + victims + "\n" +
                      "Details: " + details + "\n" +
                      "Main Suspects: " + mainSuspects;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        message = "Error: " + e.getMessage();
    }
    return message;

    
    }

    @Override
    public String getdatabycriminalnumber(int criminalNumber) throws Invalidcriminalnumber {
        String message = "Criminal person information not found";
        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM criminalperson WHERE criminalNumber = ?");
            ps.setInt(1, criminalNumber);
    
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               
                int crimePlaceId = rs.getInt("crimePlaceId");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String address = rs.getString("address");
                String identifyingMark = rs.getString("identifyingMark");
                String areaofArrest = rs.getString("areaofArrest");
    
               
                message = "Criminal Person Information:\n" +
                          "Criminal Number: " + criminalNumber + "\n" +
                          "Crime Place ID: " + crimePlaceId + "\n" +
                          "Name: " + name + "\n" +
                          "Age: " + age + "\n" +
                          "Gender: " + gender + "\n" +
                          "Address: " + address + "\n" +
                          "Identifying Mark: " + identifyingMark + "\n" +
                          "Area of Arrest: " + areaofArrest;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message = "Error: " + e.getMessage();
        }
        return message;
    }
}
