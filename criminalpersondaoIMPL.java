package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utility.DBUtil;

public class criminalpersondaoIMPL implements criminalpersondao {

    @Override
    public String registercriminalperson( int crimePlaceId,int criminalNumber, String name, int age, String gender, String address,
            String identifyingMark, String areaofArrest) {
                String msg="Not registered criminal person";
               try(Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO criminalperson VALUES (?, ?, ?, ?, ?, ?, ?,?)");
            
            ps.setInt(1,crimePlaceId); 
            ps.setInt(2, criminalNumber);
            ps.setString(3, name);
            ps.setInt(4, age);
            ps.setString(5,gender); 
            ps.setString(6, address);
            ps.setString(7,identifyingMark); 
            ps.setString(8,areaofArrest); 
           

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                msg = "Criminal person registered successfully";
            } else {
                msg = "Failed to register criminal person";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database exception
            msg = "Error: " + e.getMessage();
        }
        return msg;
            }
    
}
