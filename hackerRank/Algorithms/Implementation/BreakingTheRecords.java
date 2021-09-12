package hackerRank.Algorithms.Implementation;
import java.io.*;
import java.util.*;
public class BreakingTheRecords {
    static int[] breakingRecords(int[] scores) {
        long hScore=scores[0] ,lScore=scores[0];
        int count =0,count1=0;
        for (int score : scores) {
            if (score > hScore) {
                hScore = score;
                count++;
            }
            if (score < lScore) {
                lScore = score;
                count1++;
            }
        }
        int ans[]={count,count1};
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


