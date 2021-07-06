package services;

import java.io.FileReader;
import java.io.FileWriter;

import java.util.List;
import java.util.ArrayList;

public class Encryptor {

  public static String charLib = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~!@#$%^&*()_-+={}[]|:;’<>,.?/ ";
  public static String[] LETTER_TABLE = charLib.split("");
  public static int MODULO_OPERATOR = charLib.length();

  // TODO Buat ini dinamik
  public static int[][] ENCRYPTION_KEY = {
    {3, 2},
    {7, 5}
  };

  public static int[][] DECRYPTION_KEY = {
    { ENCRYPTION_KEY[1][1], -(ENCRYPTION_KEY[0][1]) + MODULO_OPERATOR },
    { -(ENCRYPTION_KEY[1][0]) + MODULO_OPERATOR, ENCRYPTION_KEY[0][0] }
  };


  // ------------
  // Main Methods
  // ------------

  public static String encrypt(String contentInput) {
    String content = contentInput;

    String finalResult = "";
    int lengthOfContent = content.length();
    int[] lettersInNumeric;

    List<Character> partialContent; 
    ArrayList<Character> letters = new ArrayList<>();

    for ( int i = 0; i <= lengthOfContent; i++ ) {
      if (i == lengthOfContent && isOdd(lengthOfContent)) {
        letters.add(' ');
      } else if (i < lengthOfContent) {
        letters.add(content.charAt(i));
      }
    }

    for (int i = 0; i <= letters.size(); i++ ) {
      if ( i != 0 && i % 2 == 0 ) {
        partialContent = letters.subList(i - 2, i);
        lettersInNumeric = findNumericByPartial(partialContent);
        finalResult += convertToLetter(lettersInNumeric, "encrypt");
      }
    }

    return finalResult;
  } 


  public static String decrypt(String contentInput) {
    String content = contentInput;
    String finalResult = "";

    int lengthOfContent = content.length();
    List<Character> partialContent; 

    int[] lettersInNumeric;
    ArrayList<Character> letters = new ArrayList<>();

    for ( int i = 0; i < lengthOfContent; i++ ) {
      letters.add(content.charAt(i));
    }

    for (int i = 0; i <= letters.size(); i++ ) {
      if ( i != 0 && i % 2 == 0 ) {
        partialContent = letters.subList(i - 2, i);
        lettersInNumeric = findNumericByPartial(partialContent);
        finalResult += convertToLetter(lettersInNumeric, "decrypt");
      }
    }

    return finalResult;
  }


  // --------------------------------------------
  // WARNING: Private Methods, dont ever touch it
  // --------------------------------------------
 
  public static int[] findNumericByPartial(List<Character> partial) {
    int[] arrayOfNumber = new int[2];

    for (int i = 0; i < partial.size(); i++ ) {
      arrayOfNumber[i] = findNumericOfLetter(partial.get(i));
    }

    return arrayOfNumber;
  }


  public static int findNumericOfLetter(Character letter) {
    String stringLetter = Character.toString(letter);
    int numericCode = -1;

    for (int i = 0; i < LETTER_TABLE.length; i++) {
      if (stringLetter.equals(LETTER_TABLE[i])) {
        numericCode = i;
      }
    }
    return numericCode;
  }


  public static String findLetterOfNumeric(int numericCode) {
    String letter = "";
    int dividedNumeric = numericCode % MODULO_OPERATOR;

    for (int i = 0; i < LETTER_TABLE.length; i++) {
      if (dividedNumeric == i) {
        letter = LETTER_TABLE[dividedNumeric];
      }
    }

    return letter;
  }


  // ----------------
  // Matrix Operation
  // ----------------
  
  public static String convertToLetter(int[] numericArr, String processKey) {
    int numOne = 0, 
        numTwo = 0;

    switch(processKey) {
      case "encrypt":
        numOne = (
          (numericArr[0] * ENCRYPTION_KEY[0][0]) + 
          (numericArr[1] * ENCRYPTION_KEY[1][0])
        );
        numTwo = ( 
          (numericArr[0] * ENCRYPTION_KEY[0][1]) + 
          (numericArr[1] * ENCRYPTION_KEY[1][1]) 
        );
        break;
      case "decrypt":
        numOne = (
          (numericArr[0] * DECRYPTION_KEY[0][0]) + 
          (numericArr[1] * DECRYPTION_KEY[1][0]) 
        ) % MODULO_OPERATOR;

        numTwo = ( 
          (numericArr[0] * DECRYPTION_KEY[0][1]) + 
          (numericArr[1] * DECRYPTION_KEY[1][1]) 
        ) % MODULO_OPERATOR;
        break;
    }

    return findLetterOfNumeric(numOne) + findLetterOfNumeric(numTwo);
  }


  // -------
  // Helpers
  // -------
  
  public static boolean isOdd(int number) {
    if ( number % 2 != 0 && number != 0 ) {
      return true;
    }
    return false;
  }


}
