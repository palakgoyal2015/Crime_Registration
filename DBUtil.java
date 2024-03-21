package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
   public static Connection provideConnection(){
        String url="jdbc:mysql://localhost:3306/crimeregistration";
        Connection conn=null;
        try {
            conn=DriverManager.getConnection(url,"root","palak");
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return conn;
       
    }
}
