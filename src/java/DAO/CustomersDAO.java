/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import entity.Customers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vuhoa
 */
public class CustomersDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Customers getCustomerById(String id) {
        String query = "Select * from customers where customer_id = ? and statusDelete = 0";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Customers(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Customers> getAllCustomer() {
        List<Customers> data = new ArrayList<>();
        String query = "SELECT * FROM customers where statusDelete = 0";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Customers customer;
                customer = new Customers(
                        rs.getString("customer_id"),
                        rs.getString("customer_name"),
                        rs.getString("customer_address"),
                        rs.getString("customer_phone"),
                        rs.getString("customer_username"),
                        rs.getString("customer_password"),
                        rs.getString("customer_role"),
                        rs.getBoolean("statusDelete")
                );
                data.add(customer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close resources in reverse order of their creation
            try {
                rs.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                ps.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */ }
        }
        return data;
    }

    public Boolean deleteCustomerById(String id) {
        String query = "UPDATE customers SET statusDelete = 1 WHERE customer_id = ?";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);

            ps.setString(1, id);

            int rowsUpdated = ps.executeUpdate();

            return rowsUpdated > 0; // Return true if update was successful
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            // Close resources in reverse order of their creation
            try {
                ps.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */ }
        }
    }

    public Boolean editCustomerById(Customers cust) {
        String query = "UPDATE customers SET customer_name = ?, customer_address = ?, customer_phone = ?, customer_username = ?, customer_password = ?, customer_role = ?, statusDelete = ? WHERE customer_id = ?";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);

            ps.setString(1, cust.getCustomer_name());
            ps.setString(2, cust.getCustomer_address());
            ps.setString(3, cust.getCustomer_phone());
            ps.setString(4, cust.getCustomer_username());
            ps.setString(5, cust.getCustomer_password());
            ps.setString(6, cust.getCustomer_role());
            ps.setBoolean(7, cust.getStatusDelete());
            ps.setString(8, cust.getCustomer_id());

            int rowsUpdated = ps.executeUpdate();

            return rowsUpdated > 0; // Return true if update was successful
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            // Close resources in reverse order of their creation
            try {
                ps.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */ }
        }
    }

    public Boolean createCustomer(Customers cust) {
        String query = "INSERT INTO customers (customer_name, customer_address, customer_phone, customer_username, customer_password, customer_role, statusDelete) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);

            ps.setString(1, cust.getCustomer_name());
            ps.setString(2, cust.getCustomer_address());
            ps.setString(3, cust.getCustomer_phone());
            ps.setString(4, cust.getCustomer_username());
            ps.setString(5, cust.getCustomer_password());
            ps.setString(6, cust.getCustomer_role());
            ps.setBoolean(7, cust.getStatusDelete());

            int rowsInserted = ps.executeUpdate();

            return rowsInserted > 0; // Return true if insertion was successful
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            // Close resources in reverse order of their creation
            try {
                ps.close();
            } catch (Exception e) {
                /* ignored */
            }
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */
            }
        }

    }

    public static void main(String[] args) {
        CustomersDAO dao = new CustomersDAO();

//        Customers data = dao.getCustomerById("1");
//        System.out.println(data);
//        boolean data = dao.deleteCustomerById("1");
//        System.out.println(data);
//        Customers record = new Customers("1", "Yoengggg", "Yoengggg", "Yoengggg", "Yoengggg", "Yoengggg", "admin", Boolean.FALSE);
//        boolean data = dao.editCustomerById(record); 
//        System.out.println(data);
        Customers record = new Customers("Yoengggg", "Yoengggg", "Yoengggg", "Yoengggg", "Yoengggg", "admin", Boolean.FALSE);
        dao.createCustomer(record);

        List<Customers> data = dao.getAllCustomer();
        for (var item : data) {
            System.out.println(item);
        }
    }
}
