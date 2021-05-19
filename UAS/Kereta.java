
// ---------------------- 
// Nama : Syamsul Zaman
// NIM  : 20200040039
// ----------------------

public class Kereta {
  Gerbong pertama = null,
          posisi,
          pendahulu;

  public void tambahGerbong(String nama, int jumlahTampung) {
    Gerbong gerbongBaru = new Gerbong(nama, jumlahTampung);
    gerbongBaru.selanjutnya = this.pertama;
    this.pertama = gerbongBaru;
  }

  public void tampilkan() {
    System.out.println("Tampilkan Semua Gerbong");
    Gerbong penunjuk = this.pertama;
    while(penunjuk != null) {
      System.out.println();

      penunjuk.infoGerbong();
      penunjuk = penunjuk.selanjutnya;
    }
  }

  public boolean cariGerbong(String namaGerbong) {
    posisi = pertama;
    pendahulu = null;
    boolean ditemukan = false;

    while(posisi !=null){
      String nama = posisi.nama;
      if(nama.compareTo(namaGerbong) == 0){
        ditemukan = true;
        break;
      }
      pendahulu = posisi;
      posisi = posisi.selanjutnya;
    }
    return ditemukan;
  }


  public boolean hapusGerbong(String namaGerbong){
    pendahulu = null;
    posisi = null;
    boolean ditemukan = cariGerbong(namaGerbong);
    if(!ditemukan){
      System.out.println("Gerbong tidak ditemukan");
      return false;
    }
    if(pendahulu==null){
      pertama = pertama.selanjutnya;
    }
    else{
      pendahulu.selanjutnya = posisi.selanjutnya;
    }
    return true;
  }

  public static void main(String[] args) {
    Kereta KRL = new Kereta();

    KRL.tambahGerbong("Pertama", 20);
    KRL.tambahGerbong("Kedua", 15);
    KRL.tambahGerbong("Ketiga", 3);

    KRL.hapusGerbong("Ketiga");
    KRL.tampilkan();


  }
}

class Gerbong {
  String nama;
  int jumlahTampung;
  Gerbong selanjutnya;

  Gerbong(String nama, int jumlahTampung) {
    this.nama = nama;
    this.jumlahTampung = jumlahTampung;
    this.selanjutnya = null;
  }

  public void infoGerbong() {
    System.out.println("Nama           : " + this.nama);
    System.out.println("Jumlah Tampung : " + this.jumlahTampung);
    System.out.println("Selanjutnya    : " + this.selanjutnya);
  }

  public String toString() {
    return "{ Gerbong : " + this.nama + ", Kapasitas : " + this.jumlahTampung + " }";
  }

  public static void main(String[] args) {}
}
