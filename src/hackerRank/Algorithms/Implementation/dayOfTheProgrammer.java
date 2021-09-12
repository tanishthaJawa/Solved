package hackerRank.Algorithms.Implementation;
import java.io.*;
public class dayOfTheProgrammer {
    static String dayOfProgrammer(int year) {
        String date;
        if(year==1918 )
            date="26.09.1918";
        else
        {
            if((year<1918 &&year%4==0)||(year%400==0||(year%4==0 && year%100!=0)))
                date="12.09."+year;
            else
                date ="13.09."+year;
        }
        return date;


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

