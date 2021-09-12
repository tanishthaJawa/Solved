package hackerRank.Algorithms.Implementation;
import java.io.*;
import java.util.*;

public class SaveThePrisoner {

    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {
    /*We start off at some random prisoner S and try to distribute M candies. We could just do
S + M to see which prisoner we end up at. However, we may have more candies than prisoners,
so we loop back around to the first prisoner by doing the % N where N is number of prisoners.
Each +1 and -1 that you see in the equation is to fix the off-by-one problems that exist
since prisoners are counted from 1 to N while modular arithmetic is counted from 0.*/

        return ((s-1)+(m-1))%n+1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


