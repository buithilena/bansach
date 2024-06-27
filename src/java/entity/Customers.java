/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author vuhoa
 */
public class Customers {
    private String customer_id; 
    private String customer_name; 
    private String customer_address; 
    private String customer_phone; 
    private String customer_username; 
    private String customer_password; 
    private String customer_role; 
    private Boolean statusDelete;

    public Customers() {
    }

    public Customers(String customer_id, String customer_name, String customer_address, String customer_phone, String customer_username, String customer_password, String customer_role, Boolean statusDelete) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.customer_phone = customer_phone;
        this.customer_username = customer_username;
        this.customer_password = customer_password;
        this.customer_role = customer_role;
        this.statusDelete = statusDelete;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public String getCustomer_username() {
        return customer_username;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public String getCustomer_role() {
        return customer_role;
    }

    public Boolean getStatusDelete() {
        return statusDelete;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public void setCustomer_username(String customer_username) {
        this.customer_username = customer_username;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public void setCustomer_role(String customer_role) {
        this.customer_role = customer_role;
    }

    public void setStatusDelete(Boolean statusDelete) {
        this.statusDelete = statusDelete;
    }

    @Override
    public String toString() {
        return "Customers{" + "customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_address=" + customer_address + ", customer_phone=" + customer_phone + ", customer_username=" + customer_username + ", customer_password=" + customer_password + ", customer_role=" + customer_role + ", statusDelete=" + statusDelete + '}';
    }
    
}
