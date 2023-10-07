/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {

    private volatile List<Book> books = null;

    public Library(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public synchronized boolean borrowBook(String name, int id) {
        Book searchedBook = this.findBookById(id);

        
        if (searchedBook == null || !searchedBook.isAvailable()) {
            System.out.println(name + " can not borrow book with book id: " + id);
            return false;
        }

        if (searchedBook.getNameWhoBorrowed().equals(name)) {
            System.out.println(name + " have borrowed please return this book again!");
            return false;
        }
            
        searchedBook.setAvailable(false);
        searchedBook.setNameWhoBorrowed(name);

        System.out.println(name + " have borrowed book sucessfully! id: " + id);
        return true;
    }

    public synchronized boolean returnBook(String name, int id) {
        Book searchedBook = this.findBookById(id);

        if (searchedBook == null) {
            System.out.println(name + " Can not return book with invalid id: " + id);
            return false;
        }

        if (searchedBook.isAvailable()) {
            System.out.println(name + "/ Book is available");
            return false;
        }
        
        if (!searchedBook.getNameWhoBorrowed().equals(name)) {
            System.out.println(name + " must wait for the other student reply book /" + searchedBook.getNameWhoBorrowed());
            return false;
        }

        searchedBook.setNameWhoBorrowed("");
        searchedBook.setAvailable(true);
        
        System.out.println(name + " have returned book sucessfully! id: " + id);

        return true;
    }

    private synchronized Book findBookById(int id) {
        Optional<Book> bookSearchedById = books.stream().filter(book -> id == book.getId()).findFirst();
        if (bookSearchedById.isPresent()) {
            return bookSearchedById.get();
        }
        return null;
    }

    public void displayBooks() {
        if (books.size() <= 0) {
            System.out.println("You should add more book into library");
            return;
        }

        for (Book b : this.books) {
            if (b.isAvailable()) {
                System.out.println(b.getAuthor() + " " + b.getTitle());
            }
        }
    }

}
