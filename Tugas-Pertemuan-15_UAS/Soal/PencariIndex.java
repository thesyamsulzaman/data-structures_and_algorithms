import java.util.*;

class Result {
  
  public static ArrayList<String> getPosition(int nilai, List<Integer> arr) {

    ArrayList<String> positions = new ArrayList<String>();

    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i) == nilai) {
        positions.add(String.valueOf(i + 1));
      }
    }
  
    return positions;
  }
}

public class PencariIndex {

  public static void main(String[] args) {

    List<Integer> numbers = Arrays.asList(2, 8, 2, 3, 5, 10, 10, 8, 8, 3, 5);

    System.out.println(Result.getPosition(2, numbers));
    System.out.println(Result.getPosition(8, numbers));
    System.out.println(Result.getPosition(3, numbers));
    System.out.println(Result.getPosition(5, numbers));
    System.out.println(Result.getPosition(10, numbers));
    System.out.println(Result.getPosition(11, numbers));


  }
}
