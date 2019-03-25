package com.coderbd.test;

import com.coderbd.domain.Doctor;
import com.coderbd.services.DoctorService;

public class DoctorTest {

    public static void main(String[] args) {
//        DoctorService.createTable();

        Doctor doctor = new Doctor();
//        doctor.setName("ahmad");
//        doctor.setMobile("01830654215");
        doctor.setName("Taher");
        doctor.setMobile("01610654215");
        DoctorService.insert(doctor);

    }
}
