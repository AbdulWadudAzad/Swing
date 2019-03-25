
package com.coderbd.services;

import com.coderbd.connection.MySqlDbConnection;
import com.coderbd.domain.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DoctorService {
     static Connection conn = MySqlDbConnection.getConnection();


    public static void createTable() {
        String sql = "create table doctor(id int auto_increment primary key, name varchar(30) not null, mobile varchar(30))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Created!");
        } catch (SQLException ex) {
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insert(Doctor cat) {
        String sql = "insert into doctor(name,mobile) values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cat.getName());
            ps.setString(2, cat.getMobile());
            ps.executeUpdate();
            System.out.println("Data Inserted!");
        } catch (SQLException ex) {
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Doctor> getCatList() {
        List<Doctor> list = new ArrayList<>();

        String sql = "select * from doctor";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Doctor pc = new Doctor();
                pc.setId(rs.getInt(1));
                pc.setName(rs.getString(2));
                pc.setMobile(rs.getString(3));
                list.add(pc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
