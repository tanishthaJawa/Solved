package hackerRank.Algorithms.Implementation;
import java.io.*;
import java.util.*;
public class timeConversion {
    static String timeConversion(String s) {
        String h=s.substring(0,2) ;
        int hrs = Integer.parseInt(h);
        if(s.contains("PM"))
        {
            if(hrs>00&&hrs<12)
            {//1-11p.m.
                hrs=hrs+12;
            }
        }
        else
        {
            if(hrs==12)
                hrs=hrs-12;
        }
        String hr = String.valueOf(hrs);
        if(hrs<10)
        {
            hr="0"+hr;
        }
        String w = hr+s.substring(2,8);
        return w;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}

