import java.util.ArrayList;
import java.util.Scanner;

public class Playground {
  public static void main(String[] args) {

    int keluar = 0;
    ArrayList <Mahasiswa> dataMahasiswa = new ArrayList<>(); 
    ArrayList <Buku> dataBuku = new ArrayList<>(); 
    ArrayList <Transaksi> dataTransaksi = new ArrayList<>(); 

    while(keluar != 1) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("\n");
      System.out.print("------------ Perpustakaan -------------- \n");
      System.out.print("\n");
      System.out.print("------------     Menu     -------------- \n");
      System.out.print("[1] Mahasiswa \n");
      System.out.print("[2] Buku \n");
      System.out.print("[3] Transaksi \n");
      System.out.print("---------------------------------------- \n");
      System.out.print("Pilih Menu : ");
      int menu = scanner.nextInt();

      switch(menu) {
        case 1: 
          menuMahasiswa();
      }

      System.out.print("Keluar [1 = ya, 0 = tidak ] ? : ");
      int confirm = scanner.nextInt();

      keluar = confirm;
    }
    
  }

  public static void menuMahasiswa() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("\n");
    System.out.print("--------------- Mahasiswa -------------- \n");
    System.out.print("\n");
    System.out.print("--------------- Pilih Menu -------------- \n");
    System.out.print("[1] Tampilkan Data Mahasiswa \n");
    System.out.print("[2] Tambah Data Mahasiswa \n");
    System.out.print("[3] Hapus Data Mahasiswa \n");
    System.out.print("---------------------------------------- \n");
    System.out.print("Pilih Aksi : ");
    int menu = scanner.nextInt();
  } 

  public static void menuBuku() {} 
  public static void menuTransaksi() {} 


}

class Mahasiswa {
  String nim, nama;

  public Mahasiswa(String nim, String nama) {
    this.nim = nim;
    this.nama = nama;
  }
}

class Buku {
  String kode,judul;

  public Buku(String kode, String judul) {
    this.kode = kode;
    this.judul = judul;
  }

}


class Transaksi {
  String nim, nama_mahasiswa, judul_buku;
  int jumlah_buku ;

  public Transaksi(String nim, String nama, String judul_buku, int jumlah_buku) {
    this.nim = nim;
    this.nama_mahasiswa = nama_mahasiswa;
    this.judul_buku = judul_buku;
    this.jumlah_buku = jumlah_buku;
  }
}

