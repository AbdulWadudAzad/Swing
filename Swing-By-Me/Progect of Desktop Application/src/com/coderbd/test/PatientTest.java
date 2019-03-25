package com.coderbd.test;

import com.coderbd.domain.Doctor;
import com.coderbd.domain.Patient;
import com.coderbd.domain.User;
import com.coderbd.services.PatientService;
import java.util.Date;
import java.util.List;

public class PatientTest {

    public static void main(String[] args) {
        //  PatientService.createTable();

        User user = new User();
        user.setId(1);
        Doctor doctor = new Doctor();
        doctor.setId(1);
        Patient patient = new Patient("bahlul", "shah", "a001", "shah@gmail.com", "01726454612", 20000, 15000, 5000, new Date(), new Date(), user, doctor);
        PatientService.insertMain(patient);


//        List<Patient> list = PatientService.getPatients();
//        for(Patient p : list)
//        System.out.println(p);    
    }

}
