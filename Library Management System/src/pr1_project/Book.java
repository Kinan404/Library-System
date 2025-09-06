
package pr1_project;

/**
 *
 * @author Administrator
 */
public class Book {

    private String Title;
    private String Author;
    public int Countcopies;
    private int Totalcopies;

    // Constructor
    public Book(String t, String a, int ct, int tc) {
        Title = t;
        Author = a;
        Countcopies = ct;
        Totalcopies = tc;
        
    }
      

    // function for writing the details of the book
    public String writedetails() {
        String result = Title.trim() + ", " + Author.trim() + ", " + Countcopies + " copies available.";
        return result;
    }

    // updating the number of copies if we want to increase or decrease the number of copies
    public void updatecount(int newnumber) {
        // check that the entered number is valid, Like not nagative for example.
        if (newnumber < 0) {
            System.out.println("Please try again with valid number!");
            return;
        }
        this.Countcopies += newnumber;
        this.Totalcopies += newnumber;

    }
    // Getters and setters functions :
    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public int getCountcopies() {
        return Countcopies;
    }

    public void setCountcopies(int number) {
        this.Countcopies = number;
    }

    public int getTotalcopies() {
        return Totalcopies;
    }

}
