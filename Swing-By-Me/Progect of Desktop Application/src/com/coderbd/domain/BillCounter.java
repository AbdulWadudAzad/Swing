package com.coderbd.domain;

import java.util.Date;

public class BillCounter {

    private int id;
    private String firstName;
    private String lastName;
    private String patientCode;
    private double todaysBill;
    private double totalBill;
    private double collectionBill;
    private double dueBill;
    private Date collectionDate;
    Patient patient;
    User user;

    public BillCounter() {
    }

    public BillCounter(int id, String firstName, String lastName, String patientCode, double todaysBill, double totalBill, double collectionBill, double dueBill, Date collectionDate, Patient patient, User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientCode = patientCode;
        this.todaysBill = todaysBill;
        this.totalBill = totalBill;
        this.collectionBill = collectionBill;
        this.dueBill = dueBill;
        this.collectionDate = collectionDate;
        this.patient = patient;
        this.user = user;
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

    public double getTodaysBill() {
        return todaysBill;
    }

    public void setTodaysBill(double todaysBill) {
        this.todaysBill = todaysBill;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public double getCollectionBill() {
        return collectionBill;
    }

    public void setCollectionBill(double collectionBill) {
        this.collectionBill = collectionBill;
    }

    public double getDueBill() {
        return dueBill;
    }

    public void setDueBill(double dueBill) {
        this.dueBill = dueBill;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BillCounter{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", patientCode=" + patientCode + ", todaysBill=" + todaysBill + ", totalBill=" + totalBill + ", collectionBill=" + collectionBill + ", dueBill=" + dueBill + ", collectionDate=" + collectionDate + ", patient=" + patient + ", user=" + user + '}';
    }

  
   
}
