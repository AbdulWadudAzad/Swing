
package com.coderbd.domain;

import java.util.Date;

public class Summary {
    private int id;      
    private String firstName; 
    private String lastName; 
    private String patientCode;
    private double totalBill;
    private double paidBill;
    private double dueBill;   
    private Date lastUpdate;
    //For Foreign key
    Patient patient;

    public Summary() {
    }

    public Summary(String firstName, String lastName, String patientCode, double totalBill, double paidBill, double dueBill, Date lastUpdate, Patient patient) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientCode = patientCode;
        this.totalBill = totalBill;
        this.paidBill = paidBill;
        this.dueBill = dueBill;
        this.lastUpdate = lastUpdate;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public double getPaidBill() {
        return paidBill;
    }

    public void setPaidBill(double paidBill) {
        this.paidBill = paidBill;
    }

    public double getDueBill() {
        return dueBill;
    }

    public void setDueBill(double dueBill) {
        this.dueBill = dueBill;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Summary{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", patientCode=" + patientCode + ", totalBill=" + totalBill + ", paidBill=" + paidBill + ", dueBill=" + dueBill + ", lastUpdate=" + lastUpdate + ", patient=" + patient + '}';
    }
    

}