
package com.coderbd.test;

import com.coderbd.domain.Patient;
import com.coderbd.domain.Summary;
import com.coderbd.services.SummaryService;

public class SummaryTest {
       
    public static void main(String[] args) {
       // SummaryService.createTable();
        
        Patient patient = new Patient();
        patient.setId(1);
        //firstName, lastName,patientCode, totalBill, paidBill, dueBill, lastUpdate, patient_id
        Summary summary = new Summary("");
        SummaryService.insert(summary);
    }
}
