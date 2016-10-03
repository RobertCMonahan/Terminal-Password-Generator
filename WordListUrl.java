// WordListUrl

import java.lang.Object;
import java.util.Scanner;
import org.apache.commons.validator.routines.UrlValidator;
// on using .jar files
// https://stackoverflow.com/questions/460364/how-to-use-classes-from-jar-files
// more on jar files and classpaths
// https://javarevisited.blogspot.com/2011/01/how-classpath-work-in-java.html
// compile with
// $ javac -cp '.:commons-validator-1.5.1.jar' WordListUrl.java


public class WordListUrl {
public static String url = "https://raw.githubusercontent.com/docdis/english-words/master/words2.txt";
public static void main(){

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a URL for the word list you would like to use, or 0 to return the previous menu");
        String userInputUrl = reader.next();
        try {
                if (Integer.parseInt(userInputUrl) == 0) {
                        SettingsMenu.main();
                }
        } catch (NumberFormatException nfe) {
                // do nothing, this should excute as long as the response isn't an int
        }

        UrlValidator urlValidator = new UrlValidator();
        if (urlValidator.isValid(userInputUrl)) { // validate url
                System.out.println("Enter a file name for the word list");
                String userInput = reader.next();
                WordListPath.filePath = userInput;
                FetchPage.main(userInputUrl, WordListPath.filePath, false);
                System.out.println("Your url has been turned into a word list " + WordListPath.filePath);
                MainMenu.main(null);
        } else {
                System.out.println("invalid url");
                main();
        }
}
}
