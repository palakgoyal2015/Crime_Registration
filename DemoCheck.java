package utility;

import java.sql.Connection;

public class DemoCheck {
    
    public static void main(String[] args){
        Connection conn=DBUtil.provideConnection();
        if(conn!=null){
            System.out.println("connected...");
        }
    }
}
