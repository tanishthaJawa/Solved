package hackerRank.Algorithms.Searching;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class SherLockAndArray {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        int leftSum=0;
        int sum=0;
        String ans="NO";
        for(int i:arr){
            sum+=i;
        }
        for(int y:arr){
            if(2*leftSum==sum-y)
                ans="YES"  ;
            leftSum=leftSum+y;
        }
        return ans;

    }
}

 class Solution23 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = SherLockAndArray.balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


