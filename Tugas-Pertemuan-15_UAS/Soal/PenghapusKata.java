import java.util.ArrayList;

public class PenghapusKata {

  public static void main(String[] args) {

    String kalimat = "Saya sedang belajar struktur data";

    System.out.println(hapus(kalimat, "sedang", 2));

  }

  public static String hapus(String sentence, String kataSisipan, int posisi) {

    ArrayList<String> kumpulanKata = new ArrayList<String>();

    String kata = "";
    for (int i = 0; i < sentence.length(); i++) {
      kata += sentence.charAt(i);
      if (sentence.charAt(i) == ' ') {
        kumpulanKata.add(kata);
        kata = "";
      }
    }

    kumpulanKata.remove(posisi + 1);
    System.out.println(kumpulanKata);

    String kalimatFinal = "";

    for (String s : kumpulanKata)
    {
        kalimatFinal += s;
    }

    return kalimatFinal;


  }


}
