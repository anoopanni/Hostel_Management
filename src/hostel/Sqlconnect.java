/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel;
import java.sql.*;
import javax.swing.*;
        
/**
 *
 * @author anoop
 */
public class Sqlconnect {
    Connection con = null;
    public static Connection connectDB()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_management","root","");
   
            return con;
            
        }
        catch(Exception ex)
            
        {
            ex.printStackTrace();
            return null;
        }
    }
}
    
    

