package hackerRank.Algorithms.Implementation;
import java.io.*;
import java.util.*;

public class BeautifulDaysAtMovies{

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int digit,reverse=0,num;
        int count=0;
        for(int x=i;x<=j;x++){
            num=x;
            while(num!=0){
                digit= num%10;
                reverse= reverse*10+digit;
                num=num/10;
            }
            int temp=Math.abs((x-reverse));
            if(temp%k==0)
                ++count;
        }
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

