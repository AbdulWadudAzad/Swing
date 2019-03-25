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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PatientService {

    static Connection conn = MySqlDbConnection.getConnection();

    public static void createTable() {
        String sql = "create table patient(id int auto_increment primary key,firstName varchar(30),  lastName varchar(30),patientCode varchar(30), email varchar(30) not null, mobile varchar(30) not null,  totalBill double not null,paidBill double not null,dueBill double not null, admissionDate Date not null, releaseDate Date not null,user_id int(11) not null, foreign key (user_id) references user(id),doctor_id int(11) not null, foreign key (doctor_id) references doctor(id))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Created!");
        } catch (SQLException ex) {
            Logger.getLogger(PatientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insert(Patient patient) {
        String sql = "insert into patient(firstName, lastName, patientCode, email , mobile,  totalBill, paidBill, dueBill, admissionDate, releaseDate, user_id, doctor_id) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, patient.getFirstName());
            ps.setString(2, patient.getLastName());
            ps.setString(3, patient.getPatientCode());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getMobile());
            ps.setDouble(6, patient.getTotalBill());
            ps.setDouble(7, patient.getPaidBill());
            ps.setDouble(8, patient.getDueBill());
            ps.setDate(9, new java.sql.Date(patient.getAdmissionDate().getTime()));
            ps.setDate(10, new java.sql.Date(patient.getReleaseDate().getTime()));
            ps.setInt(11, patient.getUser().getId());
            ps.setInt(12, patient.getDoctor().getId());
            ps.executeUpdate();
            System.out.println("Data Inserted!");
        } catch (SQLException ex) {
            Logger.getLogger(PatientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Patient getPatientbyPatientCode(String patientCode) {
        Patient patient = new Patient();
        String sql = "select * from patient where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, patientCode);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                patient.setId(rs.getInt(1));
                patient.setFirstName(rs.getString(2));
                patient.setLastName(rs.getString(3));
                patient.setPatientCode(rs.getString(4));
                patient.setEmail(rs.getString(5));
                patient.setMobile(rs.getString(6));
                patient.setTotalBill(rs.getDouble(7));
                patient.setPaidBill(rs.getDouble(8));
                patient.setDueBill(rs.getDouble(9));
                patient.setAdmissionDate(rs.getDate(10));
                patient.setReleaseDate(rs.getDate(11));
                Doctor c = new Doctor();
                c.setId(rs.getInt(12));
                patient.setDoctor(c);
                User u = new User();
                u.setId(rs.getInt(13));
                patient.setUser(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patient;
    }

    public static void insertMain(Patient patient) {
        if (patient != null) {
            insert(patient);
            Patient p = getPatientbyPatientCode(patient.getPatientCode());

            try {          //totalBill ,paidBill ,dueBill 
                Summary summary = SummaryService.getSummaryByPatientCode(patient.getPatientCode());
                if (patient.getPatientCode().equalsIgnoreCase(summary.getPatient().getPatientCode())) {
                    double totalBill = summary.getTotalBill() + patient.getDueBill();
                    double paidBill = summary.getPaidBill() + patient.getPaidBill();
                    summary.setTotalBill(totalBill);
                    summary.setPaidBill(paidBill);
                    summary.setDueBill(totalBill-paidBill);
                    summary.setLastUpdate(new Date());
                }
                SummaryService.update(summary);

            } catch (NullPointerException e) {

                Summary summary3 = new Summary(patient.getFirstName(), patient.getLastName(),patient.getPatientCode(), patient.getTotalBill(), 0, patient.getPaidBill(), new Date(), p);
                SummaryService.insert(summary3);

            }

        }
    }

    public static Patient getPatientDetails(String patientCode) {
        Patient patient = new Patient();
        String sql = " select * from patient p, doctor d where p.patientCode=? and p.doctor_id=d.id limit 1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, patientCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                patient.setId(rs.getInt(1));
                patient.setFirstName(rs.getString(2));
                patient.setLastName(rs.getString(3));
                 patient.setPatientCode(rs.getString(4));
                patient.setEmail(rs.getString(5));
                patient.setMobile(rs.getString(6));
                patient.setTotalBill(rs.getDouble(7));
                patient.setPaidBill(rs.getDouble(8));
                patient.setDueBill(rs.getDouble(9));
                patient.setAdmissionDate(rs.getDate(10));
                patient.setReleaseDate(rs.getDate(11));
                Doctor pc = new Doctor();
                pc.setId(rs.getInt(12));
                pc.setName(rs.getString("name"));
                patient.setDoctor(pc);
                User user = new User();
                user.setId(rs.getInt(13));
                patient.setUser(user);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patient;
    }

    public static List<Patient> getPatients() {
        List<Patient> list = new ArrayList<>();

        String sql = "select * from patient p, doctor d where p.doctor_id=d.id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt(1));
                patient.setFirstName(rs.getString(2));
                patient.setLastName(rs.getString(3));
                patient.setPatientCode(rs.getString(4));
                patient.setEmail(rs.getString(5));
                patient.setMobile(rs.getString(6));
                patient.setTotalBill(rs.getDouble(7));
                patient.setPaidBill(rs.getDouble(8));
                patient.setDueBill(rs.getDouble(9));
                patient.setAdmissionDate(rs.getDate(10));
                patient.setReleaseDate(rs.getDate(11));
                Doctor pc = new Doctor();
                pc.setId(rs.getInt(12));
                pc.setName(rs.getString("name"));
                patient.setDoctor(pc);
                User user = new User();
                user.setId(rs.getInt(13));
                patient.setUser(user);
                list.add(patient);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
