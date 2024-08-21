import java.util.Scanner;

public class Console {

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
                    System.out.println("Option 1 selected: Add a new book");
                    break;
                case "2":
                    System.out.println("Option 2 selected: Remove a book");
                    break;
                case "3":
                    System.out.println("Option 3 selected: Search for a book");
                    break;
                case "4":
                    System.out.println(
                        "Option 4 selected: Register a new member"
                    );
                    break;
                case "5":
                    System.out.println("Option 5 selected: Borrow a book");
                    break;
                case "6":
                    System.out.println("Option 6 selected: Return a book");
                    break;
                case "7":
                    System.out.println("Option 7 selected: Display all books");
                    break;
                case "8":
                    System.out.println(
                        "Option 8 selected: Display all members"
                    );
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
