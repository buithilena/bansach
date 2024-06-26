/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author vuhoa
 */
public class ShoppingCart {
    private String shopping_cart_id; 
    private String customer_id; 
    private String book_id; 
    private String payment_id; 
    private int shopping_cart_quantity;
    private Boolean statusDelete;

    public ShoppingCart() {
    }

    public ShoppingCart(String shopping_cart_id, String customer_id, String book_id, String payment_id, int shopping_cart_quantity, Boolean statusDelete) {
        this.shopping_cart_id = shopping_cart_id;
        this.customer_id = customer_id;
        this.book_id = book_id;
        this.payment_id = payment_id;
        this.shopping_cart_quantity = shopping_cart_quantity;
        this.statusDelete = statusDelete;
    }

    public String getShopping_cart_id() {
        return shopping_cart_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public int getShopping_cart_quantity() {
        return shopping_cart_quantity;
    }

    public Boolean getStatusDelete() {
        return statusDelete;
    }

    public void setShopping_cart_id(String shopping_cart_id) {
        this.shopping_cart_id = shopping_cart_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public void setShopping_cart_quantity(int shopping_cart_quantity) {
        this.shopping_cart_quantity = shopping_cart_quantity;
    }

    public void setStatusDelete(Boolean statusDelete) {
        this.statusDelete = statusDelete;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "shopping_cart_id=" + shopping_cart_id + ", customer_id=" + customer_id + ", book_id=" + book_id + ", payment_id=" + payment_id + ", shopping_cart_quantity=" + shopping_cart_quantity + ", statusDelete=" + statusDelete + '}';
    }
    
    
}
