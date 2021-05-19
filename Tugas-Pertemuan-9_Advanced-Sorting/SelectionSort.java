import java.util.Arrays;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class SelectionSort {

  public static void main(String[] args) {
    int[] arr = {5, 4, 3, 2, 1}; 

    int min = arr[0];
    int index = 0;
    int swappingProcess = 0;

    long startTime = System.nanoTime();

    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i; j < arr.length; j++) {
        if ( arr[j] < min ) {
          min = arr[j];
          index = j;
          swappingProcess++;
        }
      }
      if ( min < arr[i] ) {
        arr[index] = arr[i];
        arr[i] = min;
      }
      min = arr[i + 1];
      System.out.println(Arrays.toString(arr) + " - Total Swap : " + swappingProcess);
    }

    long endTime = System.nanoTime();
    long timeElapsed = endTime - startTime;
    System.out.println("Total waktu dihabiskan : " + timeElapsed + " nano detik");



  }

}
