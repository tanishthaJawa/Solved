package hackerRank.Algorithms.Searching;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MissingNumbers {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        TreeMap<Integer,Integer>s1=new TreeMap<>();
        List<Integer>a = new ArrayList<>();
        for (Integer k : brr) {
            if (s1.containsKey(k))
                s1.put(k, s1.get(k) + 1);
            else
                s1.put(k, 1);
        }
        for (Integer z : arr) {
            if (s1.containsKey(z))
                s1.put(z, s1.get(z) - 1);
        }
        for(Map.Entry<Integer,Integer> en:s1.entrySet()){
            if(en.getValue()!=0){
                a.add(en.getKey());
            }
        }
        return a;
    }
}

 class Missing {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = MissingNumbers.missingNumbers(arr, brr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}


