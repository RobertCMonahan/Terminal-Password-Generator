// SettingsMenu

import java.util.Scanner;

public class SettingsMenu{
  public static void main(){
    Scanner reader = new Scanner(System.in);
    System.out.println("Settings");
    System.out.println("0 - Back to main menu");
    System.out.println("1 - Add system path for word list file");
    System.out.println("2 - Add url for word list");
    int option = reader.nextInt();
    if (option == 0){
      MainMenu.main(null);
    } else if (option == 1){
      // ask for path and check that it is a valid path
      // change the path to the file in the random word chooser method
    } else if (option == 2){
      // ask for a url and check for a valid url
      // ask for a file name (check if .txt is added and if no add .txt)
      // build up word list
      FetchPage.main(new String("https://raw.githubusercontent.com/docdis/english-words/master/words2.txt"), new String("words.txt"), false);
      main();
    } else {
      // Call settings menu again if option wasnt choosen
      System.out.println("That is not a valid response please enter a number between 0 - 2\n");
      main();
    }
  }
}
