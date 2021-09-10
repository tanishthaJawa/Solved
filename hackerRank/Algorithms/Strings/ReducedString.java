package hackerRank.Algorithms.Strings;
import java.io.*;
import java.util.*;

 public class ReducedString {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
        // Write your code here
        char[] s1 =s.toCharArray();
        Stack <Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(char ch:s1){
            if(st.isEmpty())
                st.push(ch);
            else if(st.peek()==ch)
                st.pop();
            else
                st.push(ch);
        }
        if(st.isEmpty())
            return "Empty String";
        else
        {
            while(!st.empty())
                result.insert(0,st.pop());
        }
        return result.toString();
    }

}

 class Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = ReducedString.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


