public class Book {

    private String title;
    private String author;
    private int ISBN;
    private boolean available;

    // constructor
    public Book(String title, String author, int ISBN, boolean available) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.available = available;
    }

    // getters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return (
            "Book [Title: " +
            title +
            ", Author: " +
            author +
            ", ISBN: " +
            ISBN +
            ", Available: " +
            available +
            "]"
        );
    }
}
