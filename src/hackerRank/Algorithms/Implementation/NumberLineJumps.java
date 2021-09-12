package hackerRank.Algorithms.Implementation;
import java.io.*;
import java.util.*;
public class NumberLineJumps {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        String  ans="";
        if((x1>x2&&v1>v2)||(x2>x1&&v2>v1))
            ans="NO";
        else
        {
            for(int i =0;i<5000;i++)
            {
                x1=x1+v1;
                x2=x2+v2;
                if(x1==x2){
                    ans ="YES";
                    break;
                }
                else
                    ans="NO";
            }
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

