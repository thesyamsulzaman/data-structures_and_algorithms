import java.util.Stack;
import java.util.Scanner;

public class Playlist {

  Stack <String> music;

  Playlist() {
    music = new Stack<String>();
  }

  public static void tampilMenu(String menu) {
    switch(menu) {
      case "utama":
        System.out.println("------------     Playlist    --------------");
        System.out.println("[1] Tampilkan Lagu ");
        System.out.println("[2] Tambah Lagu");
        System.out.println("[3] Hapus lagu");
        System.out.println("[4] Hapus Semua lagu");
        System.out.println("[0] Keluar dari Aplikasi");
        System.out.println("--------------------------------------------");
        break;
      case "tambah-lagu":
        System.out.println("----------     Tambah Lagu    --------------");
        System.out.println("[1] Tambah Lagu ");
        //System.out.println("[1] Tambah Lagu dari Atas");
        //System.out.println("[2] Tambah Lagu dari Bawah");
        System.out.println("[0] Kembali ke Menu");
        System.out.println("--------------------------------------------");
        break;
      case "hapus-lagu":
        System.out.println("----------     Hapus Lagu    --------------");
        System.out.println("[1] Hapus Lagu");
        //System.out.println("[1] Hapus Lagu dari Atas");
        //System.out.println("[2] Hapus Lagu dari Bawah");
        System.out.println("[0] Kembali ke Menu");
        System.out.println("--------------------------------------------");
        break;
      case "hapus-semua-lagu":
        System.out.println("------------  Hapus semua Lagu  -----------");
        System.out.println("[1] Yakin ");
        System.out.println("[0] Kembali ");
        System.out.println("--------------------------------------------");
        break;
    }
  }

  void tampilkanLagu() {
    if (music.empty()) {
      System.out.println("Lagu Kosong");
    } else {
      for (String song: music) {
        System.out.println("* "+ song);
      }
    }

  }

  void tambahLagu() {
    int isDone = 0;
    while(isDone != 1) {
      System.out.println("");

      tampilMenu("tambah-lagu");

      Scanner input = new Scanner(System.in);
      System.out.print("Pilih Menu : ");
      int menu = input.nextInt();

      System.out.println("");

      switch(menu) {
        case 1:
          Scanner scanner = new Scanner(System.in);

          System.out.print("Penyanyi : ");
          String penyanyi = scanner.next();
          penyanyi += scanner.nextLine();

          System.out.print("Judul    : ");
          String judul = scanner.next();
          judul += scanner.nextLine();

          music.add(penyanyi + " - " + judul);
          break;
        case 2:
          break;
        case 0:
          isDone = 1;
          break;
      }

    } 
  }

  void hapusLagu() {
    int isDone = 0;
    while(isDone != 1) {
      System.out.println("");

      tampilMenu("hapus-lagu");

      Scanner input = new Scanner(System.in);
      System.out.print("Pilih Menu : ");
      int menu = input.nextInt();

      System.out.println("");

      switch(menu) {
        case 1:
          music.pop();
          isDone = 1;
          break;
        case 0:
          isDone = 1;
          break;
      }

    } 
  }

  void hapusSemuaLagu() {
    int isDone = 0;
    while(isDone != 1) {
      System.out.println("");

      tampilMenu("hapus-semua-lagu");

      Scanner input = new Scanner(System.in);
      System.out.print("Pilih Menu : ");
      int menu = input.nextInt();

      System.out.println("");

      switch(menu) {
        case 1:
          music.clear();
          isDone = 1;
          break;
        case 0:
          isDone = 1;
          break;
      }

    } 
  }

  public static void main(String[] args) {
    Playlist myMusic = new Playlist();

    int isDone = 0;

    while(isDone != 1) {
      System.out.println("");

      tampilMenu("utama");

      Scanner input = new Scanner(System.in);
      System.out.print("Pilih Menu : ");
      int menu = input.nextInt();

      System.out.println("");

      switch(menu) {
        case 1:
          myMusic.tampilkanLagu();
          break;
        case 2:
          myMusic.tambahLagu();
          break;
        case 3:
          myMusic.hapusLagu();
          break;
        case 4:
          myMusic.hapusSemuaLagu();
          break;
        case 0:
          isDone = 1;
          break;
      }

    }


  }

}
