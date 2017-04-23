/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonogramfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author USER
 */
public class DbConnection {
    
    String url="jdbc:mysql://mysql4.gear.host/harmonogramfx";
    String user="harmonogramfx";
    String password="12345678!";
    
    public Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("jdbc:mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection(url, user, password);
            return connection;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}
