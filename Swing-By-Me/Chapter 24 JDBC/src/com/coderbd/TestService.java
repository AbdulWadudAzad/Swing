
package com.coderbd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestService {
    static Connection conn=DbConnection.getConnection("xe", "hr", "hr");
    public static void getEmployeeList(){
        try{
            PreparedStatement ps=conn.prepareStatement("select * from employees");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
            System.out.println(""+rs.getString(1)+" "+rs.getString(2));
        }
        }catch (SQLException ex){
           
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
   /*  public static void updateEmployee(){
        PreparedStatement ps=conn.preparedStatement();
    }   */
}
