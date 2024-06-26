/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author vuhoa
 */
public class Payments {
    private String payment_id; 
    private Float total_price; 
    private Boolean statusDelete; 

    public Payments() {
    }

    public Payments(String payment_id, Float total_price, Boolean statusDelete) {
        this.payment_id = payment_id;
        this.total_price = total_price;
        this.statusDelete = statusDelete;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public Float getTotal_price() {
        return total_price;
    }

    public Boolean getStatusDelete() {
        return statusDelete;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public void setTotal_price(Float total_price) {
        this.total_price = total_price;
    }

    public void setStatusDelete(Boolean statusDelete) {
        this.statusDelete = statusDelete;
    }

    @Override
    public String toString() {
        return "Payments{" + "payment_id=" + payment_id + ", total_price=" + total_price + ", statusDelete=" + statusDelete + '}';
    }
    
}
