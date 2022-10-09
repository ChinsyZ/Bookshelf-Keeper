// Name: Chenxin Zhao
// Fall 2022

/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
 */
import java.util.ArrayList;

public class Bookshelf {

   /**
    Representation invariant:
    -- height is [0, Integer.MAX_VALUE);
    -- height is Integer;
    */

   // <add instance variables here>
   private ArrayList<Integer> book;

   /**
    * Creates an empty Bookshelf object i.e. with no books
    */
   public Bookshelf() {
      book = new ArrayList<Integer>();
      assert isValidBookshelf();  // sample assert statement (you will be adding more of these calls)
   }

   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    *
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    */
   public Bookshelf(ArrayList<Integer> pileOfBooks) {
      book = new ArrayList<Integer>(pileOfBooks);
      assert isValidBookshelf();

   }

   /**
    * Inserts book with specified height at the start of the Bookshelf, i.e., it
    * will end up at position 0.
    *
    * PRE: height > 0 (height of book is always positive)
    */
   public void addFront(int height) {
      book.add(0,height);
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the end of the Bookshelf.
    *
    * PRE: height > 0 (height of book is always positive)
    */
   public void addLast(int height) {
      book.add(height);
      assert isValidBookshelf();
   }

   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book.
    *
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeFront() {
      int removedHeight = book.get(0);
      book.remove(0);
      assert isValidBookshelf();
      return removedHeight;   // dummy code to get stub to compile

   }

   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.
    *
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeLast() {
      int removedHeight = book.get(book.size()-1);
      book.remove(book.size()-1);
      assert isValidBookshelf();
      return removedHeight;
   }

   /*
    * Gets the height of the book at the given position.
    *
    * PRE: 0 <= position < this.size()
    */
   public int getHeight(int position) {
      assert isValidBookshelf();
      return book.get(position);

   }

   /**
    * Returns number of books on the this Bookshelf.
    */
   public int size() {
      assert isValidBookshelf();
      return book.size();   // dummy code to get stub to compile

   }

   /**
    * Returns string representation of this Bookshelf. Returns a string with the height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
    * by example here:  “[7, 33, 5, 4, 3]”
    */
   public String toString() {
      assert isValidBookshelf();
      return book.toString();   // dummy code to get stub to compile

   }

   /**
    * Returns true iff the books on this Bookshelf are in non-decreasing order.
    * (Note: this is an accessor; it does not change the bookshelf.)
    */
   public boolean isSorted() {
      // non-decreasing means that the previous height is always smaller than or equal to the current one
      for (int i = 1; i < book.size(); i++){
         // return false if the previous height is bigger than the current one
         if (book.get(i-1)>book.get(i)){
            return false;
         }
      }
      assert isValidBookshelf();
      return true;  // dummy code to get stub to compile
   }

   /**
    * Returns true iff the Bookshelf data is in a valid state.
    * (See representation invariant comment for more details.)
    */
   private boolean isValidBookshelf() {
      for(int i = 0; i < book.size(); i ++ ){
         if (book.get(i)<= 0 ||book.get(i) > Integer.MAX_VALUE ||book.get(i) != (int)book.get(i)){
            return false;
         }
      }
      return true;  // dummy code to get stub to compile

   }

}
