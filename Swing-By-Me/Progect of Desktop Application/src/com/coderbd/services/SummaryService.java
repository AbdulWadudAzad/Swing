package com.coderbd.services;

import com.coderbd.connection.MySqlDbConnection;

import com.coderbd.domain.Doctor;
import com.coderbd.domain.Patient;
import com.coderbd.domain.Summary;
import com.coderbd.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SummaryService {

    static Connection conn = MySqlDbConnection.getConnection();

    public static void createTable() {
        String sql = "create table summary(id int auto_increment primary key,firstName varchar(30),  lastName varchar(30),patientCode varchar(30) not null,"
                + " totalBill double not null,paidBill double not null,dueBill double not null, lastUpdate Date not null,patient_id int not null, foreign key (patient_id) references patient(id))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Created!");
        } catch (SQLException ex) {
            Logger.getLogger(PatientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insert(Summary summary) {
        String sql = "insert into summary( firstName, lastName,patientCode, totalBill, paidBill, dueBill, lastUpdate, patient_id ) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, summary.getFirstName());
            ps.setString(2, summary.getLastName());
            ps.setString(3, summary.getPatientCode());
            ps.setDouble(4, summary.getTotalBill());
            ps.setDouble(5, summary.getPaidBill());
            ps.setDouble(6, summary.getDueBill());
            ps.setDate(7, new java.sql.Date(summary.getLastUpdate().getTime()));
            ps.setInt(8, summary.getPatient().getId());
            ps.executeUpdate();
            System.out.println("Data Inserted!");
        } catch (SQLException ex) {
            Logger.getLogger(PatientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Summary summary) {
        String sql = "update summary set totalBill=?,paidBill=?,dueBill=?,lastUpdate=? where patientCode=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, summary.getTotalBill());
            ps.setDouble(2, summary.getPaidBill());
            ps.setDouble(3, summary.getDueBill());
            ps.setDate(4, new java.sql.Date(summary.getLastUpdate().getTime()));
            ps.setString(5, summary.getPatientCode());

            ps.executeUpdate();
            System.out.println("Data Updated in Summary!");
        } catch (SQLException ex) {
            Logger.getLogger(SummaryService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Summary getSummaryByPatientCode(String patientCode) {
        Summary summary = new Summary();
        String sql = "select * from summary where patientCode=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, patientCode);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                summary.setId(rs.getInt(1));
                summary.setFirstName(rs.getString(2));//patientCode
                summary.setLastName(rs.getString(3));
                summary.setPatientCode(rs.getString(4));
                summary.setTotalBill(rs.getDouble(5));
                summary.setPaidBill(rs.getDouble(6));
                summary.setDueBill(rs.getDouble(7));
                summary.setLastUpdate(rs.getDate(8));
                Patient p = new Patient();
                p.setId(rs.getInt(9));
                summary.setPatient(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return summary;
    }

    public static List<Summary> getSummaryList() {
        List<Summary> list = new ArrayList<>();

        String sql = "select s.firstName, s.lastName,s.patientCode, s.totalBill, s.paidBill, s.dueBill, d.name from summary s, patient p, doctor d where s.product_id=p.id and p.doctor_id=d.id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Summary summary = new Summary();
                summary.setFirstName(rs.getString(1));
                summary.setLastName(rs.getString(2));
                summary.setPatientCode(rs.getString(3));
                summary.setTotalBill(rs.getDouble(4));
                summary.setPaidBill(rs.getDouble(5));
                summary.setDueBill(rs.getDouble(6));
                Doctor pc = new Doctor();
                pc.setName(rs.getString("name"));
                Patient p = new Patient();
                p.setDoctor(pc);
                summary.setPatient(p);
                list.add(summary);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static class createTable {

        public createTable() {
        }
    }

}
