import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    Library libraryOne = new Library();
    List<Member> members = new ArrayList<>();

    public void looping() {
        while (true) {
            Scanner data = new Scanner(System.in);

            System.out.println("Welcome to the library.");
            System.out.println("1. Add a new book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search for a book");
            System.out.println("4. Register a new member");
            System.out.println("5. Borrow a book");
            System.out.println("6. Return a book");
            System.out.println("7. Display all books");
            System.out.println("8. Display all members");
            System.out.println("9. Exit the application");
            System.out.print("Option : ");

            String option = data.nextLine();
            switch (option) {
                case "1":
                    try {
                        Scanner bookData = new Scanner(System.in);
                        System.out.print(
                            "Enter book details (title, author, ISBN, available): "
                        );
                        String bookInfo = bookData.nextLine();
                        String[] bookDetails = bookInfo.split(", ");
                        String title = bookDetails[0];
                        String author = bookDetails[1];
                        int ISBN = Integer.parseInt(bookDetails[2]);
                        boolean available = Boolean.parseBoolean(
                            bookDetails[3]
                        );
                        Book newBook = new Book(title, author, ISBN, available);
                        libraryOne.addBook(newBook);
                        System.out.println(
                            "\u001B[32mBook added successfully\u001B[0m"
                        );
                    } catch (Exception e) {
                        System.out.println(
                            "\u001B[31mSomething went wrong, cannot add book\u001B[0m"
                        );
                    }
                    break;
                case "2":
                    try {
                        Scanner bookNameToDelate = new Scanner(System.in);
                        System.out.println("Enter book name : ");
                        String bookName = bookNameToDelate.nextLine();
                        Book bookToRemove = libraryOne.searchForBook(bookName);
                        libraryOne.removeBook(bookToRemove);
                        System.out.println(
                            "\u001B[32mBook removed successfully\u001B[0m"
                        );
                    } catch (Exception e) {
                        System.out.println(
                            "\u001B[31mCan't remove the book somthing went wrong!\u001B[0m"
                        );
                    }
                    break;
                case "3":
                    try {
                        Scanner bookNameToSeach = new Scanner(System.in);
                        System.out.println("Enter book name : ");
                        String bookNameToSearch = bookNameToSeach.nextLine();
                        //fix me it's file anyone null or success
                        System.out.println(
                            libraryOne.searchForBook(bookNameToSearch)
                        );
                        System.out.println(
                            "\u001B[32mBook found successfully\u001B[0m"
                        );
                        bookNameToSeach.close();
                    } catch (Exception e) {
                        System.out.println(
                            "\u001B[31mCan't find the book somthing went wrong!\u001B[0m"
                        );
                    }

                    break;
                case "4":
                    Scanner newMember = new Scanner(System.in);
                    System.out.println(
                        "Enter the member (name, email, phone-number) : "
                    );
                    String memberInfo = newMember.nextLine();
                    String[] memberInfoArray = memberInfo.split(", ");
                    String name = memberInfoArray[0];
                    String email = memberInfoArray[1];
                    String phoneNumer = memberInfoArray[2];
                    Member newMember2 = new Member(name, email, phoneNumer);
                    libraryOne.registerMember(newMember2);
                    System.out.println(libraryOne);
                    System.out.println(
                        "\u001B[32mBook Borrwed successfully\u001B[0m"
                    );
                    break;
                case "5":
                    Scanner dataBookAndMember = new Scanner(System.in);
                    System.out.println(
                        "Enter the info (email-of-member, book-title) : "
                    );
                    String memberAndBook = dataBookAndMember.nextLine();
                    String[] memberAndBookArray = memberAndBook.split(", ");
                    String memberEmail = memberAndBookArray[0];
                    String bookName = memberAndBookArray[1];
                    Member ourMember = libraryOne.getMemberInfo(memberEmail);
                    Book ourBook = libraryOne.searchForBook(bookName);
                    ourMember.borrowBook(ourBook);
                    break;
                case "6":
                    Scanner dataForReturnAbook = new Scanner(System.in);
                    System.out.println(
                        "Enter the info (email-of-member, book-title) : "
                    );
                    String returnBook = dataForReturnAbook.nextLine();
                    String[] returnBookArray = returnBook.split(", ");
                    String returnMemberEmail = returnBookArray[0];
                    String returnBookName = returnBookArray[1];
                    Member returnBookMember = libraryOne.getMemberInfo(
                        returnMemberEmail
                    );
                    Book returnBookname = libraryOne.searchForBook(
                        returnBookName
                    );
                    returnBookMember.returnBook(returnBookname);
                    break;
                case "7":
                    System.out.println("All Books : ");
                    for (Book book : libraryOne.getBooks()) {
                        System.out.println(book);
                    }

                    break;
                case "8":
                    System.out.println("All Members : ");
                    for (Member member : libraryOne.geteMembers()) {
                        System.err.println(member);
                    }
                    break;
                case "22":
                    System.out.println(libraryOne);
                    break;
                case "9":
                    System.out.println(
                        "Option 9 selected: Exit the application"
                    );
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your option not found, \nTry again ");
                    break;
            }
            System.out.println("\n\n");
        }
    }
}
