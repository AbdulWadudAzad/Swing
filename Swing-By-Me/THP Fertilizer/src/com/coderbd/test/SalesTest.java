/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.test;

//import service.SalesService;
import com.coderbd.domain.CyclePurchase;
import com.coderbd.domain.CycleSales;
import java.util.Date;
import com.coderbd.service.SalesService;

/**
 *
 * @author user
 */
public class SalesTest {
    
    public static void main(String[] args) {
        //SalesService.createTable();
        CyclePurchase cp = new CyclePurchase();
        cp.setId(1);
        
        CycleSales cs = new CycleSales("Core Project 1", "CORE01", 5, 15000, 750000, new Date(), cp);
        SalesService.insertForSales(cs);
    }
}
