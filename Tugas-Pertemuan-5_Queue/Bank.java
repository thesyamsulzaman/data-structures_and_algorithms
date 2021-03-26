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
      System.out.println("Data ke " + (i + 1) + " adalah " + data[i]);
    }
  }

  public void infoData(String elemen) {
    for (int i = 0; i < data.length; i++) {
      if (data[i] == elemen) {
        System.out.println( elemen + " ditemukan");
      }
      else {
        System.out.println( elemen + " tidak ditemukan");
      }
    }
  } 


  public static void main(String[] args) {

    Bank mankiri = new Bank(5);

    System.out.println("Selamat Datang di Bank " + mankiri.nama);

    mankiri.insert("Ahmad");
    mankiri.insert("Basit");
    mankiri.insert("Ujang");
    mankiri.insert("James");
    mankiri.insert("Rami");

    mankiri.remove();

    mankiri.infoAntrian();
    System.out.println("Paling Depan    : " + mankiri.infoPalingDepan());
    System.out.println("Paling Belakang : " + mankiri.infoPalingBelakang());
    mankiri.infoAntrian();

  }


}


//Bank mandiri = new Bank();
