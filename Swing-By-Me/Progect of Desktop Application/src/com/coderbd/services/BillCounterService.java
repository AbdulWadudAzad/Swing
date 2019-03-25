package com.coderbd.services;

import com.coderbd.connection.MySqlDbConnection;
import com.coderbd.domain.BillCounter;
import com.coderbd.domain.Doctor;
import com.coderbd.domain.Patient;
import com.coderbd.domain.Summary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillCounterService {

    static Connection conn = MySqlDbConnection.getConnection();
//int id, String patient_Name, double todaysBill, double totalBill, double collectionBill, double dueBill, Date collectionDate, boolean status, User user, Doctor doctor, Patient patient

    public static void createTable() {
        String sql = "create table billcounter(id int auto_increment primary key, firstName varchar(30) not null,lastName varchar(30) not null,patientCode varchar(30) not null, todaysBill double not null, totalBill double not null, collectionbill double not null,dueBill double not null, collectionDate Date not null, patient_id int not null, foreign key (patient_id) references patient(id),user_id int not null, foreign key (user_id) references user(id))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Created!");
        } catch (SQLException ex) {
            Logger.getLogger(BillCounterService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insert(BillCounter billcounter) {
        String sql = "insert into billcounter(firstName,lastName,patientCode,todaysBill,totalBill,collectionbill,dueBill,collectionDate,patient_id,user_id) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, billcounter.getFirstName());
            ps.setString(2, billcounter.getLastName());
            ps.setString(3, billcounter.getPatientCode());
            ps.setDouble(4, billcounter.getTodaysBill());
            ps.setDouble(5, billcounter.getTotalBill());
            ps.setDouble(6, billcounter.getCollectionBill());
            ps.setDouble(7, billcounter.getDueBill());
            ps.setDate(8, new java.sql.Date(billcounter.getCollectionDate().getTime()));
            ps.setInt(9, billcounter.getPatient().getId());
            ps.setInt(10, billcounter.getUser().getId());

            ps.executeUpdate();
            System.out.println("Data Inserted!");
        } catch (SQLException ex) {
            Logger.getLogger(BillCounterService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertForBillCounter(BillCounter billcounter) {
        if (billcounter.getPatientCode() != null) {
            Summary summary = SummaryService.getSummaryByPatientCode(billcounter.getPatientCode());
            if (summary.getDueBill() <= billcounter.getCollectionBill()) {
                insert(billcounter);
                double paidBill=summary.getPaidBill()+billcounter.getCollectionBill();
                double dueBill=summary.getTotalBill()-summary.getPaidBill();
                
              
                summary.setTotalBill(summary.getTotalBill());               
                summary.setPaidBill(paidBill);
                 summary.setDueBill(dueBill);
                summary.setLastUpdate(new Date());

                SummaryService.update(summary);
            } else {
                System.out.println("You can not pay advanced");
            }
        }
    }

    public static List<BillCounter> getBillCounterList() {
        List<BillCounter> list = new ArrayList<>();
//firstName,lastName,patientCode,todaysBill,totalBill,collectionbill,dueBill,collectionDate,patient_id,user_id
        String sql = "select b.firstName,b.lastName,b.patientCode,b.todaysBill,b.totalBill,b.collectionbill,b.dueBill,b.collectionDate, d.name from billcounter b, patient p, doctor d where b.patient_id=p.id and p.doctor_id=d.id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BillCounter billcounter = new BillCounter();
                billcounter.setFirstName(rs.getString(1));
                billcounter.setLastName(rs.getString(2));
                billcounter.setPatientCode(rs.getString(3));
                billcounter.setTodaysBill(rs.getDouble(4));
                billcounter.setTotalBill(rs.getDouble(5));
                billcounter.setCollectionBill(rs.getDouble(6));
                billcounter.setDueBill(rs.getDouble(7));
                billcounter.setCollectionDate(rs.getDate(8));
                Doctor pc = new Doctor();
                pc.setName(rs.getString(9));
                Patient p = new Patient();
                p.setDoctor(pc);
                billcounter.setPatient(p);
//                User user = new User();
//                user.setId(rs.getInt(9));
//                billcounter.setUser(user);
                list.add(billcounter);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BillCounterService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
