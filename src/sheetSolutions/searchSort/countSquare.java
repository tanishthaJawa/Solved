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
  
static int countSquares(int N) {
        // code here
       if (N == 0 || N == 1)
            return 0;

        long start = 1, end= N/2, ans = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;

            // If x is a perfect square
            if (mid * mid == N)
                return (int) mid -1;

            if (mid * mid < N) {
                start = mid + 1;
                ans = mid;
            }
            else // If mid*mid is greater than x
                end = mid - 1;
        }
        return (int)ans;
    }
  public static void main(String[] args) {
    System.out.println(count(9));
  }
}
