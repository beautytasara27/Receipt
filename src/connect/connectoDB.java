/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author beauty
 */
public class connectoDB {
    public static Connection conn;
    public static Connection database() throws ClassNotFoundException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://dbta.1ez.xyz/20_receipt","BEA9402","w1xddyy3");
            System.out.println("connected");
            return conn;
           
            
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
   
    
}
