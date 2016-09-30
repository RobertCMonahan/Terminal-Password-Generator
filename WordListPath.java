// WordListPath
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;
import java.lang.NullPointerException;

public class WordListPath {
public static String filePath = "words.txt";
public static void main(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a path for the word list you would like to use");
        String path = reader.next();
        if (validPath(path) == true) {
                filePath = path;
        } else {
                System.out.println(path + " is not a valid path.");
                main();
        }
        //"/home/topaz/programing/java/password_gen/words.txt"

}
public static boolean validPath(String path) { // checks for valid path
        try {
                Paths.get(path);
        }catch (InvalidPathException |  NullPointerException ex) {
                return false;
        }
        return true;
}
}
