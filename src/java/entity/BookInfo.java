/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import entity.Categories;
import entity.Books;
import entity.Publishes;
import entity.Authors;

/**
 *
 * @author vuhoa
 */
public class BookInfo {

    private Books book;
    private Authors author;
    private Categories category;
    private Publishes publish;

    public BookInfo() {
    }

    public BookInfo(Books book, Authors author, Categories category, Publishes publish) {
        this.book = book;
        this.author = author;
        this.category = category;
        this.publish = publish;
    }

    public Books getBook() {
        return book;
    }

    public Authors getAuthor() {
        return author;
    }

    public Categories getCategory() {
        return category;
    }

    public Publishes getPublish() {
        return publish;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public void setPublish(Publishes publish) {
        this.publish = publish;
    }
    
}
