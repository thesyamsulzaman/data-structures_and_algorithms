import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Hill {
  public static int MODULO_OPERATOR = 27;

  public static int[][] ENCRYPTION_KEY = {
    {3, 2},
    {7, 5}
  };

  public static int[][] DECRYPTION_KEY = {
    { ENCRYPTION_KEY[1][1], -(ENCRYPTION_KEY[0][1]) + MODULO_OPERATOR },
    { -(ENCRYPTION_KEY[1][0]) + MODULO_OPERATOR, ENCRYPTION_KEY[0][0] }
  };

  public static String[] LETTER_TABLE = { 
    "a", "b", "c", "d", "e", "f", "g",
    "h", "i", "j", "k", "l", "m", "n",
    "o", "p", "q", "r", "s", "t", "u",
    "v", "w", "x", "y", "z", " "
  };

  public static int[] NUMERIC_TABLE = {
    0, 1, 2, 3, 4, 5, 6, 7, 8, 
    9, 10, 11, 12, 13, 14, 15, 
    16, 17, 18, 19, 20, 21, 22, 
    23, 24, 25, 26
  };


  public static void main(String[] args) {

    // No. 1
    int[] A = { 5, 9 };

    int[][] B = {
      { 5, 4 },
      { 5, 5 }
    };

    int[] C = {
       ( (A[0] * B[0][0]) + (A[1] * B[1][0]) ), 
       ( (A[0] * B[0][1]) + (A[1] * B[1][1]) )
    };

    //System.out.println(Arrays.toString(C));

    // No. 2
    int DETERMINANT_OF_B = ( (B[0][0] * B[1][1]) - (B[0][1] * B[1][0]) );

    float[][] INVERSE_OF_B = {
      { 
        (float) 1 *  (B[0][0]) / DETERMINANT_OF_B, 
        (float) 1 * -(B[0][1]) / DETERMINANT_OF_B 
      },
      { 
        (float) 1 * -(B[1][0]) / DETERMINANT_OF_B, 
        (float) 1 *  (B[1][1]) / DETERMINANT_OF_B
      }
    };

    // No. 3
    String encryptedName = encrypt("JULY");
    //System.out.println(encryptedName);
    String decryptedCode = decrypt("FKMH");
    //System.out.println(decryptedCode);

  }


  public static String decrypt(String rawCode) {

    String code = rawCode.toLowerCase();
    String finalResult = "";

    int lengthOfCodeChar = code.length();
    List<Character> partialCode; 

    int[] lettersInNumeric;
    ArrayList<Character> letters = new ArrayList<>();

    for ( int i = 0; i < lengthOfCodeChar; i++ ) {
      letters.add(code.charAt(i));
    }

    for (int i = 0; i <= letters.size(); i++ ) {
      if ( i != 0 && i % 2 == 0 ) {
        partialCode = letters.subList(i - 2, i);
        lettersInNumeric = findNumericByPartial(partialCode);
        finalResult += decryptCode(lettersInNumeric);
      }
    }


    return finalResult;
  }

  public static String encrypt(String name) {
    String fullName = name.toLowerCase();
    String finalResult = "";

    int lengthOfName = fullName.length();
    List<Character> partialName; 

    int[] lettersInNumeric;
    ArrayList<Character> letters = new ArrayList<>();

    for ( int i = 0; i <= lengthOfName; i++ ) {
      if (i == lengthOfName && isOdd(lengthOfName)) {
        letters.add(' ');
      } else if (i < lengthOfName) {
        letters.add(fullName.charAt(i));
      }
    }

    for (int i = 0; i <= letters.size(); i++ ) {
      if ( i != 0 && i % 2 == 0 ) {
        partialName = letters.subList(i - 2, i);
        lettersInNumeric = findNumericByPartial(partialName);
        finalResult += convertToLetter(lettersInNumeric);
      }
    }

    return finalResult;
  }


  public static String decryptCode(int[] numericArr) {
    int numOne = (
        (numericArr[0] * DECRYPTION_KEY[0][0]) + 
        (numericArr[1] * DECRYPTION_KEY[1][0]) 
    ) % MODULO_OPERATOR;

    int numTwo = ( 
        (numericArr[0] * DECRYPTION_KEY[0][1]) + 
        (numericArr[1] * DECRYPTION_KEY[1][1]) 
    ) % MODULO_OPERATOR;

    return findLetterOfNumeric(numOne) + "" + findLetterOfNumeric(numTwo);
  }

  public static String convertToLetter(int[] numericArr) {
    int numOne = ( (numericArr[0] * ENCRYPTION_KEY[0][0]) + (numericArr[1] * ENCRYPTION_KEY[1][0]) );
    int numTwo = ( (numericArr[0] * ENCRYPTION_KEY[0][1]) + (numericArr[1] * ENCRYPTION_KEY[1][1]) );

    return findLetterOfNumeric(numOne) + "" + findLetterOfNumeric(numTwo);
  }

  public static int[] findNumericByPartial(List<Character> partial) {
    int[] arrayOfNumber = new int[2];

    for (int i = 0; i < partial.size(); i++ ) {
      arrayOfNumber[i] = findNumericOfLetter(partial.get(i));
    }

    return arrayOfNumber;
  }

  public static String findLetterOfNumeric(int numericCode) {
    String letter = "";

    int parsedNumeric = numericCode % MODULO_OPERATOR;

    for (int i = 0; i < NUMERIC_TABLE.length; i++) {
      if (parsedNumeric == NUMERIC_TABLE[i]) {
        letter = LETTER_TABLE[parsedNumeric];
      }
    }

    return letter;
  }

  public static int findNumericOfLetter(Character letter) {
    String stringLetter = Character.toString(letter);
    int numericCode = -1;

    for (int i = 0; i < LETTER_TABLE.length; i++) {
      if (stringLetter.equals(LETTER_TABLE[i])) {
        numericCode = NUMERIC_TABLE[i];
      }
    }
    return numericCode;
  }

  public static boolean isOdd(int number) {
    if ( number % 2 != 0 && number != 0 ) {
      return true;
    }
    return false;
  }
}
