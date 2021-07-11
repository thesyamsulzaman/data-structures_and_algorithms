public class LetterDetector {
  public static void main(String[] args) {

    int consonantCount = 0,
        vocalCount = 0;

    String sentence = "abdi teh bogoh ka salira";

    String[] sentenceToArray = sentence.replaceAll("\\s+", "").split("");

    for (int i = 0; i < sentenceToArray.length; i++) {
      if (
          sentenceToArray[i].toLowerCase().equals("a") ||
          sentenceToArray[i].toLowerCase().equals("i") ||
          sentenceToArray[i].toLowerCase().equals("u") ||
          sentenceToArray[i].toLowerCase().equals("e") ||
          sentenceToArray[i].toLowerCase().equals("o") 
        ) {
        consonantCount += 1;
      } else  {
        vocalCount += 1;
      }
    }

    System.out.println("Kalimat -> " + sentence);
    System.out.println("Ada " + consonantCount + " Huruf Konsonan");
    System.out.println("Ada " + vocalCount + " Huruf Vocal");
  }
}
