import java.util.ArrayList;

public class PenghitungVokalKonsonan {


  public static void main(String[] args) {
    String sentence = "Universitas Nusa Putra Sukabumi";

    hitungVokalKonsonan(sentence);
  }


  public static void hitungVokalKonsonan(String sentence) {
    int consonantCount = 0,
        vocalCount = 0;

    ArrayList<Character> trimmedSentence = new ArrayList<Character>();

    for ( int i = 0; i < sentence.length(); i++) {
      if (!Character.isWhitespace(sentence.charAt(i))) {
        trimmedSentence.add(sentence.charAt(i));
      }
    }

    for ( int i = 0; i < trimmedSentence.size(); i++ ) {
      if (
          Character.toLowerCase(trimmedSentence.get(i)) == 'a' ||
          Character.toLowerCase(trimmedSentence.get(i)) == 'i' ||
          Character.toLowerCase(trimmedSentence.get(i)) == 'u' ||
          Character.toLowerCase(trimmedSentence.get(i)) == 'e' ||
          Character.toLowerCase(trimmedSentence.get(i)) == 'o' 
        ) {
        consonantCount += 1;
      } else  {
        vocalCount += 1;
      }
    }

    System.out.println("Kalimat -> " + sentence);
    System.out.println("Ada " + consonantCount + " Huruf Konsonan");
    System.out.println("Ada " + vocalCount + " Huruf Vokal");

  }


}



