package models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Inventory {

    private List<Book> books;

    public Inventory() {
        books = new ArrayList<>();
    }


    public void addBook(Book book) {
        System.out.println("Quantum book store: Book added - \"" + book.getTitle() + "\" (ISBN: " + book.getISBN() + ")");
        books.add(book);
    }


    public void removeBook(Book book) {
        if (books.contains(book)) {
            System.out.println("Quantum book store: Book removed - \"" + book.getTitle() + "\" (ISBN: " + book.getISBN() + ")");
            books.remove(book);
        } else {
            throw new IllegalArgumentException("Quantum book store: Cannot remove book - Book not found in inventory.");
        }
    }


    public void buyBook(String ISBN, int quantity, String email, String address) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                try {
                    book.sell(quantity, email, address);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                return; // Stop after finding the first match
            }
        }
        System.out.println("Quantum book store: Book with ISBN " + ISBN + " not found.");
    }


    public List<Book> removeOutdatedBooks(int maxAge) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        List<Book> outdatedBooks = new ArrayList<>();
        List<Book> copyOfBooks = getCopyOfBooks();

        for (Book book : copyOfBooks) {
            int age = currentYear - book.getPublicationYear();
            if (age > maxAge) {
                outdatedBooks.add(book);
                books.remove(book);
                System.out.println("Quantum book store: Outdated book removed - \"" + book.getTitle() + "\"");
            }
        }

        return outdatedBooks;
    }


    public List<Book> getBooks() {
        return books;
    }


    private List<Book> getCopyOfBooks() {
        return new ArrayList<>(books);
    }
}
