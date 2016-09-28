// PasswordGenerator Main

import java.util.Arrays;
import java.util.Scanner;
import java.lang.System;
import java.util.Random;

import java.io.IOException ;
import java.net.MalformedURLException;
import java.io.FileNotFoundException;

public class PasswordGenerator{
  public static void main(int totalLength, Boolean containWord, Boolean containSpecial){
    String[] rndWords = new String[totalLength]; // Array to hold a some randomly choosen words

    int arrayPosition = 0; // arrayPosition tells the while loop when the array is full
    while (arrayPosition < totalLength){
      String word = RandomLineChooser.main(); // randomWordChooser can return a line or a null value
      if (word != null){
        rndWords[arrayPosition] = word; // if the word isn't null add it to the array
        arrayPosition += 1;
      }
    }
    //System.out.println(Arrays.toString(rndWords));

    // chars array
    char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    // numbers array
    String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    // specials array
    String[] specials = { "!", "@", "#", "$", "%",
                          "^", "&", "*", "(", ")",
                          "-", "_", "=", "+", "[",
                          "{", "]", "}", "|", "\\",
                          ":", ";", "'", ",", "<",
                          ".", ">", "?", "/", "`",
                          "~"};

    // Build password
    String password = "";
    Boolean caps;
    Boolean front;
    int next; // 0 = char, 1 = number, 2 = special, 3 = word
    while(password.length() < totalLength){
      caps = new Random().nextBoolean(); // randomize if the item will be capitalized (if possible)
      front = new Random().nextBoolean(); // randomize if the item will be added to the front or back
      next = Math.abs(new Random().nextInt(4)); //choose randomly what will be added next to the password
      switch (next){
        case 0: // add a char
                String character = String.valueOf(chars[Math.abs(new Random().nextInt(26))]);
                if (caps){ // make uppercase if caps is true
                  character = character.toUpperCase();
                }
                if (front){
                  password = character + password; // add the char to front of password
                } else{
                  password = password + character; // add the char to back of password
                }
                break;

        case 1: // add a number
                String num = numbers[Math.abs(new Random().nextInt(10))];
                if (front){
                  password = num + password;
                } else{
                  password = password + num;
                }
                break;

        case 2: // add a special
                if (containSpecial == false){
                  break;
                } else {
                  String spec = specials[Math.abs(new Random().nextInt(31))];
                  if (front){
                    password = spec + password;
                  } else {
                    password = password + spec;
                  }
                  break;
                }

        case 3: // add a word
                if (containWord == false){;
                  break;
                }
                for (int i = 0 ; i < 3 ; i++ ) { // give 3 shots at finding a suitable word
                  // choose a word at random
                  String nextWord = rndWords[Math.abs(new Random().nextInt(rndWords.length))];
                  // if the word is short enough
                  if (nextWord.length() < totalLength - password.length()){
                    if (caps){ // make uppercase if caps is true
                      nextWord = nextWord.toUpperCase();
                    }
                    if (front){
                      password = nextWord + password; // if it's not too long add it to the front of password
                      break;
                    } else {
                      password = password + nextWord; // if it's not too long add it to the back of password
                      break;
                    }
                  }
                }
                break;
        }
    }
    System.out.println("\nYour new password is:\n" + password + "\n");
  }
}
