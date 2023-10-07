/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.librarymanagement;

import java.util.Arrays;
import java.util.List;

public class LibraryManagement {

//    1 thủ thư - nhiều học sinh
//    1 thời điểm chỉ thực hiện cho 1 học sinh rùi tới học sinh khác
    static List<Book> generateListBook() {
        return Arrays.asList(
                new Book(1, "A", "A", true),
                new Book(2, "B", "A", true),
                new Book(3, "C", "A", true),
                new Book(4, "D", "A", true),
                new Book(5, "E", "A", true),
                new Book(6, "F", "A", true),
                new Book(7, "G", "A", true)
        );
    }

    public static void main(String[] args) {
        List<Book> books = generateListBook();

        Library lib = new Library(books);

        Thread std2 = new Thread(() -> {
            final String nameStd2 = "std2";
            while(true) {
                try {
                    Thread.sleep((int)Math.floor(Math.random() * 50 + 10));
                    lib.borrowBook(nameStd2, 1);
                    Thread.sleep((int)Math.floor(Math.random() * 1000 + 400));
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                lib.returnBook(nameStd2, 1);
            }
        });
        
        Thread std3 = new Thread(() -> {
            final String nameStd3 = "std3";
            while(true) {
                try {
                    Thread.sleep((int)Math.floor(Math.random() * 49 + 10));
                lib.borrowBook(nameStd3, 1);
                    Thread.sleep((int)Math.floor(Math.random() * 500 + 1));
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                lib.returnBook(nameStd3, 1);
            }
        });

        std2.start();
        std3.start();
    }
}
