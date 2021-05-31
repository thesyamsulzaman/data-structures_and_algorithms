public class BinarySearch {
  public static void main(String[] args) {

    int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    System.out.println(search(sortedArray, 11));

  }

  public static int search(int[] array, int number) {
    int awal = 0;
    int akhir = array.length;
    int ditemukan = -1;

    try {
      while (awal <= akhir) {
        int tengah = (awal + akhir) / 2;
        int pointer = array[tengah];

        if ( number > pointer ) {
          awal = tengah + 1;
        }

        if ( number < pointer ) {
          akhir = tengah - 1;
        }

        if ( number == pointer ) {
          return pointer;
        }

      }
      return ditemukan;
    } 

    catch (ArrayIndexOutOfBoundsException exception) {
      return ditemukan;
    }

  }
}
