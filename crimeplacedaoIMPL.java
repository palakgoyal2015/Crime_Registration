package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import bean.crimeplace;
import utility.DBUtil;

public class crimeplacedaoIMPL implements crimeplacedao {
   
    @Override
    public String registercrimeplace(int crimeNumber, Date date, String place, String description, List<String> victims,
            String details, List<String> mainSuspects) {
        String msg="Crime place not registered";
        try(Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO crimeplace (crimeNumber, date, place, description, victims, details, mainSuspects) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, crimeNumber);
            ps.setDate(2, date);
            ps.setString(3, place);
            ps.setString(4, description);
            ps.setString(5, String.join(",", victims)); 
            ps.setString(6, details);
            ps.setString(7, String.join(",", mainSuspects)); 

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
}
