public class Main {

    public static void main(String[] args) {
        // create library
        Library libraryx1 = new Library();

        // create some books
        var book1 = new Book("The lama", "Jhon ma", 82934329, true);
        var book2 = new Book("The north", "Sarah Smtih", 1237123, true);

        // create member
        var member1 = new Member("ali", "ali@joma.dev", "+183974823");

        // assign the member to the library
        libraryx1.registerMember(member1);

        // borrow new book
        member1.borrowBook(book1);
        member1.borrowBook(book2);

        Console console = new Console();
        console.looping();
    }
}
