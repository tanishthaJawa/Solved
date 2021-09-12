package hackerRank.Algorithms.Implementation;
import java.util.*;
public class plusMinus {
    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double s=0,s1=0,s2=0;
        double k=0.06d,k1=0.06d,k2=0.06d;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0)
                s++;
            else if(arr[i]<0)
                s1++;
            else
                s2++;
        }
        k=s/arr.length;
        k1=s1/arr.length;
        k2=s2/arr.length;
        System.out.println(k);
        System.out.println(k1);
        System.out.println(k2);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
