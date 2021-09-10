package hackerRank.Algorithms.Implementation;
import java.io.*;
import java.util.*;
public class ElectronicsShop {
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        int sum;
        int max=-1;
        for (int keyboard : keyboards) {
            for (int drive : drives) {
                sum = keyboard + drive;
                if (sum <= b) {
                    max = Math.max(sum, max);
                }
            }
        }
        return max;
        /* Arrays.sort(keyboards, Collections.reverseOrder());//Descending order
        Arrays.sort(pendrives);//Ascending order
                               //.Pendrives and keyboards are Integer arrays.
        int max = -1;
        for(int i = 0, j = 0; i < n; i++){
            for(; j < m; j++){
                if(keyboards[i]+pendrives[j] > s) break; //This prevents j from incrementing
                if(keyboards[i]+pendrives[j] > max)
                    max = keyboards[i]+pendrives[j];
            }
        }
        System.out.println(max);*/
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

