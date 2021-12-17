package sheetSolutions.searchSort;

public class countSquare {
  static int count(int N) {
    int count = 0;
    int n = (int) Math.sqrt(N);
    for (int i = 1; i <= n; i++) {
      if (i * i < N) count++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(count(9));
  }
}
