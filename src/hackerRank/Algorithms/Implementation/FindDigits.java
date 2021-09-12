package hackerRank.Algorithms.Implementation;
import java.io.*;
import java.util.*;
public class FindDigits {

    // Complete the findDigits function below.
    static int findDigits(int n) {
        int d,count=0;
        int k=n;
        while(n!=0){
            d=n%10;
            n=n/10;
            if(d!=0&&k%d==0)
                count++;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


