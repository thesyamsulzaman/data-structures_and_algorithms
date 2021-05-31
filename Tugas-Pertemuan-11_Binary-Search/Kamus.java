public class Kamus {
  public String[] languageInput;
  public String[] languageLib;

  Kamus(String[][] languages) {
    this.languageInput = languages[0];
    this.languageLib = languages[1];
  }

  public static void main(String[] args) {

    String[] english = {
      "apple", "book", "captain", "lamb",
      "cat", "finger", "calf", "sole"
    };

    String[] indonesia = {
      "apel", "buku", "kapten", "domba",
      "kucing", "jari", "betis", "telapak kaki"
    };

    String[][] ENG_TO_IND = { english, indonesia };
    String[][] IND_TO_ENG = { indonesia, english };

    // Nama Parameter bisa diatur
    Kamus kamus = new Kamus(IND_TO_ENG);

    kamus.translate("telapak kaki");


  }

  public void translate(String word) {
    try {
      int baseWordIndex = findIndexOfWord(word);
      String translatedWord = findTranslation(baseWordIndex);

      if ( word == "") {
        throw new WordException("Parameter Kosong");
      }
      
      if ( baseWordIndex == -1) {
        throw new WordException(word + " Tidak ditemukan di kamus");
      }

      if ( translatedWord == "" ) {
        throw new WordException(word + " Tidak bisa diterjemahkan");
      }

      System.out.println(word + " artinya " + translatedWord);

    } catch(WordException exception) {
      System.out.println(exception.getMessage());
    }

  }

  public int findIndexOfWord(String word) {
    int hasil = -1;
    for (int i = 0; i < languageInput.length; i++) {
      if (languageInput[i].contains(word.toLowerCase())) {
        hasil = i;
        return hasil;
      }
    }

    return hasil;

  }

  public String findTranslation(int indexOfWord) {
    int awal = 0;
    int akhir = languageLib.length;
    String ditemukan = "";

    try {
      while (awal <= akhir) {
        int tengah = (awal + akhir) / 2;
        int pointer = tengah;

        if ( indexOfWord > pointer ) {
          awal = tengah + 1;
        }

        if ( indexOfWord < pointer ) {
          akhir = tengah - 1;
        }

        if ( indexOfWord == pointer ) {
          return languageLib[pointer];
        }

      }
      return ditemukan;
    } 

    catch (ArrayIndexOutOfBoundsException exception) {
      return ditemukan;
    }

  }

}


class WordException extends Throwable {

  private String message;

  public WordException(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
