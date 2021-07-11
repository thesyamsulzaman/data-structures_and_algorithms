import java.util.*;
import java.lang.StringBuilder;

public class PenghitungKata {

  public static void main(String[] args) {
    String kalimatSatu = "Universitas Nusa Putra Sukabumi";
    String kalimatDua = "Pemrograman";
    String kalimatTiga = "Belajar pemrograman struktur data berbasis java";

    System.out.println("Jumlah kata : " + hitungkata(kalimatTiga));
  }

  public static int hitungkata(String sentence) {
    int jumlahKata = 0;
    ArrayList<String> kumpulanKata = new ArrayList<String>();

    String kata = "";
    for (int i = 0; i < sentence.length(); i++) {
      kata += sentence.charAt(i);
      // Disini gk tau kenapa kata terakhirnya kepotong
      if (Character.isWhitespace(sentence.charAt(i)) || i == sentence.length()) {
        kumpulanKata.add(kata.trim());
        kata = "";
      }
    }

    for (int i = 0; i < kumpulanKata.size(); i++) {
      if (!(getVocalCount(kumpulanKata.get(i)) > 1)) {
        jumlahKata += 1;
      }   
    }

    return jumlahKata;
    
  }

  public static int getVocalCount(String word) {
    int A_COUNT = 0,
        I_COUNT = 0,
        U_COUNT = 0,
        E_COUNT = 0,
        O_COUNT = 0;


    for (int i = 0; i < word.length(); i++) {
      if (Character.toLowerCase(word.charAt(i)) == 'a') {
        A_COUNT++;
      }

      if (Character.toLowerCase(word.charAt(i)) == 'i') {
        I_COUNT++;
      }

      if (Character.toLowerCase(word.charAt(i)) == 'u') {
        U_COUNT++;
      }

      if (Character.toLowerCase(word.charAt(i)) == 'e') {
        E_COUNT++;
      }

      if (Character.toLowerCase(word.charAt(i)) == 'o') {
        O_COUNT++;
      }

    }

    int[] vocals = { A_COUNT, I_COUNT, U_COUNT, E_COUNT, O_COUNT };

    return getLargest(vocals, vocals.length);
  }

  public static int getLargest(int[] a, int total){  
    int temp;  
    for (int i = 0; i < total; i++) {  
      for (int j = i + 1; j < total; j++) {  
        if (a[i] > a[j]) {  
          temp = a[i];  
          a[i] = a[j];  
          a[j] = temp;  
        }  
      }  
    }  

    return a[total-1];  
  }  
}
