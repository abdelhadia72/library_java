import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    Library libraryOne = new Library();
    List<Member> members = new ArrayList<>();

    public void looping() {
        libraryOne.loadFromFile("db.txt");
        Scanner data = new Scanner(System.in);
        while (true) {
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
                        System.out.print(
                            "Enter book details (title, author, ISBN, available): "
                        );
                        String bookInfo = data.nextLine();
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
                        System.out.println("Enter book name : ");
                        String bookName = data.nextLine();
                        Book bookToRemove = libraryOne.searchForBook(bookName);
                        if (bookToRemove != null) {
                            libraryOne.removeBook(bookToRemove);
                            System.out.println(
                                "\u001B[32mBook removed successfully\u001B[0m"
                            );
                        } else {
                            System.out.println(
                                "\u001B[31mBook not found\u001B[0m"
                            );
                        }
                    } catch (Exception e) {
                        System.out.println(
                            "\u001B[31mCan't remove the book, something went wrong!\u001B[0m"
                        );
                    }
                    break;
                case "3":
                    try {
                        System.out.println("Enter book name : ");
                        String bookNameToSearch = data.nextLine();
                        Book foundBook = libraryOne.searchForBook(
                            bookNameToSearch
                        );
                        if (foundBook != null) {
                            System.out.println(foundBook);
                            System.out.println(
                                "\u001B[32mBook found successfully\u001B[0m"
                            );
                        } else {
                            System.out.println(
                                "\u001B[31mBook not found\u001B[0m"
                            );
                        }
                    } catch (Exception e) {
                        System.out.println(
                            "\u001B[31mCan't find the book, something went wrong!\u001B[0m"
                        );
                    }
                    break;
                case "4":
                    try {
                        System.out.println(
                            "Enter the member (name, email, phone-number) : "
                        );
                        String memberInfo = data.nextLine();
                        String[] memberInfoArray = memberInfo.split(", ");
                        String name = memberInfoArray[0];
                        String email = memberInfoArray[1];
                        String phoneNumber = memberInfoArray[2];
                        Member newMember = new Member(name, email, phoneNumber);
                        libraryOne.registerMember(newMember);
                        System.out.println(
                            "\u001B[32mThe Member added successfully\u001B[0m"
                        );
                    } catch (Exception e) {
                        System.out.println(
                            "\u001B[31mCan't add the member, something went wrong!\u001B[0m"
                        );
                    }
                    break;
                case "5":
                    try {
                        System.out.println(
                            "Enter the info (email-of-member, book-title) : "
                        );
                        String memberAndBook = data.nextLine();
                        String[] memberAndBookArray = memberAndBook.split(", ");
                        String memberEmail = memberAndBookArray[0];
                        String bookName = memberAndBookArray[1];
                        Member ourMember = libraryOne.getMemberInfo(
                            memberEmail
                        );
                        Book ourBook = libraryOne.searchForBook(bookName);
                        if (ourMember != null && ourBook != null) {
                            ourMember.borrowBook(ourBook);
                            System.out.println(
                                "\u001B[32mThe book borrowed successfully\u001B[0m"
                            );
                        } else {
                            System.out.println(
                                "\u001B[31mMember or Book not found\u001B[0m"
                            );
                        }
                    } catch (Exception e) {
                        System.out.println(
                            "\u001B[31mCan't borrow the book, something went wrong!\u001B[0m"
                        );
                    }
                    break;
                case "6":
                    try {
                        System.out.println(
                            "Enter the info (email-of-member, book-title) : "
                        );
                        String returnBook = data.nextLine();
                        String[] returnBookArray = returnBook.split(", ");
                        String returnMemberEmail = returnBookArray[0];
                        String returnBookName = returnBookArray[1];
                        Member returnBookMember = libraryOne.getMemberInfo(
                            returnMemberEmail
                        );
                        Book returnBookname = libraryOne.searchForBook(
                            returnBookName
                        );
                        if (
                            returnBookMember != null && returnBookname != null
                        ) {
                            returnBookMember.returnBook(returnBookname);
                            System.out.println(
                                "\u001B[32mThe book returned successfully\u001B[0m"
                            );
                        } else {
                            System.out.println(
                                "\u001B[31mMember or Book not found\u001B[0m"
                            );
                        }
                    } catch (Exception e) {
                        System.out.println(
                            "\u001B[31mCan't return the book, something went wrong!\u001B[0m"
                        );
                    }
                    break;
                case "7":
                    try {
                        System.out.println("All Books : ");
                        for (Book book : libraryOne.getBooks()) {
                            System.out.println(book);
                        }
                        System.out.println(
                            "\u001B[32mBooks found successfully\u001B[0m"
                        );
                    } catch (Exception e) {
                        System.out.println(
                            "\u001B[31mSomething went wrong, can't find Books!\u001B[0m"
                        );
                    }
                    break;
                case "8":
                    try {
                        System.out.println("All Members : ");
                        for (Member member : libraryOne.getMembers()) {
                            System.out.println(member);
                        }
                        System.out.println(
                            "\u001B[32mMembers found successfully\u001B[0m"
                        );
                    } catch (Exception e) {
                        System.out.println(
                            "\u001B[31mSomething went wrong while searching for Members\u001B[0m"
                        );
                    }
                    break;
                case "99":
                    try {
                        System.out.println(libraryOne);
                    } catch (Exception e) {
                        System.out.println(
                            "\u001B[31mNo Library on 99! Oops\u001B[0m"
                        );
                    }
                    break;
                case "9":
                    System.out.println(
                        "Option 9 selected: Exit the application"
                    );
                    libraryOne.saveToFile("db.txt");
                    data.close();
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
