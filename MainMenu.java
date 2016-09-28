// MainMenu

import java.util.Scanner;
import java.lang.String;

// main menu should be root and everything should be called from here
// including PasswordGenerator that way I can generate many passwords. without exiting or gen a pass then change the settings and gen a new one.

public class MainMenu{
  public static void main(String[] args){
    int[] answers =  new int[3];
    int totalLength = 0;
    int containWordNum = 0;
    int containSpecialNum = 0;
    Boolean containWord;
    Boolean containSpecial;

    Scanner reader = new Scanner(System.in); // Reading from System.in

    System.out.println("1 - Create a Password");
    System.out.println("2 - Settings");
    System.out.println("3 - Exit");
    int option = reader.nextInt();

    if (option == 1){
      System.out.println("How long would you like your password? (enter a number above 10)");
      totalLength = reader.nextInt();

      System.out.println("Would you like your password to contain words?\n1 - Yes\n0 - No");
      containWordNum = reader.nextInt();

      System.out.println("Would you like your password to contain special characters?\n1 - Yes\n0 - No");
      containSpecialNum = reader.nextInt();

      // Convert responses into Booleans
      if (containWordNum == 1){
        containWord = true;
      } else {
        containWord = false;
      }
      if (containSpecialNum == 1){
        containSpecial = true;
      } else {
        containSpecial = false;
      }
      PasswordGenerator.main(totalLength, containWord, containSpecial);

    } else if (option == 2){
      // call settings
      SettingsMenu.main();

    } else if (option == 3){
      System.out.println("Exiting");
      System.exit(0);

    } else {
      System.out.println("That is not a valid response please enter a number between 1 -3\n");
      main(null); // start over if response is invalid
    }
    main(null); // start over when a password is made
  }
}
