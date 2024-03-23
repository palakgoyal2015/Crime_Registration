package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import utility.DBUtil;

public class crimeplacedaoIMPL implements crimeplacedao {
   
    @Override
    public String addStatusColumn() {
        String msg = "Already present status column";
        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("ALTER TABLE crimeplace ADD COLUMN status VARCHAR(50)");
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                msg = "Status column added successfully";
            } else {
                // msg = "Failed to add status column";
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            // msg = "Error: " + e.getMessage();
        }
        return msg;
    }

    @Override
    public String registercrimeplace(int crimeNumber, Date date, String place, String description, List<String> victims,
            String details, List<String> mainSuspects) {
        String msg = "Crime place not registered";
        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO crimeplace (crimeNumber, date, place, description, victims, details, mainSuspects, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, crimeNumber);
            ps.setDate(2, date);
            ps.setString(3, place);
            ps.setString(4, description);
            ps.setString(5, String.join(",", victims));
            ps.setString(6, details);
            ps.setString(7, String.join(",", mainSuspects));

            int suspectCount = getSuspectCount(conn, crimeNumber);
            String status = (suspectCount > 0) ? "Unsolved" : "Solved";
            ps.setString(8, status);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                msg = "Crime place registered successfully";
            } else {
                msg = "Failed to register crime place";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database exception
            msg = "Error: " + e.getMessage();
        }
        return msg;
    }

    private int getSuspectCount(Connection conn, int crimeNumber) throws SQLException {
        int suspectCount = 0;
        PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM criminalperson WHERE crimePlaceId = ?");
        ps.setInt(1, crimeNumber);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            suspectCount = rs.getInt(1);
        }
        return suspectCount;
    }
}
