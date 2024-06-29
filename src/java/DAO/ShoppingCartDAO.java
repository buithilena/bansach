/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import entity.ShoppingCart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vuhoa
 */
public class ShoppingCartDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ShoppingCart getShoppingCartById(String id) {
        String query = "Select * from shopping_cart where shopping_cart_id = ? and statusDelete = 0";
        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new ShoppingCart(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<ShoppingCart> getAllShoppingCart() {
        List<ShoppingCart> data = new ArrayList<>();
        String query = "SELECT * FROM shopping_cart where statusDelete = 0";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                ShoppingCart author = new ShoppingCart(
                        rs.getString("shopping_cart_id"),
                        rs.getString("customer_id"),
                        rs.getString("book_id"),
                        rs.getString("payment_id"),
                        rs.getInt("shopping_cart_quantity"),
                        rs.getBoolean("statusDelete")
                );
                data.add(author);
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

    public Boolean deleteShoppingCart(String id) {
        String query = "UPDATE shopping_cart SET statusDelete = 1 WHERE shopping_cart_id = ?";

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

    public Boolean editShoppingCart(ShoppingCart sc) {
        String query = "UPDATE shopping_cart SET customer_id = ?, book_id = ?, payment_id = ?, shopping_cart_quantity = ?, statusDelete = ? WHERE shopping_cart_id = ?";

        try (Connection conn = new DBContext().getConnect(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, sc.getCustomer_id());
            ps.setString(2, sc.getBook_id());
            ps.setString(3, sc.getPayment_id());
            ps.setInt(4, sc.getShopping_cart_quantity());
            ps.setBoolean(5, sc.getStatusDelete());
            ps.setString(6, sc.getShopping_cart_id());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0; // Return true if update was successful

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Boolean createShoppingCart(ShoppingCart sc) {
        String query = "INSERT INTO shopping_cart (customer_id, book_id, payment_id, shopping_cart_quantity, statusDelete) VALUES (?, ?, ?, ?, ?)";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);

            ps.setString(1, sc.getCustomer_id());
            ps.setString(2, sc.getBook_id());
            ps.setString(3, sc.getPayment_id());
            ps.setInt(4, sc.getShopping_cart_quantity());
            ps.setBoolean(5, sc.getStatusDelete());

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
        ShoppingCartDAO dao = new ShoppingCartDAO();
//        ShoppingCart data = dao.getShoppingCartById("SC1"); 
//        System.out.println(data);

//        boolean data = dao.deleteShoppingCart("SC1"); 
//        System.out.println(data);
//        ShoppingCart sc = new ShoppingCart("SC9", "1", "B1", "1", 1, Boolean.FALSE);
//        boolean data = dao.editShoppingCart(sc);
//        System.out.println(data);
        ShoppingCart sc = new ShoppingCart( "CU001", "BK001", "PM001", 1, Boolean.FALSE);
        dao.createShoppingCart(sc);
        List<ShoppingCart> data = dao.getAllShoppingCart();
        for (var item : data) {
            System.out.println(item);
        }

    }
}
