package pr1_project;
public class User {

    private String name;    
    private String email;
    Book[] AllborrowedBooks; // Array for borrowed books
    public int borrowedcount;    // Number of books currently borrowed

    // Constructor and intilize the values, such as book array with 3 size
    public User(String n, String e) {
        this.name = n;
        this.email = e;
        this.AllborrowedBooks = new Book[3]; // Max 3 books
        this.borrowedcount = 0;
    }

    // function for borrowing that check if the user borrowed more than 3 books or if the book not available now
    public void borrowbook(Book book, String username) {
        if (borrowedcount >= 3) {
            System.out.println("You are not allowed to borrow more than 3 books togather");
            return;
        }
        // Check if there is enough copies of book
        if (book.getCountcopies() <= 0) {
            System.out.println("Book '" + book.getTitle() + "' is not available for now.");
            return;
        }
        // if reachs here, so the user can borrowd the book :
        System.out.println("Book '" + book.getTitle().trim() + "' has been borrowed by " + username.trim() + " succesfully.");
        
        AllborrowedBooks[borrowedcount] = book;
        borrowedcount++;
        book.setCountcopies(book.getCountcopies() - 1);

        return;

    }

// function that return the borrowed book
    public void returnBook(Book book) {
        for (int i = 0; i < AllborrowedBooks.length; i++) {
            if (AllborrowedBooks[i] == book) {
                AllborrowedBooks[i] = null; // Remove the book from the user borrowd array
                return ;
            }
        }
        System.out.println("Sorry book not found in borrowed books");
        return ; // Book not found in borrowed books
    }

    // Here Getters functions :
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Book[] getAllborrowedBooks() {
        return AllborrowedBooks;
    }

    public int getBorrowedcount() {
        return borrowedcount;
    }

}
