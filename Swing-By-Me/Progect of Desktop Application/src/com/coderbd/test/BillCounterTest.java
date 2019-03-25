package com.coderbd.test;

import com.coderbd.domain.BillCounter;
import com.coderbd.domain.Patient;
import com.coderbd.domain.User;
import com.coderbd.services.BillCounterService;
import java.util.Date;

public class BillCounterTest {

    public static void main(String[] args) {
//         BillCounterService.createTable();


        Patient patient = new Patient();
        patient.setId(1);
        User user = new User();
        user.setId(1);
        //firstName,lastName,patientCode,todaysBill,totalBill,collectionbill,dueBill,collectionDate,patient_id,user_id
        BillCounter bc=new BillCounter("");
        BillCounterService.insertForBillCounter(bc);
    }

}
