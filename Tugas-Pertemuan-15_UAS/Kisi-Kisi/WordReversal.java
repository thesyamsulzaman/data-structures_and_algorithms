import java.lang.StringBuilder;

public class WordReversal {
  public static void main(String[] args) {

    String kata = "samsul";

    String[] kataInArray = kata.split("");

    StringBuilder kataInReverse = new StringBuilder();

    for (int i = kataInArray.length - 1; i >= 0; i--) {
      kataInReverse.append(kataInArray[i]);
    }

    System.out.println(kataInReverse);

  }
}
