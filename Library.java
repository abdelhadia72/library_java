import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Member> members;

    // constructor
    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // method for add and remove books
    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    // search for book
    public Book searchForBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // methodes for adding and get info of the member
    public void registerMember(Member member) {
        members.add(member);
    }

    // get member info
    public Member getMemberInfo(String email) {
        for (Member member : members) {
            if (member.getEmail().equalsIgnoreCase(email)) {
                return member;
            }
        }
        return null;
    }

    // methodes for borrow and return books
    public void borrowBook(Member member, Book book) {
        if (books.contains(book) && book.isAvailable()) {
            member.borrowBook(book);
            book.setAvailable(false);
        } else {
            System.out.println("The book is not available for borrowing .");
        }
    }

    public void returnBook(Member member, Book book) {
        member.returnBook(book);
        book.setAvailable(true);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> geteMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "Library Books " + books + "members" + members + " .";
    }
}
