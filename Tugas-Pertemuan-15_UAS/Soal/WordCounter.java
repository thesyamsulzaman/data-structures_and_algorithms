public class WordCounter {
  public static void main(String[] args) {
    String sentence = "what do you lose when life already the worst";

    String[] words = sentence.split(" ");

    int wordCount = 0;

    for ( String word: words ) {
      wordCount += 1;
    }

    System.out.println(wordCount);

  }
}
