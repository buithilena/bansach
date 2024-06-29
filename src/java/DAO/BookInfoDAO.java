/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import entity.BookInfo;
import entity.Categories;
import entity.Books;
import entity.Publishes;
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
public class BookInfoDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<BookInfo> getAllBooksInfo() {
        List<BookInfo> data = new ArrayList<>();
        String query = "select books.book_id, books.book_name, "
                + "authors.author_name, categories.category_name, publishes.publish_name, "
                + "books.book_description, books.book_price, books.book_image, "
                + "books.book_quantity_available, books.statusDelete "
                + "from books "
                + "left join authors on books.author_id = authors.author_id "
                + "left join categories on categories.category_id = books.category_id "
                + "left join publishes on books.publish_id = publishes.publish_id "
                + "where books.statusDelete = 0";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Books book = new Books(
                        rs.getString("book_id"),
                        rs.getString("book_name"),
                        rs.getString("author_name"),
                        rs.getString("category_name"),
                        rs.getString("publish_name"),
                        rs.getString("book_description"),
                        rs.getFloat("book_price"),
                        rs.getString("book_image"),
                        rs.getInt("book_quantity_available"),
                        rs.getBoolean("statusDelete")
                );

                Authors author = new Authors();
                author.setAuthor_name(rs.getString("author_name")); // assuming Author class has appropriate setters

                Categories category = new Categories();
                category.setCategory_name(rs.getString("category_name")); // assuming Category class has appropriate setters

                Publishes publish = new Publishes();
                publish.setPublish_name(rs.getString("publish_name")); // assuming Publish class has appropriate setters

                BookInfo bookInfo = new BookInfo();
                bookInfo.setBook(book);
                bookInfo.setAuthor(author);
                bookInfo.setCategory(category);
                bookInfo.setPublish(publish);

                data.add(bookInfo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
            // (Assuming rs, ps, and conn are declared as instance variables)
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
    
    public static void main(String[] args) {
        
        BookInfoDAO bookInfoDAO = new BookInfoDAO();
        List<BookInfo> booksInfo = bookInfoDAO.getAllBooksInfo();
        for (BookInfo bookInfo : booksInfo) {
            Books book = bookInfo.getBook();
            Authors author = bookInfo.getAuthor();
            Categories category = bookInfo.getCategory();
            Publishes publish = bookInfo.getPublish();

            // In ra thông tin của mỗi cuốn sách và các thông tin liên kết
            System.out.println("Book ID: " + book.getBook_id());
            System.out.println("Book Name: " + book.getBook_name());
            System.out.println("Author Name: " + author.getAuthor_name());
            System.out.println("Category Name: " + category.getCategory_name());
            System.out.println("Publish Name: " + publish.getPublish_name());
            System.out.println("Description: " + book.getBook_description());
            System.out.println("Price: " + book.getBook_price());
            System.out.println("Image: " + book.getBook_image());
            System.out.println("Quantity Available: " + book.getBook_quantity_available());
            System.out.println("Status Delete: " + book.getStatusDelete());
            System.out.println("-----------------------------------------");
        }
    }
}
