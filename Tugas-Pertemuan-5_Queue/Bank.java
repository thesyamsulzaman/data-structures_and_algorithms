import java.util.ArrayDeque;

public class Bank {

  private String nama;
  private String[] data;
  private int palingDepan, palingBelakang;
  private int maxElemen;

  public Bank(int ukuran) {
    nama           = "Mangkiri";
    palingDepan    = 0;
    palingBelakang = 0;
    maxElemen      = ukuran;
    data           = new String[ukuran];
  }

  public void insert(String x) {
    if (palingBelakang == maxElemen) {
      System.out.println("Antrian Penuh, datang lagi besok");
    } else {
      data[palingBelakang] = x;
      palingBelakang++;
    }
  }

  public String remove() {
    String elemenYangDihapus = data[palingDepan];
    data[palingDepan] = null;
    palingDepan++;
    return elemenYangDihapus;
  }


  public String infoPalingBelakang() {
    return data[palingBelakang - 1];
  }

  public String infoPalingDepan() {
    return data[palingDepan];
  }

  public void infoAntrian() {
    for(int i = 0; i < data.length; i++) {
      System.out.println("Antrian ke " + (i) + " adalah " + data[i]);
    }
  }

  public void resetAntrian() {
    for(int i = 0; i < data.length; i++) {
      if ( data[i] == null && i != palingBelakang ) {
        data[i] = data[i + 1];
      }
    }
  }

  public void removeData(String elemen) {
    for (int i = 0; i < data.length; i++) {
      if (data[i] == elemen) {
        data[i] = null;
        palingDepan++;
      }
    }
  } 


  public static void main(String[] args) {

    Bank mankiri = new Bank(5);

    System.out.println("Selamat Datang di Bank " + mankiri.nama);

    mankiri.insert("A");
    mankiri.insert("B");
    mankiri.insert("C");
    mankiri.insert("D");
    mankiri.insert("E");

    mankiri.removeData("C");
    mankiri.infoAntrian();


  }


}


//Bank mandiri = new Bank();
