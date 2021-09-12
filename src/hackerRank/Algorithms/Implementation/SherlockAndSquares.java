package hackerRank.Algorithms.Implementation;
import java.io.*;
import java.util.stream.*;
public class SherlockAndSquares {
        /*
         * Complete the 'squares' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER a
         *  2. INTEGER b
         */

        public static int squares(int a, int b) {
            // Write your code here
            /* instead of finding square root of every element we can find square root of first and last elements ,becasue we are dealing with range here . ie. if sqr of 4 and 7 exists then we will have sqrt of 5 and 6 as well*/
            int ans = (int)Math.ceil(Math.sqrt(a));
            int ans1=(int)Math.floor(Math.sqrt(b));
            int count=0;
            for(int i=ans;i<=ans1;i++){
                count++;
            }
            return count;
        }

    }

    class ans3 {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, q).forEach(qItr -> {
                try {
                    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                    int a = Integer.parseInt(firstMultipleInput[0]);

                    int b = Integer.parseInt(firstMultipleInput[1]);

                    int result = SherlockAndSquares.squares(a, b);

                    bufferedWriter.write(String.valueOf(result));
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            bufferedWriter.close();
        }
    }


