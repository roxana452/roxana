
package com.mycompany.libraryapp;


public class Libraryapp {

    public static void main(String[] args) {
      library library = new library();
        
        library.addBook(new book(1, "The Secret History", "Donna Tart"));
        library.addBook(new book(2, "The Picture of Dorian Gray", "Oscar Wilde"));
        library.addBook(new book(3, "The Great Gatsby","F.Scott Fitzgerald"));
        library.addBook(new book(4, "1984","George Orwell"));
        library.addBook(new book(5, "Wuthering Heights","Emily Bronte"));
        library.addBook(new book(6, "To Kill a Mockingbird","Harper Lee"));
        library.addBook(new book(7, "Pride and Prejudice","Jane Austen"));
        library.addBook(new book(8, "Frankenstein","Mary Shelley"));
        library.addBook(new book(9, "The Alchemist","Paulo Coelho"));
        library.addBook(new book(10, "Animal Farm","George Orwell"));
        
        //afisam toate cartile
        System.out.println("All books:");
        for(book book: library.getBooks())
        {
            System.out.println("ID:" + book.getId() + ",Title:" + book.getTitle() + ", Author: " + book.getAuthor() +", Available: " + book.isAvailable());
        }
        
        //imprumuta o carte
        System.out.println("\nBorrowing a book with ID 1...");
        library.borrowBook(1);
        
        //incercareaa de aa imprumuta aceeasi carte de 2 ori
        System.out.println("\nAttempting to borrow book with ID1 again...");
        library.borrowBook(1);
        
        //returnare
        System.out.println("\nReturning book with ID 1...");
        library.returnBook(1);
        
        //afisarea cartilor dupa returnare
        System.out.println("\nAll books in the library after returning the book:");
        for(book book : library.getBooks()){
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Available: " + book.isAvailable());
        }
}
}
  