/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softtechapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author lina_
 */
public class ConnectToDB {
    
        public static Connection getConnection() {

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:softTechDB.db";
            Connection con = DriverManager.getConnection(url);
            //JOptionPane.showMessageDialog(null, "Connection Established");
            return con;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}
