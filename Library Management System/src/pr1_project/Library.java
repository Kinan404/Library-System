/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr1_project;

public class Library {

    private Book[][] shelves;            // 2D array for shelves
    private User[] users;                // Array for registiring every student
    private Transaction[] transactions;  // Array to store all transactions
    public static int bookCount;         // Total number of books in the library
    public static int userCount;         // Total number of registered users
    private int transactionCount;        // Total number of transactions

    // Constructor and intilize the values of Shelves with capasity 40, with 100 users, and 250 transcations etc..
    public Library() {
        this.shelves = new Book[10][4];
        this.users = new User[100];
        this.transactions = new Transaction[250]; // 
        this.bookCount = 0;
        this.userCount = 0;
        this.transactionCount = 0;
    }

    public User[] getUsers() {
        return users;
    }

    // Add book fuction :
    public void AddBook(Book book) {
        // Check if this book actully exict :
        for (int i = 0; i < shelves.length; i++) {
            for (int j = 0; j < 4 ; j++) {
                if (shelves[i][j] != null && shelves[i][j].getAuthor().trim().equalsIgnoreCase(book.getAuthor().trim()) && shelves[i][j].getTitle().trim().equalsIgnoreCase(book.getTitle().trim())) {
                    shelves[i][j].updatecount(book.getTotalcopies());
                    System.out.println("This book is already exist in the library, so we increased the total copies");
                    return;
                }
            }

        }
        // calculation for determine the place in the array that where we will put the book
        for (int i = 0; i < shelves.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (shelves[i][j] == null) {
                    shelves[i][j] = book;
                    bookCount++;
                    System.out.println("Book '" + book.getTitle().trim() + "' by " + book.getAuthor().trim() + " has been added with " + book.getTotalcopies() + " copies.");
                    return;
                }
            }
        }

        // if reachs to here so, there is no enough place so we will increase the size of the array of shelves.
        Book[][] newShelves = new Book[shelves.length + 1][4];
        for (int i = 0; i < shelves.length; i++) {
            for (int j = 0; j < 4; j++) {
                newShelves[i][j] = shelves[i][j];
            }
        }
        // Storing the book 
        newShelves[shelves.length][0] = book;
        
        shelves = newShelves;
        bookCount++;
        System.out.println("One shelve has been added becuase of all shelved filled'" + book.getTitle() + "' added with " + book.getTotalcopies() + " copies.");
        return;

    }

    // Add User function : 
    public void AddUser(User user) {

        // Checi if this user actully exict :
        for (int i = 0; i < this.users.length; i++) {
            if (users[i] != null && user.getEmail().trim().equalsIgnoreCase(users[i].getEmail().trim())) {
                System.out.println("This user has been add before");
                return;
            }
        }
        
        System.out.println("The user has been registered succefully.");
        users[userCount] = user;
        userCount++;
        return;
    }

    // function to display all book 
    public void displayAllBooks() {
        System.out.println("Showing all books in our library:");
        if (bookCount == 0) {
            System.out.println("!!!! There is no book in library !!!!");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            for (int j = 0; j < 4; j++) {
                if (shelves[i][j] != null) {
                    Book book = shelves[i][j];
                    System.out.println("Title: " + book.getTitle()
                            + ", Author: " + book.getAuthor()
                            + ", Available Copies: " + book.getCountcopies()
                            + ", Total Copies: " + book.getTotalcopies());
                }
            }
        }
    }

    ///////////////////////// Function for display the Transcations ///////////////////////////
    public void displaytrancaction() {
        System.out.println("History of the Transactions :");

        // Check if there is elements in the array 
        if (transactionCount == 0) {
            System.out.println("There is no transaction before !!");
            return;
        }
        // Print every element in the array of transcations
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null) {
                System.out.println(transactions[i].getTransactionDetails());
            }
        }
    }

//////////////////////////////////////////////////////////////////// BORROWING function ///////////////////////////////////////////////////////////////
    public void borrow_Book(String userEmail, String bookTitle, String bookAuthor) {
        // Find the user by email
        User user_u = null;
        for (int i = 0; i < userCount; i++) {
            if (users[i].getEmail().trim().equalsIgnoreCase(userEmail.trim())) {
                user_u = users[i];
            }
        }
        // if the user_u = null so that's means we do not have this user
        if (user_u == null) {
            System.out.println("Sorry this user not found by this email.");
            return;
        }

        //Find the book by title and author
        Book book_b = null;
        for (int i = 0; i < shelves.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (shelves[i][j] != null
                        && shelves[i][j].getTitle().trim().equalsIgnoreCase(bookTitle.trim())
                        && shelves[i][j].getAuthor().trim().equalsIgnoreCase(bookAuthor.trim())) {
                    book_b = shelves[i][j];
                }
            }
        }
        if (book_b == null) {
            System.out.println("Sorry this book '" + bookTitle + "' by " + bookAuthor + " not found.");
            return;
        }

        // Borrow the book
        user_u.borrowbook(book_b, user_u.getName());
        // We made a object of Transaction and than we added to the array to save it.
        Transaction tranc = new Transaction(user_u, book_b, "Borrow");
        transactions[transactionCount] = tranc;
        transactionCount++;
        return;
    }
//////////////////////////////////////////  function for RETURNING the book  ////////////////////////////////////////////////////////////

    public void return_Book(String userEmail, String bookTitle, String bookAuthor) {
        // Find the user by email
        User user_u = null;
        for (int i = 0; i < userCount; i++) {
            if (users[i].getEmail().trim().equalsIgnoreCase(userEmail.trim())) {
                user_u = users[i];
            }
        }
        // if the user_u = null so that's means we do not have this user
        if (user_u == null) {
            System.out.println("Sorry this user '" + user_u + "' " + " by this email not found.");
            return ;
        }

        // Checking if the book excit
        Book book_b = null;
        for (int i = 0; i < user_u.AllborrowedBooks.length; i++) {
            if (user_u.AllborrowedBooks[i] != null
                    && user_u.AllborrowedBooks[i].getTitle().trim().equalsIgnoreCase(bookTitle.trim())
                    && user_u.AllborrowedBooks[i].getAuthor().trim().equalsIgnoreCase(bookAuthor.trim())) {
                book_b = user_u.AllborrowedBooks[i];
            }
        }

        if (book_b == null) {
            System.out.println("Sorry this user '" + user_u.getName() + "' has not borrowed the book '" + bookTitle.trim() + "'.");
            return ;
        }

        // Return the book
        user_u.returnBook(book_b);
        user_u.borrowedcount--;

        // find the book in the shelves and return it (Increase the number of copies);
        for (int i = 0; i < shelves.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (shelves[i][j] != null && shelves[i][j].getTitle().trim().equalsIgnoreCase(bookTitle.trim())
                        && shelves[i][j].getAuthor().trim().equalsIgnoreCase(bookAuthor.trim())) {
                    shelves[i][j].Countcopies++;
                }
            }
        }

        Transaction tranc = new Transaction(user_u, book_b, "Return");
        transactions[transactionCount] = tranc;
        transactionCount++;
        System.out.println("Book '" + bookTitle.trim() + "' has been retured succesfully by " + user_u.getName().trim() + ".");
        return ;
    }

}
