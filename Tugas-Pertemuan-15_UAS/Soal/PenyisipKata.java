import java.util.ArrayList;

public class PenyisipKata {

  public static void main(String[] args) {


    String kalimat = "Saya sedang belajar struktur data";

    System.out.println(sisip(kalimat, "pergi", 2));

  }

  public static String sisip(String sentence, String kataSisipan, int posisi) {

    ArrayList<String> kumpulanKata = new ArrayList<String>();

    String kata = "";
    for (int i = 0; i < sentence.length(); i++) {
      kata += sentence.charAt(i);
      if (sentence.charAt(i) == ' ') {
        kumpulanKata.add(kata);
        kata = "";
      }
    }

    kumpulanKata.add(posisi, kataSisipan + " ");

    String kalimatFinal = "";

    for (String s : kumpulanKata)
    {
        kalimatFinal += s;
    }

    return kalimatFinal;


  }


}
