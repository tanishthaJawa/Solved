package hackerRank.Algorithms.Implementation;
import java.util.*;
public class stairCase {
    // Complete the staircase function below.
    static void staircase(int n) {
        for(int i=1;i<=n;i++)
        {
            for(int k=n-1;k>=i;k--)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++)
                System.out.print("#");
            System.out.println();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
