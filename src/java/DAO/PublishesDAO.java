/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import entity.Publishes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vuhoa
 */
public class PublishesDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Publishes getPublishById(String id) {
        String query = "Select * from publishes where publish_id = ? and statusDelete = 0";
        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Publishes(rs.getString(1), rs.getString(2), rs.getBoolean(3));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Publishes> getAllPublishes() {
        List<Publishes> data = new ArrayList<>();
        String query = "Select * from publishes where statusDelete = 0";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Publishes author = new Publishes(
                        rs.getString("publish_id"),
                        rs.getString("publish_name"),
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

    public Boolean deletePublishById(String id) {
        String query = "UPDATE publishes SET statusDelete = 1 WHERE publish_id = ?";

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

    public Boolean editPublishById(Publishes publi) {
        String query = "UPDATE publishes SET publish_name = ?, statusDelete = ? WHERE publish_id = ?";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);

            ps.setString(1, publi.getPublish_name());
            ps.setBoolean(2, publi.getStatusDelete());
            ps.setString(3, publi.getPublish_id());

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

    public Boolean createPublish(Publishes publi) {
        String query = "INSERT INTO publishes (publish_id, publish_name, statusDelete) VALUES (?, ?, ?)";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);

            ps.setString(1, publi.getPublish_id());
            ps.setString(2, publi.getPublish_name());
            ps.setBoolean(3, false);

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
        PublishesDAO dao = new PublishesDAO();

//        Publishes data = dao.getPublishById("1"); 
//        System.out.println(data);
//        List<Publishes> data = dao.getAllPublishes(); 
//        for(var item : data) {
//            System.out.println(item);
//        }
//        boolean data = dao.deletePublishById("1");
//        System.out.println(data);
//        Publishes pub = new Publishes("1", "Yoenggg", false); 
//        boolean data = dao.editPublishById(pub);
//        System.out.println(data);

        Publishes pub = new Publishes("11", "Yoenggg", false);
        boolean data = dao.createPublish(pub); 
        System.out.println(data);
    }
}
