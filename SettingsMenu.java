// SettingsMenu

import java.util.Scanner;

public class SettingsMenu {
public static void main(){
        Scanner reader = new Scanner(System.in);
        System.out.println("-- Settings --");
        System.out.println("0 - Back to main menu");
        System.out.println("1 - Add system path for word list file");
        System.out.println("2 - Display path for the current word list");
        System.out.println("3 - Add url for word list");
        int option = reader.nextInt();

        if (option == 0) {
                MainMenu.main(null);
        } else if (option == 1) {
                WordListPath.main();
        } else if (option == 2) {
                System.out.println(WordListPath.filePath);
        } else if (option == 3) {
                WordListUrl.main();
        } else {
                // Call settings menu again if option wasnt choosen
                System.out.println("That is not a valid response please enter a number between 0 - 2\n");
                main();
        }
}
}
