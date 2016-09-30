// MainMenu

import java.util.Scanner;
import java.lang.String;

// main menu should be root and everything should be called from here
// including PasswordGenerator that way I can generate many passwords. without exiting or gen a pass then change the settings and gen a new one.

public class MainMenu {
public static void main(String[] args){
        int[] answers =  new int[3];
        int totalLength = 0;
        int containWordNum = 0;
        int containSpecialNum = 0;
        Boolean containWord;
        Boolean containSpecial;
        Scanner reader = new Scanner(System.in); // Reading from System.in

        System.out.println("-- Main Menu --");
        System.out.println("1 - Create a Password");
        System.out.println("2 - Settings");
        System.out.println("3 - Exit");
        int option = reader.nextInt();

        if (option == 1) {
                PasswordGenerator.main();

        } else if (option == 2) {
                // call settings
                SettingsMenu.main();

        } else if (option == 3) {
                System.out.println("-- Exiting --");
                System.exit(0);

        } else {
                System.out.println("That is not a valid response please enter a number between 1 -3\n");
                main(null); // start over if response is invalid
        }
        main(null); // start over when a password is made
}
}
