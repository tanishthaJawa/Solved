package hackerRank.Algorithms.Implementation;
import java.io.*;
import java.util.*;
public class salesByMatch {

    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer,Integer>a= new HashMap<>();
        int count=0;
        for(int i =0;i<n;i++){
            if(a.containsKey(ar[i])){
                a.put(ar[i],a.get(ar[i])+1);
            }
            else
                a.put(ar[i],1);
        }
        Collection getValues=a.values();
        for (Integer k : (Iterable<Integer>) getValues) {
            if (k % 2 == 0)
                count = count + k / 2;
            else
                count = count + (k - 1) / 2;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

