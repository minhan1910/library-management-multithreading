/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement;

public class Book {

    private int id;
    private String title;
    private String author;
    private boolean available;
    private String nameWhoBorrowed = "";

    public Book(String title, String author, boolean available) {
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public Book(int id, String title, String author, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }
    
    public void setAvailable(boolean status) {
        this.available = status;
    }
    
    public void setNameWhoBorrowed(String name) {
        this.nameWhoBorrowed = name;
    }
    
    public String getNameWhoBorrowed() {
        return this.nameWhoBorrowed;
    }
}
