package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.DBUtil;

public class criminalpersondaoIMPL implements criminalpersondao {
    @Override
    public String addSuspectCountColumn() {
        String msg = "Already present suspectCount column";
        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("ALTER TABLE criminalperson ADD COLUMN suspectCount INT DEFAULT 0");
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                msg = "SuspectCount column added successfully";
            } else {
                // msg = "Failed to add suspectCount column";
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            // msg = "not added";
        }
        return msg;
    }

    @Override
    public String registercriminalperson(int crimePlaceId, int criminalNumber, String name, int age, String gender,
                                          String address, String identifyingMark, String areaofArrest) {
        String msg = "Not registered criminal person";
        try (Connection conn = DBUtil.provideConnection()) {
           
            PreparedStatement psInsert = conn.prepareStatement(
                "INSERT INTO criminalperson (crimePlaceId, criminalNumber, name, age, gender, address, identifyingMark, areaofArrest) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            psInsert.setInt(1, crimePlaceId);
            psInsert.setInt(2, criminalNumber);
            psInsert.setString(3, name);
            psInsert.setInt(4, age);
            psInsert.setString(5, gender);
            psInsert.setString(6, address);
            psInsert.setString(7, identifyingMark);
            psInsert.setString(8, areaofArrest);
            
            int rowsAffectedInsert = psInsert.executeUpdate();

            if (rowsAffectedInsert > 0) {
                
                PreparedStatement psUpdateCount = conn.prepareStatement(
                    "UPDATE criminalperson cp " +
                    "JOIN (" +
                    "    SELECT crimePlaceId, COUNT(*) AS countCriminalPersons " +
                    "    FROM criminalperson " +
                    "    GROUP BY crimePlaceId " +
                    ") AS counts ON cp.crimePlaceId = counts.crimePlaceId " +
                    "SET cp.suspectCount = counts.countCriminalPersons"
                );
                
                int rowsAffectedUpdate = psUpdateCount.executeUpdate();

                if (rowsAffectedUpdate > 0) {
                    msg = "Criminal person registered successfully";
                } else {
                    msg = "Failed to update suspect count";
                }
            } else {
                msg = "Failed to register criminal person";
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            // msg = "Error: " + e.getMessage();
        }
        return msg;
    }
    @Override
    public int getSuspectCountForCrimePlace(int crimePlaceId) {
        int suspectCount = 0;
        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT COUNT(*) FROM criminalperson WHERE crimePlaceId = ?");
            ps.setInt(1, crimePlaceId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                suspectCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
        return suspectCount;
    }
}
