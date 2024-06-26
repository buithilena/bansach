/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author vuhoa
 */
public class Books {
    private String book_id; 
    private String book_name; 
    private String author_id; 
    private String category_id; 
    private String publish_id; 
    private String book_description; 
    private Float book_price; 
    private String book_image; 
    private int book_quantity_available; 
    private Boolean statusDelete;

    public Books() {
    }

    public Books(String book_id, String book_name, String author_id, String category_id, String publish_id, String book_description, Float book_price, String book_image, int book_quantity_available, Boolean statusDelete) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author_id = author_id;
        this.category_id = category_id;
        this.publish_id = publish_id;
        this.book_description = book_description;
        this.book_price = book_price;
        this.book_image = book_image;
        this.book_quantity_available = book_quantity_available;
        this.statusDelete = statusDelete;
    }

    public String getBook_id() {
        return book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public String getPublish_id() {
        return publish_id;
    }

    public String getBook_description() {
        return book_description;
    }

    public Float getBook_price() {
        return book_price;
    }

    public String getBook_image() {
        return book_image;
    }

    public int getBook_quantity_available() {
        return book_quantity_available;
    }

    public Boolean getStatusDelete() {
        return statusDelete;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public void setPublish_id(String publish_id) {
        this.publish_id = publish_id;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    public void setBook_price(Float book_price) {
        this.book_price = book_price;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }

    public void setBook_quantity_available(int book_quantity_available) {
        this.book_quantity_available = book_quantity_available;
    }

    public void setStatusDelete(Boolean statusDelete) {
        this.statusDelete = statusDelete;
    }

    @Override
    public String toString() {
        return "Books{" + "book_id=" + book_id + ", book_name=" + book_name + ", author_id=" + author_id + ", category_id=" + category_id + ", publish_id=" + publish_id + ", book_description=" + book_description + ", book_price=" + book_price + ", book_image=" + book_image + ", book_quantity_available=" + book_quantity_available + ", statusDelete=" + statusDelete + '}';
    }
    
}
