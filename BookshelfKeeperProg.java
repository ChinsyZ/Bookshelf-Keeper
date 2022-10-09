// Name: Chenxin Zhao
// Fall 2022
import java.util.Scanner;
import java.util.ArrayList;

public class BookshelfKeeperProg{
    public static void main(String[] args){
        System.out.println("Please enter initial arrangement of books followed by newline:");
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> userInput = input(in.nextLine());

        // check if there are any non-positive integers
        if(!isPositive(userInput)){
            System.out.println("ERROR: Height of a book must be positive.");
            System.out.println("Exiting Program.");
            return;
        }

        Bookshelf bookshelf = new Bookshelf(userInput);

        // check if the input is sorted:
        if (!bookshelf.isSorted()){
            System.out.println("ERROR: Heights must be specified in non-decreasing order.");
            System.out.println("Exiting Program.");
            return;
        }


        BookshelfKeeper keeper = new BookshelfKeeper(bookshelf);
        System.out.println(keeper.toString());
        System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
        while(true){
            String action = in.nextLine();
            Scanner act = new Scanner(action);
            String command = act.next();
            int idxOrHeight = 0;
            if (act.hasNextInt()){
                idxOrHeight = act.nextInt();
            }
            // check if input idx or height valid
            if(!isValid(command,idxOrHeight,keeper)){
                return;
            }
            if (command.trim().equals("end")){
                System.out.println("Exiting Program.");
                in.close();
                act.close();
                return;
            }
            if(command.trim().equals("pick")){
                keeper.pickPos(idxOrHeight);
            }else if (command.trim().equals("put")){
                keeper.putHeight(idxOrHeight);
            }
            System.out.println(keeper.toString());
        }

    }
    // input method. return ArrayList<Integer> user input
    public static ArrayList<Integer> input(String str){
        Scanner in = new Scanner(str);
        ArrayList<Integer> books = new ArrayList<Integer>();
        while(in.hasNextInt()){
            books.add(in.nextInt());
        }
        in.close();
        return books;
    }


    // Error check: return true if there are any non-positive integers
    public static boolean isPositive(ArrayList<Integer> book){
        for(int i = 0; i < book.size(); i ++){
            if (book.get(i) < 0){
                return false;
            }
        }
        return true;
    }

    // Error check: return true if command and index or height input is valid
    public static boolean isValid(String command, int indexOrHeight, BookshelfKeeper  keeper){
        if (!command.trim().equals("pick") && !command.trim().equals("put") && !command.trim().equals("end")){
            System.out.println("ERROR: Invalid command. Valid commands are pick, put, or end.");
            System.out.println("Exiting Program.");
            return false;
        }
        if(command.trim().equals("pick") && indexOrHeight >= keeper.getNumBooks()){
            System.out.println("ERROR: Entered pick operation is invalid on this shelf.");
            System.out.println("Exiting Program.");
            return false;
        }
        if(command.trim().equals("put") && indexOrHeight <= 0){
            System.out.println("ERROR: Height of a book must be positive.");
            System.out.println("Exiting Program.");
            return false;
        }
        return true;
    }

}