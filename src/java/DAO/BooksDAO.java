/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import entity.Books;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vuhoa
 */
public class BooksDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Books getBookById(String id) {
        String query = "Select * from books where book_id = ? and statusDelete = 0";
        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Books(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getFloat(7), rs.getString(8), rs.getInt(9), rs.getBoolean(10));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Books> getAllBooks() {
        List<Books> data = new ArrayList<>();
        String query = "SELECT * FROM books where statusDelete = 0";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Books res = new Books(
                        rs.getString("book_id"),
                        rs.getString("book_name"),
                        rs.getString("author_id"),
                        rs.getString("category_id"),
                        rs.getString("publish_id"),
                        rs.getString("book_description"),
                        rs.getFloat("book_price"),
                        rs.getString("book_image"),
                        rs.getInt("book_quantity_available"),
                        rs.getBoolean("statusDelete")
                );
                data.add(res);
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

    public Boolean deleteBookById(String id) {
        String query = "UPDATE books SET statusDelete = 1 WHERE book_id = ?";

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

    public Boolean editBookById(Books book) {
        String query = "UPDATE books SET book_name = ?, author_id = ?, category_id = ?, publish_id = ?, book_description = ?, book_price = ?, book_image = ?, book_quantity_available = ?, statusDelete = ?  WHERE book_id = ?";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);

            ps.setString(1, book.getBook_name());
            ps.setString(2, book.getAuthor_id());
            ps.setString(3, book.getCategory_id());
            ps.setString(4, book.getPublish_id());
            ps.setString(5, book.getBook_description());
            ps.setFloat(6, book.getBook_price());
            ps.setString(7, book.getBook_image());
            ps.setInt(8, book.getBook_quantity_available());
            ps.setBoolean(9, book.getStatusDelete());
            ps.setString(10, book.getBook_id());

            int rowsUpdated = ps.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException ex) {
            return false;
        }
    }

    public Boolean createBook(Books book) {
        String query = "INSERT INTO books (book_name, author_id, category_id, publish_id, book_description, book_price, book_image, book_quantity_available, statusDelete) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);

            ps.setString(1, book.getBook_name());
            ps.setString(2, book.getAuthor_id());
            ps.setString(3, book.getCategory_id());
            ps.setString(4, book.getPublish_id());
            ps.setString(5, book.getBook_description());
            ps.setFloat(6, book.getBook_price());
            ps.setString(7, book.getBook_image());
            ps.setInt(8, book.getBook_quantity_available());
            ps.setBoolean(9, book.getStatusDelete());

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
        BooksDAO dao = new BooksDAO();
        //        Books data = dao.getBookById("B1");
        //        System.out.println(data);

//        boolean data = dao.deleteBookById("B1"); 
//        System.out.println(data);
        Books book = new Books( "Yoenggg", "AU001", "CT001", "PB001", "Yoengggg", (float) 9999, "Yoenggg", 1000, Boolean.FALSE);
        boolean res = dao.createBook(book);
        List<Books> data = dao.getAllBooks();
        for (var item : data) {
            System.out.println(item);
        }
    }
}
