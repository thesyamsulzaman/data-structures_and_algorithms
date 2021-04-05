public class LinkedList {
  Node pertama = null, 
       posisi, 
       pendahulu;

  public static void main(String[] args) {
    LinkedList listBaru = new LinkedList();
    listBaru.isiData("20200040039", "Syamsul Zaman", 88);
    listBaru.isiData("20200040040", "Ujang Alexander", 78);
    listBaru.isiData("20200040041", "Michalea Pascal", 78);


    listBaru.tampilkan();
  }

  public void isiData(String nim, String nama, int nilai) {
    Node nodeBaru = new Node(nim, nama, nilai);
    nodeBaru.selanjutnya = this.pertama;
    this.pertama = nodeBaru;
  }

  public void tampilkan() {
    System.out.println("Tampilkan LinkedList");
    Node penunjuk = this.pertama;
    while(penunjuk != null) {
      System.out.println();

      penunjuk.infoNode();
      //System.out.println(penunjuk.selanjutnya);
      penunjuk = penunjuk.selanjutnya;
    }
  }

  public boolean findData(String data) {
    posisi = pertama;
    pendahulu = null;
    boolean ditemukan = false;

    while(posisi !=null){
      String nama = posisi.nama;
      if(nama.compareTo(data) == 0){
        ditemukan = true;
        break;
      }
      pendahulu = posisi;
      posisi = posisi.selanjutnya;
    }
    return ditemukan;
  }

  public boolean hapusData(String data){
    pendahulu = null;
    posisi = null;
    boolean ditemukan = findData(data);
    if(!ditemukan){
      System.out.println("Data yang akan dihapus tidak ditemukan");
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


}

class Node {

  String nim;
  String nama;
  int nilai;
  Node selanjutnya;

  Node(String nim, String nama, int nilai ) {
    this.nim = nim;
    this.nama = nama;
    this.nilai = nilai;
    this.selanjutnya = null;
  }

  public void infoNode() {
    System.out.println("NIM   : " + this.nim);
    System.out.println("Nama  : " + this.nama);
    System.out.println("Nilai : " + this.nilai);
    System.out.println("Next  : " + this.selanjutnya);
  }

  public static void main(String[] args) {}


}

