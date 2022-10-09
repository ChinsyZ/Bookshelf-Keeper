// Name: Chenxin Zhao
// Fall 2022
import java.util.ArrayList;
public class BookshelfTester {
    public static void main(String[] args){
        // Bookshelf constructor No.1
        Bookshelf book1 = new Bookshelf();

        // Test bookshelf constructor No.1
        System.out.println("Test bookshelf constructor No.1:");
        System.out.println("Expected: []");
        System.out.println("Actual: " + book1);

        // No.2
        ArrayList<Integer> pileOfBooks = new ArrayList<Integer>();
        pileOfBooks.add(1);
        pileOfBooks.add(3);
        pileOfBooks.add(4);
        pileOfBooks.add(8);

        Bookshelf book2 = new Bookshelf(pileOfBooks);

        // Test bookshelf constructor No.2
        System.out.println("Test bookshelf constructor No.2:");
        System.out.println("Expected: [1, 3, 4, 8]");
        System.out.println("Actual: " + book2);
        System.out.println();

        // toString method
        String bs1 = book1.toString();
        String bs2 = book2.toString();

        // Test toString method
        System.out.println("Test toString method:");
        System.out.println("Expected 1st: []");
        System.out.println("Actual 1st: " + bs1);
        System.out.println("Expected 2nd: [1, 3, 4, 8]");
        System.out.println("Actual 2nd: " + bs2);
        System.out.println();

        // addFront method
        book1.addFront(2);
        book2.addFront(2);

        // Test addFront method
        System.out.println("Test addFront method:");
        System.out.println("Expected 1st: [2]");
        System.out.println("Actual 1st: " + book1);
        System.out.println("Expected: [2, 1, 3, 4, 8]");
        System.out.println("Actual: " + book2);
        System.out.println();

        // addLast method
        book1.addLast(10);
        book2.addLast(10);

        // Test addLast method
        System.out.println("Test addLast method:");
        System.out.println("Expected 1st: [2, 10]");
        System.out.println("Actual 1st: " + book1);
        System.out.println("Expected: [2, 1, 3, 4, 8, 10]");
        System.out.println("Actual: " + book2);
        System.out.println();

        // removeFront method
        book1.removeFront();
        book2.removeFront();

        // Test removeFront method
        System.out.println("Test removeFront method:");
        System.out.println("Expected 1st: [10]");
        System.out.println("Actual 1st: " + book1);
        System.out.println("Expected: [1, 3, 4, 8, 10]");
        System.out.println("Actual: " + book2);
        System.out.println();

        // removeLast method
        book1.removeLast();
        book2.removeLast();

        // Test removeLast method
        System.out.println("Test removeLast method:");
        System.out.println("Expected 1st: []");
        System.out.println("Actual 1st: " + book1);
        System.out.println("Expected: [1, 3, 4, 8]");
        System.out.println("Actual: " + book2);
        System.out.println();

        // getHeight method
        int height = book2.getHeight(1);

        // Test getHeight method
        System.out.println("Test getHeight method:");
        System.out.println("Origin: [1, 3, 4, 8], getHeight(1)");
        System.out.println("Expected: 3");
        System.out.println("Actual: " + height);
        System.out.println();

        // size
        int sz = book2.size();
        // Test size method
        System.out.println("Test size method:");
        System.out.println("Expected: 4");
        System.out.println("Actual: " + sz);
        System.out.println();

        // isSorted method
        book1.addFront(3);
        book1.addFront(10);
        // Test size method
        System.out.println("Test isSorted method:");
        System.out.println("Expected 1st: Origin: [10,3], false");
        System.out.println("Actual 1st: Origin: " + book1 + ", " + book1.isSorted());
        System.out.println("Expected 2nd: Origin: [1, 3, 4, 8], true");
        System.out.println("Actual 2nd: " + book2 + ", " + book2.isSorted());
        System.out.println();
    }

}