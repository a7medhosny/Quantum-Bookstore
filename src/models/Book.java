package models;

public class Book {

    private String ISBN;
    private String title;
    private String authorName;
    private int publicationYear;
    private double price;
    private int quantity;
    private BookType bookType;


    public Book(String ISBN, String title, int publicationYear, double price, BookType bookType, int quantity, String authorName) {
        this.ISBN = ISBN;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
        this.bookType = bookType;
        this.quantity = quantity;
        this.authorName = authorName;
    }


    public Book(String ISBN, String title, int publicationYear, double price, BookType bookType, String authorName) {
        this(ISBN, title, publicationYear, price, bookType, 0, authorName);
    }


    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BookType getBookType() {
        return bookType;
    }


    public void sell(int quantity, String email, String address) {
        switch (bookType) {
            case PAPERBOOK:
                if (quantity > this.quantity) {
                    throw new IllegalArgumentException("Quantum book store: Not enough stock for ISBN " + ISBN);
                }
                this.quantity -= quantity;
                double totalPaperPrice = price * quantity;
                System.out.println("Quantum book store: PaperBook [" + title + "] sold. Total price: " + totalPaperPrice);
                System.out.println("Quantum book store: Shipping to address: " + address);
                break;

            case EBOOK:
                double totalEBookPrice = price * quantity;
                System.out.println("Quantum book store: EBook [" + title + "] sold. Total price: " + totalEBookPrice);
                System.out.println("Quantum book store: Sending to email: " + email);
                break;

            case DEMOBOOK:
            default:
                throw new IllegalArgumentException("Quantum book store: Book [" + title + "] is not for sale.");
        }
    }
}
