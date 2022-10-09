// Name: Chenxin Zhao
// Fall 2022
import java.util.ArrayList;
public class TestAssert {
    public static void main(String[] args){
        // correct testcase
        ArrayList<Integer> test1 = new ArrayList<Integer>();
        test1.add(1);
        test1.add(2);

        //incorrect testcase (<0)
        ArrayList<Integer> test2 = new ArrayList<Integer>();
        test2.add(-1);


        Bookshelf book1 = new Bookshelf(test1);
        Bookshelf book2 = new Bookshelf(test2);
    }

}