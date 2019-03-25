
package com.coderbd.domain;

public class AdminDashboard {
   
   private  double totalBill;
   private  double collectionBill;
   private  double deuBill;

    public AdminDashboard() {
    }

    public AdminDashboard(double totalBill, double collectionBill, double deuBill) {

        this.totalBill = totalBill;
        this.collectionBill = collectionBill;
        this.deuBill = deuBill;
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

    public double getDeuBill() {
        return deuBill;
    }

    public void setDeuBill(double deuBill) {
        this.deuBill = deuBill;
    }

    @Override
    public String toString() {
        return "AdminDashboard{" + "totalBill=" + totalBill + ", collectionBill=" + collectionBill + ", deuBill=" + deuBill + '}';
    }

  
   
   
}
