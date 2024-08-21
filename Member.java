import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;
    private String email;
    private String phoneNumber;
    private List<Book> borrowedBooks;

    //constructor
    public Member(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Book> getborrowedBooks() {
        return borrowedBooks;
    }

    // methods for borrowed a book and return it
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
        } else {
            System.out.println("The book is not Available for borrowing");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {} else {
            System.out.println("This book wasn't borrwed by this memeber");
        }
    }

    @Override
    public String toString() {
        return (
            "Member{name='" +
            name +
            "', email='" +
            email +
            "', phoneNumber='" +
            phoneNumber +
            "', borrowedBooks=" +
            borrowedBooks +
            "}"
        );
    }
}
