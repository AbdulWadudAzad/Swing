
package Domain;

import com.coderbd.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmployeesService implements CommonDao{

     Connection conn = DbConnection.getConnection("xe", "hr", "hr");

     

     /*   try {
            PreparedStatement ps = conn.prepareStatement("select * from employees");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employees em = new Employees();
                em.setEmployeeID(Integer.parseInt(rs.getString(1)));
                em.setFirstName(rs.getString(2));
                list.add(em);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; */
     
   
     
    @Override
    public List<?> getlist() {
List<Employees> list=new ArrayList<>();
try{
    PreparedStatement ps=conn.prepareStatement("select * from employees");
    ResultSet rs=ps.executeQuery();
    while (re.next()){
        Employees em =new Employees();
        em.setEmployeeID(Integer.parseInt(rs.getString(1)));
        em.setFirstName(rs.getString(2))
        
    }
}

    }

   
}
