// WordListPath

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WordListPath {
public static String filePath = "words.txt";
public static void main(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a path for the word list you would like to use, or 0 to return the previous menu");
        String userInput = reader.next();
        try {
                if (Integer.parseInt(userInput) == 0) {
                        SettingsMenu.main();
                }
        } catch (NumberFormatException nfe) {
                // do nothing, this should excute as long as the response isn't an int
        }

        if (validatePath(userInput)) { // validate the users path
                filePath = userInput;
        } else {
                System.out.println("the file does not exist or read access is denied.");
                main();
        }
        //"/home/topaz/programing/java/password_gen/words.txt"

}
public static boolean validatePath(String p) {
        try {
                Path path = Paths.get(p);
                try{
                        return Files.isReadable(path);
                } catch (SecurityException se) {
                        System.out.println("Security Exception, path is not valid");
                        return false;
                }
        } catch (InvalidPathException ipe) {
                System.out.println("path contains invalid characters");
                return false;
        }


}
}
