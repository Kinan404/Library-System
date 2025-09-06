package pr1_project;

import java.util.Scanner;

public class main {


    // Function for adding new book
    public static void adding_book(Library lib) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book Title: ");
        String booktitle = sc.nextLine();
        System.out.println("Enter Author: ");
        String bookauothor = sc.nextLine();
        System.out.println("Enter Total Copies: ");
        int totalcop = sc.nextInt();
        Book book = new Book(booktitle, bookauothor, totalcop, totalcop);
        lib.AddBook(book);

//        System.out.println("Write the name : ");
    }

    // Function for Register a user
    public static void Register_User(Library lib) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User Name: ");
        String username = sc.nextLine();
        System.out.println("Enter User Email: ");
        String useremail = sc.nextLine();
        User user = new User(username, useremail);
        lib.AddUser(user);

    }

    // Function for Borrowing a book
    public static void borrowBook(Library lib) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User Email: ");
        String useremail = sc.nextLine();
        System.out.println("Enter Book Title: ");
        String booktitle = sc.nextLine();
        System.out.println("Enter Book Author: ");
        String bookauthor = sc.nextLine();
        lib.borrow_Book(useremail, booktitle, bookauthor);

    }

    // Function for Returning a book
    public static void return_book(Library lib) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User Email: ");
        String useremail = sc.nextLine();
        System.out.println("Enter Book Title: ");
        String booktitle = sc.nextLine();
        System.out.println("Enter Book Author: ");
        String bookauthor = sc.nextLine();
        lib.return_Book(useremail, booktitle, bookauthor);
    }

    // Function to display all the BOOKS 
    public static void display_books(Library lib) {
        lib.displayAllBooks();
    }

    // Function to display all the transcations 
    public static void display_transcactions(Library lib) {
        lib.displaytrancaction();
    }

    public static void main(String[] args) {

        // Welcoming 
        System.out.println("\n**********************************");
        System.out.println("!! Welcome to Library Management!!");
        System.out.println("**********************************\n ▪ Register users");

        // Intiazing the Library 
        Library library = new Library();
        
        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.println("*__ The Menu __*\n"
                    + "1- Add n new book.\n"
                    + "2- Register users.\n"
                    + "3- Borrow books.\n"
                    + "4- Return books.\n"
                    + "5- Display all the books.\n"
                    + "6- View all transactions.\n"
                    + "7- Exit the program.\n");

            String chose = sc.next();
            if (chose.equals("1")) {
                adding_book(library);
            } else if (chose.equals("2")) {
                Register_User(library);
            } else if (chose.equals("3")) {
                borrowBook(library);
            } else if (chose.equals("4")) {
                return_book(library);
            } else if (chose.equals("5")) {
                display_books(library);
            } else if (chose.equals("6")) {
                display_transcactions(library);
            } else if (chose.equals("7")) {
                System.out.println("\n**************************************");
                System.out.println("**** Program exited succesfully ! ****");
                System.out.println("**************************************\n");
                break;
            } else {
                System.out.println("Please enter a valid number! (1,2,3,4,5,6,7^\n)");
            }
        }

    }
}
