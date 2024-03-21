package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import utility.DBUtil;

public class totalcrimeIMPL implements totalcrimedao {
    
   

    @Override
    public int getNumberOfCrimes() {
        int numberOfCrimes = 0;
        try (Connection conn = DBUtil.provideConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM crimeplace")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numberOfCrimes = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
        return numberOfCrimes;
    }
    @Override
    public int getNumberOfSolvedCases() {
        int numberOfSolvedCases = 0;
        try (Connection conn = DBUtil.provideConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM crimeplace WHERE status = 'Solved'")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numberOfSolvedCases = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
        return numberOfSolvedCases;
    }

    @Override
    public int getNumberOfUnsolvedCases() {
        int numberOfUnsolvedCases = 0;
        try (Connection conn = DBUtil.provideConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM crimeplace WHERE status = 'Not Solved'")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numberOfUnsolvedCases = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
        return numberOfUnsolvedCases;
    }
     @Override
    public int getNumberOfCrimesInCurrentMonth() {
        int numberOfCrimesInCurrentMonth = 0;
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();
        try (Connection conn = DBUtil.provideConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM crimeplace WHERE MONTH(date) = ? AND YEAR(date) = ?")) {
            ps.setInt(1, currentMonth);
            ps.setInt(2, currentYear);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numberOfCrimesInCurrentMonth = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
        return numberOfCrimesInCurrentMonth;
    }
    public int getNumberOfSolvedCrimesInCurrentMonth() {
        int numberOfSolvedCrimesInCurrentMonth = 0;
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();
        try (Connection conn = DBUtil.provideConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM crimeplace WHERE MONTH(date) = ? AND YEAR(date) = ? AND status = 'Solved'")) {
            ps.setInt(1, currentMonth);
            ps.setInt(2, currentYear);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numberOfSolvedCrimesInCurrentMonth = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
        return numberOfSolvedCrimesInCurrentMonth;
    }
    
  
}
