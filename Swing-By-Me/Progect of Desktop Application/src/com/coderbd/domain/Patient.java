package com.coderbd.domain;

import java.util.Date;

public class Patient {

    private int id;
    private String firstName;
    private String lastName;
    private String patientCode;
    private String email;
    private String mobile;
    private double totalBill;
    private double paidBill;
    private double dueBill;
    private Date admissionDate;
    private Date releaseDate;

    User user;
    Doctor doctor;

    public Patient() {
    }

    public Patient(int id, String firstName, String lastName, String patientCode, String email, String mobile, double totalBill, double paidBill, double dueBill, Date admissionDate, Date releaseDate, User user, Doctor doctor) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientCode = patientCode;
        this.email = email;
        this.mobile = mobile;
        this.totalBill = totalBill;
        this.paidBill = paidBill;
        this.dueBill = dueBill;
        this.admissionDate = admissionDate;
        this.releaseDate = releaseDate;
        this.user = user;
        this.doctor = doctor;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", patientCode=" + patientCode + ", email=" + email + ", mobile=" + mobile + ", totalBill=" + totalBill + ", paidBill=" + paidBill + ", dueBill=" + dueBill + ", admissionDate=" + admissionDate + ", releaseDate=" + releaseDate + ", user=" + user + ", doctor=" + doctor + '}';
    }

   
}
