import java.util.ArrayList;

public class LinearSearch {


  public static void main(String[] args) {

    Mahasiswa[] listMahasiswa = {
      new Mahasiswa("1102021", "Andri Hariadi", "Bandung"),
      new Mahasiswa("1102022", "Dewi Lestari", "Surabaya"),
      new Mahasiswa("1102023", "Dewi Agustin", "Malang"),
      new Mahasiswa("1102024", "Reni Indrayani", "Malang"),
      new Mahasiswa("1102025", "Toni Sukmawan", "Surabaya"),
      new Mahasiswa("1102026", "Toni Gunawan", "Bandung")
    };

    search(listMahasiswa, "Toni");

  }

  public static void search(Mahasiswa[] mahasiswa, String keyword) {
    boolean ditemukan = false;
    for (int i = 0; i < mahasiswa.length; i++) {

      if (mahasiswa[i].nama.toLowerCase().contains(keyword.toLowerCase())) {
        ditemukan = true;
        System.out.println(
            mahasiswa[i].nim + " - "
            + mahasiswa[i].nama + " - " 
            + mahasiswa[i].alamat + " - "
            + "Data nomor " + (i + 1)
        );
      }

    }

    if (!ditemukan) {
      System.out.println("Data yg anda cari tidak ditemukan");
    }

  }
}

class Mahasiswa {
  String nim;
  String nama;
  String alamat;

  public Mahasiswa(String nim, String nama, String alamat) {
    this.nim = nim;
    this.nama = nama;
    this.alamat = alamat;
  }
}
