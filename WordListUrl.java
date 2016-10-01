// WordListUrl

import java.util.Scanner;
public class WordListUrl {
public static void main(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a path for the word list you would like to use");
        String path = reader.next();


        // ask for a url and check for a valid url
        // ask for a file name (check if .txt is added and if no add .txt)
        // build up word list
        FetchPage.main(new String("https://raw.githubusercontent.com/docdis/english-words/master/words2.txt"), new String("words.txt"), false);
        main();

}
}
