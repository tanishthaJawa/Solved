package hackerRank.Algorithms.Implementation;
import java.io.*;
public class CountingValleys {
    public static int countingValleys(int steps, String path) {
        // Write your code here
        int count=0,valleys=0;
        for(int i=0;i<steps;i++){
            if(path.charAt(i)=='U'){
                count++;
            }
            else{
                count--;
            }
            if(count ==0&&path.charAt(i)=='U')
                valleys++;
        }
        return valleys;
    }
}

 class Solution10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = CountingValleys.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


