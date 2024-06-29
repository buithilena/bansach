/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import entity.Authors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vuhoa
 */
public class AuthorsDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Authors getAuthorById(String id) {
        String query = "Select * from authors where author_id = ? and statusDelete = 0";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Authors(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Authors> getAllAuthors() {
        List<Authors> authorsList = new ArrayList<>();
        String query = "SELECT * FROM authors where statusDelete = 0";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Authors author = new Authors(
                        rs.getString("author_id"),
                        rs.getString("author_name"),
                        rs.getString("author_bio"),
                        rs.getBoolean("statusDelete")
                );
                authorsList.add(author);
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
        return authorsList;
    }

    public Boolean deleteAuthorById(String id) {
        String query = "UPDATE authors SET statusDelete = 1 WHERE author_id = ?";

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

    public Boolean editAuthorById(Authors author) {
        String query = "UPDATE authors SET author_name = ?, author_bio = ?, statusDelete = 0 WHERE author_id = ?";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);

            ps.setString(1, author.getAuthor_name());
            ps.setString(2, author.getAuthor_bio());
            ps.setString(3, author.getAuthor_id());

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

    public Boolean createAuthor(Authors author) {
        String query = "INSERT INTO authors ( author_name, author_bio, statusDelete) VALUES ( ?, ?, ?)";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);

            ps.setString(1, author.getAuthor_name());
            ps.setString(2, author.getAuthor_bio());
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
        AuthorsDAO dao = new AuthorsDAO();

//        Authors author = dao.getAuthorById("1");
//        System.out.println(author);
//        
//        
//        boolean res = dao.deleteAuthorById("1");
//        System.out.println(res);
//          Authors author = new Authors("2", "Yoenggg", "Yoeng is mine", Boolean.FALSE);
//          boolean res = dao.editAuthorById(author);
//          System.out.println(res);
        Authors author = new Authors("Fish", "Fish of yoenggg", false);
        boolean res = dao.createAuthor(author);
        System.out.println(res);
        List<Authors> list = dao.getAllAuthors();
        for (Authors item : list) {
            System.out.println(item);
        }
    }
}
