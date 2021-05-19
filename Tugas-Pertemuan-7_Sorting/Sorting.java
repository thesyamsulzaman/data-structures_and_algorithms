public class Sorting {

  public static void main(String[] args) {

    int[] number = { 10,2, 9, 3, 2,8, 7, 6, 5, 4, 1 };

    // { Insertion Sort }
    for (int i = 0; i < number.length; i++) {
      int temp = number[i];
      int position = i;

      while( position >= 1 && number[position - 1] > temp ) {
        number[position] = number[position - 1];
        position--;
      }

      number[position] = temp;
    }

    for (int i = 0; i < number.length; i++) {
      System.out.print( number[i] + " ");
    }

    System.out.println();
  }
}



    // { Bubble Sort }
    //for (int i = 0; i < number.length; i++) {
      //for (int j = 0; j < number.length; j++) {
        //int temp;
        //if ( number[i] < number[j] ) {
          //temp = number[i];
          //number[i] = number[j];
          //number[j] = temp;
        //}

      //}
    //}
