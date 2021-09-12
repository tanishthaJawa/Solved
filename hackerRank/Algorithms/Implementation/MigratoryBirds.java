package hackerRank.Algorithms.Implementation;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class MigratoryBirds {
    static int migratoryBirds(List<Integer> arr) {
        int key;
        HashMap<Integer,Integer>m=new HashMap<>();
        for(int i=0;i<arr.size();i++){
            if(m.containsKey(arr.get(i)))
            {
                m.replace(arr.get(i),m.get(arr.get(i))+1);
            }
            else
            {
                m.put(arr.get(i),1);
            }
        }
        key=Collections.max(m.entrySet(),Map.Entry.comparingByValue()).getKey();
        return key;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


