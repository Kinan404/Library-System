/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr1_project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private User user;              // The user 
    private Book book;              // The book 
    private String transactionType; // "Borrow" or "Return"
    private String transactionDate; // The date of the transaction

    // Constructor
    public Transaction(User u, Book b, String ttype) {
        this.user = u;
        this.book = b;
        this.transactionType = ttype;
        this.transactionDate = getNowTime(); // 
    }
    // function for writing the date in formal style :
    private String getNowTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(new Date());
    }
    // function that prapre every transcation as string and return it :
    public String getTransactionDetails() {
        String result = transactionType + " Transaction: "
                + user.getName().trim() + " (" + user.getEmail().trim() + ") "
                + transactionType.toLowerCase() + "'" + book.getTitle().trim() + "' by " + book.getAuthor().trim()
                + " on " + transactionDate + ".";

        return result;
    }

}
