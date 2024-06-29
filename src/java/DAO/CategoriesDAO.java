/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import entity.Categories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vuhoa
 */
public class CategoriesDAO {
    Connection conn = null; 
    PreparedStatement ps = null; 
    ResultSet rs = null; 
    
    public Categories getCategoryById(String id) {
        String query = "Select * from categories where category_id = ? and statusDelete = 0";

        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Categories(rs.getString(1), rs.getString(2), rs.getBoolean(3));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Categories> getAllCategories(){
        List<Categories> data = new ArrayList<>();
        var query = "Select * from categories where statusDelete = 0"; 
        
        try {
            conn = new DBContext().getConnect(); 
            ps = conn.prepareStatement(query); 
            rs = ps.executeQuery(); 
            
            while(rs.next()) {
                Categories cate = new Categories(rs.getString("category_id"), rs.getString("category_name"), rs.getBoolean("statusDelete"));
                data.add(cate);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
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
    
    public Boolean deleteCategoryById(String id) {
        String query = "UPDATE categories SET statusDelete = 1 WHERE category_id = ?";

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
    
    public Boolean editCategory(Categories cate) {
        String query  = "UPDATE categories set category_name = ?, statusDelete = ? where category_id = ?";
        
        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);

            ps.setString(1, cate.getCategory_name());
            ps.setBoolean(2, cate.getStatusDelete());
            ps.setString(3, cate.getCategory_id());

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
    
    public Boolean createCategory(Categories cate) {
        String query = "insert into categories (category_name, statusDelete) values (?, ?)";
        try {
            conn = new DBContext().getConnect();
            ps = conn.prepareStatement(query);

            ps.setString(1, cate.getCategory_name());
            ps.setBoolean(2, cate.getStatusDelete());

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
        CategoriesDAO dao = new CategoriesDAO();
        
//        Categories data = dao.getCategoryById("1");
//        System.out.println(data);

        

//        boolean data = dao.deleteCategoryById("1"); 
//        System.out.println(data);
        
//        Categories cate = new Categories("1", "Yoengggg", false); 
//        Boolean data = dao.editCategory(cate);
//        System.out.println(data);


        Categories cate = new Categories("Fish", false); 
        Boolean res = dao.createCategory(cate); 
        
        List<Categories> data = dao.getAllCategories(); 
        for(var item : data) {
            System.out.println(item);
        }
    }
}
