/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author vuhoa
 */
public class Categories {
    private String category_id; 
    private String category_name; 
    private Boolean statusDelete; 

    public Categories() {
    }

    public Categories(String category_name, Boolean statusDelete) {
        this.category_name = category_name;
        this.statusDelete = statusDelete;
    }

    public Categories(String category_id, String category_name, Boolean statusDelete) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.statusDelete = statusDelete;
    }

    public String getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public Boolean getStatusDelete() {
        return statusDelete;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void setStatusDelete(Boolean statusDelete) {
        this.statusDelete = statusDelete;
    }

    @Override
    public String toString() {
        return "Categories{" + "category_id=" + category_id + ", category_name=" + category_name + ", statusDelete=" + statusDelete + '}';
    }
    
    
}
