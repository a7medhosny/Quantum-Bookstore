import models.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Create different types of books using BookType enum
        Book javaBasics = new Book("ISBN001", "Java Basics", 2018, 200.0, BookType.PAPERBOOK, 3, "John Doe");
        Book dartBasics = new Book("ISBN002", "Dart Basics", 2021, 300.0, BookType.PAPERBOOK, 3, "John Doe");
        Book flutterGuide = new Book("ISBN003", "Flutter Guide", 2022, 150.0, BookType.EBOOK, "John Doe"); // quantity defaults to 0
        Book demoOnly = new Book("ISBN004", "Demo Only", 2020, 0.0, BookType.DEMOBOOK, "John Doe");
        Book cppForKids = new Book("ISBN005", "Cpp For Kids", 2019, 120.0, BookType.EBOOK, "John Doe");


        // Add books to inventory
        inventory.addBook(javaBasics);
        inventory.addBook(dartBasics);
        inventory.addBook(flutterGuide);
        inventory.addBook(demoOnly);

        // Print all books in inventory
        System.out.println("\nQuantum book store: All Books in Inventory:");
        for (Book book : inventory.getBooks()) {
            System.out.println("- " + book.getTitle() + " (" + book.getISBN() + ")");
        }

        // Remove outdated books (older than 5 years)
        System.out.println("\nRemoving outdated books:");
        List<Book> outdatedBooks = inventory.removeOutdatedBooks(5);

        // Print books after removing outdated ones
        System.out.println("\nQuantum book store: All Books after removing outdated ones:");
        for (Book book : inventory.getBooks()) {
            System.out.println("- " + book.getTitle() + " (" + book.getISBN() + ")");
        }

        // Print list of outdated books removed
        System.out.println("\nQuantum book store: Outdated books removed:");
        for (Book book : outdatedBooks) {
            System.out.println("- " + book.getTitle() + " (" + book.getISBN() + ")");
        }

        // Buy a paper book (quantity is available)
        System.out.println("\nBuying 2 copies of Dart Basics (PaperBook):");
        inventory.buyBook("ISBN002", 2, "user@example.com", "123 Cairo Street");

        // Trying to buy more than available stock
        System.out.println("\nTrying to buy 2 more copies (exceeds remaining stock):");
        inventory.buyBook("ISBN002", 2, "user@example.com", "123 Cairo Street");

        // Buy an eBook (no stock limit)
        System.out.println("\nBuying Flutter Guide (EBook):");
        inventory.buyBook("ISBN003", 1, "user@example.com", "123 Cairo Street");

        // Trying to buy a demo book (not for sale)
        System.out.println("\nTrying to buy Demo Only (DemoBook):");
        inventory.buyBook("ISBN004", 1, "user@example.com", "123 Cairo Street");

        try {
            // Remove a book
            System.out.println("\nRemoving book Dart Basics:");
            inventory.removeBook(dartBasics);

            // Remove a book not in inventory
            System.out.println("\nRemoving book Cpp For Kids:");
            inventory.removeBook(cppForKids);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Final state of inventory
        System.out.println("\nQuantum book store: Final Books in Inventory:");
        for (Book book : inventory.getBooks()) {
            System.out.println("- " + book.getTitle() + " (" + book.getISBN() + ")");
        }
    }
}
