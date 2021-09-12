package hackerRank.Algorithms.Implementation;
import java.util.*;
import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
public class TwoSets {
    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        ArrayList<Integer> a1 = new ArrayList<>();
        int count = 0;
        boolean temp = false, temp1 = false;
        for (int i = 1; i <= 100; i++) {
            int k = i;
            for (Integer integer : a) {
                if (k % integer == 0) {
                    temp = true;
                } else {
                    temp = false;
                    break;
                }
            }
            if (temp)
                a1.add(k);
        }
        for (Integer integer : a1) {
            for (Integer value : b) {
                if (value % integer == 0) {
                    temp1 = true;
                } else {
                    temp1 = false;
                    break;
                }
            }
            if (temp1)
                count++;
        }
        return count;
    }
}
    class Solution5 {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int total =TwoSets.getTotalX(arr, brr);

            bufferedWriter.write(String.valueOf(total));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }





