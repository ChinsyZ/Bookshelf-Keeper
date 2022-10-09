// Name: Chenxin Zhao
// Fall 2022

/**
 * Class BookshelfKeeper
 *
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in
 * non-decreasing order by height, with the restriction that single books can only be added
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 */

public class BookshelfKeeper {

   /**
    Representation invariant:

    -- BookshelfKeeper keeps all books on bookshelf in non-decreasing order
    -- Books are all positive integers

    */

   // <add instance variables here>
   private Bookshelf book;
   private int totalOperation;
   private int curOperation;


   /**
    * Creates a BookShelfKeeper object with an empty bookshelf
    */
   public BookshelfKeeper() {
      book = new Bookshelf();
      totalOperation = 0;
      curOperation = 0;
      assert isValidBookshelfKeeper();

   }

   /**
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: method does not make a defensive copy of the bookshelf.
    *
    * PRE: sortedBookshelf.isSorted() is true.
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {
      book = sortedBookshelf;
      totalOperation = 0;
      curOperation = 0;
      assert isValidBookshelfKeeper();
   }

   /**
    * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted
    * after picking up the book.
    *
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    *
    * PRE: 0 <= position < getNumBooks()
    */
   public int pickPos(int position) {
      Bookshelf store = new Bookshelf();
      int val;
      curOperation = 0;
      // from left
      if ((book.size()- position) > position){
         for (int i = 0; i < position; i++){
            store.addLast(book.removeFront());
            curOperation++;
         }
         val = book.removeFront();
         curOperation++;
         for (int i = 0; i < store.size();i++){
            book.addFront(store.removeLast());
            curOperation++;
         }
      }else{ // from right
         for(int i = book.size()-1; i > position; i--){
            store.addFront(book.removeLast());
            curOperation++;
         }
         val = book.removeLast();
         curOperation++;
         int sz = store.size();
         for(int i = 0; i < sz; i++){
            book.addLast(store.removeFront());
            curOperation++;
         }
      }
      totalOperation += curOperation;
      assert isValidBookshelfKeeper();
      return curOperation;
   }

   /**
    * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted
    * after the insertion.
    *
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    *
    * PRE: height > 0
    */
   public int putHeight(int height) {
      curOperation = 0;

      int position = findPos(height);
      Bookshelf store = new Bookshelf();
      // from left
      if ((book.size()- position) > position){
         for (int i = 0; i < position; i++){
            store.addLast(book.removeFront());
            curOperation++;
         }
         book.addFront(height);
         curOperation++;
         for (int i = 0; i < store.size();i++){
            book.addFront(store.removeLast());
            curOperation++;
         }
      }else{ // from right
         for(int i = book.size()-1; i >= position; i--){
            store.addFront(book.removeLast());
            curOperation++;
         }
         book.addLast(height);
         curOperation++;
         // put last has some problem
         int sz = store.size();
         for(int i = 0; i <sz;i++){
            int val = store.removeFront();
            book.addLast(val);
            curOperation++;
         }
      }
      totalOperation += curOperation;
      assert isValidBookshelfKeeper();
      return curOperation;   // dummy code to get stub to compile
   }


   /**
    * Returns the total number of calls made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    */
   public int getTotalOperations() {
      assert isValidBookshelfKeeper();
      return totalOperation;   // dummy code to get stub to compile
   }

   /**
    * Returns the number of books on the contained bookshelf.
    */
   public int getNumBooks() {
      assert isValidBookshelfKeeper();
      return book.size();   // dummy code to get stub to compile
   }

   /**
    * Returns string representation of this BookshelfKeeper. Returns a String containing height
    * of all books present in the bookshelf in the order they are on the bookshelf, followed
    * by the number of bookshelf mutator calls made to perform the last pick or put operation,
    * followed by the total number of such calls made since we created this BookshelfKeeper.
    *
    * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
    *
    */
   public String toString() {
      assert isValidBookshelfKeeper();
      return book.toString() + " " + curOperation+ " " + totalOperation;   // dummy code to get stub to compile

   }

   /**
    * Returns true iff the BookshelfKeeper data is in a valid state.
    * (See representation invariant comment for details.)
    */
   private boolean isValidBookshelfKeeper() {
      for(int i = 0; i < book.size(); i++){
         if(book.getHeight(i) <= 0 || book.getHeight(i) != (int)book.getHeight(i) || !book.isSorted())
            return false;
      }
      return true;

   }

   // add any other private methods here

   // putHeight helper function. Find the position height should be put in
   public int findPos(int height){
      int sz = book.size();
      int pos = 0;
      int left = 0;
      int right = 0;
      boolean sameHeight = false;

      for (int i = 0; i < sz; i++){
         // exist same height
         if(height == book.getHeight(i)){
            pos = left = i;
            sameHeight = true;
            while (book.getHeight(pos)== height){
               pos++;
            }
            right = sz-pos;
            if(left < right){
               return left;
            }else{
               return pos;
            }
         }
         // no same height
         if(!sameHeight){
            if(book.getHeight(i) < height){
               pos++;
            }else{
               return pos;
            }
         }
      }
      return pos;
   }

}
