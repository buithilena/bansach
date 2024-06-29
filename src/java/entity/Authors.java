/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author vuhoa
 */
public class Authors {
    private String author_id; 
    private String author_name; 
    private String author_bio; 
    private Boolean statusDelete;
    
    public Authors() {
    }

    public Authors(String author_name, String author_bio, Boolean statusDelete) {
        this.author_name = author_name;
        this.author_bio = author_bio;
        this.statusDelete = statusDelete;
    }
    
    
    public Authors(String author_id, String author_name, String author_bio, Boolean statusDelete) {
        this.author_id = author_id;
        this.author_name = author_name;
        this.author_bio = author_bio;
        this.statusDelete = statusDelete;
    }
    
 
    public String getAuthor_id() {
        return author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getAuthor_bio() {
        return author_bio;
    }

    public Boolean getStatusDelete() {
        return statusDelete;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public void setAuthor_bio(String author_bio) {
        this.author_bio = author_bio;
    }

    public void setStatusDelete(Boolean statusDelete) {
        this.statusDelete = statusDelete;
    }

    @Override
    public String toString() {
        return "Authors{" + "author_id=" + author_id + ", author_name=" + author_name + ", author_bio=" + author_bio + ", statusDelete=" + statusDelete + '}';
    }
    
}
