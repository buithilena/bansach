/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import entity.Payments;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vuhoa
 */
public class PaymentsDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Payments getPaymentById(String id) {
        String query = "Select * from payments where payment_id = ? and statusDelete = 0";
        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Payments(rs.getString(1), rs.getFloat(2), rs.getBoolean(3));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Payments> getAllPayments() {
        List<Payments> data = new ArrayList<>();
        String query = "SELECT * FROM payments where statusDelete = 0";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Payments payment = new Payments(
                        rs.getString("payment_id"),
                        rs.getFloat("total_price"),
                        rs.getBoolean("statusDelete")
                );
                data.add(payment);
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

    public Boolean deletePaymentsById(String id) {
        String query = "UPDATE payments SET statusDelete = 1 WHERE payment_id = ?";
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

    public Boolean editPaymentById(Payments paym) {
        String query = "UPDATE payments SET total_price = ?, statusDelete = ? WHERE payment_id = ?";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);

            ps.setFloat(1, paym.getTotal_price());
            ps.setBoolean(2, paym.getStatusDelete());
            ps.setString(3, paym.getPayment_id());

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

    public Boolean createPayment(Payments paym) {
        String query = "INSERT INTO payments (total_price, statusDelete) VALUES (?, ?)";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);

            ps.setFloat(1, paym.getTotal_price());
            ps.setBoolean(2, false);

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
                /* ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */ }
        }
    }

    public static void main(String[] args) {
        PaymentsDAO dao = new PaymentsDAO();

//        Payments data = dao.getPaymentById("1");
//        System.out.println(data);
//        boolean data = dao.deletePaymentsById("1");
//        System.out.println(data);
//        Payments pay = new Payments("1", (float) 99999, Boolean.FALSE);
//        boolean data = dao.editPaymentById(pay);
//        System.out.println(data);
        Payments pay = new Payments((float) 99999, Boolean.FALSE);
        dao.createPayment(pay);

        List<Payments> data = dao.getAllPayments();
        for (var item : data) {
            System.out.println(item);
        }
    }
}
