/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receipt;

import static connect.connectoDB.database;
import frontend.Welcome;

/**
 *
 * @author beauty
 */
public class Receipt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        database();
        Welcome we = new Welcome();
        we.setVisible(true);
        // TODO code application logic here
    }
    
}
