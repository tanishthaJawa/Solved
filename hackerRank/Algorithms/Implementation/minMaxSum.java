package hackerRank.Algorithms.Implementation;
import java.util.*;
public class minMaxSum {
    static void miniMaxSum(int[] arr) {

        /*Arrays.sort(arr);
        long min=0,max=0;
        for(int i=0;i<arr.length-1;i++)
            min=min+arr[i];
        for(int i=1;i<arr.length;i++)
            max=max+arr[i];
        System.out.print(min+" "+max) ;*/

        long min=arr[0],max=arr[0],sum=0; //Method 2
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min)
                min=arr[i];
            if(arr[i]>max)
                max=arr[i];
            sum=sum+arr[i];
        }
        min=sum-min;
        max=sum-max;
        System.out.println(max+" "+min);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}

