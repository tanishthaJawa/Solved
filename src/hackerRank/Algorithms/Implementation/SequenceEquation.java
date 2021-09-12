package hackerRank.Algorithms.Implementation;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class SequenceEquation {
    /*
         * Complete the 'permutationEquation' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY p as parameter.
         */

        public static List<Integer> permutationEquation(List<Integer> p) {
            // Write your code here
            List<Integer> y = new ArrayList<>();
            int idx,idx1;
            int max=Collections.max(p);
            for(int i=1;i<=max;i++){
                idx=p.indexOf(i)+1;
                idx1=p.indexOf(idx)+1;
                y.add(idx1);
            }
            return y;
        }

    }

     class Equation {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = SequenceEquation.permutationEquation(p);

            bufferedWriter.write(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining("\n"))
                            + "\n"
            );

            bufferedReader.close();
            bufferedWriter.close();
        }
    }


