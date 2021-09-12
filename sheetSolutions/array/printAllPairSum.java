package sheetSolutions.array;

import java.util.Arrays;
import java.util.HashMap;

public class printAllPairSum {
    //O(n2)
    static void printPair(int []arr,int sum){
        for(int i=0;i< arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==sum){
                    System.out.println("("+arr[i]+","+arr[j]+")");
                }
            }
        }
    }
    static void printPair1(int []arr,int sum) {//O(n)
        HashMap<Integer,Integer> hs = new HashMap<>();
        for (int j : arr) {
            int num = sum - j;
            if (hs.containsKey(num)) {
                int count = hs.get(num);
                /* counts the no. of times an element exist in array.for example 5 is two times . we can pair them twice.
                 */
                for(int k = 0; k < count; k++)
                    System.out.print("(" + num +
                            ", " + j+
                            ")" + "\n");
            }
            if (hs.containsKey(j)) {

                hs.put(j, hs.get(j) + 1);
            } else {
                hs.put(j, 1);
            }
        }
    }
    static void printPair3(int []arr,int sum){
        //will not work for duplicate elements-O(n)
        int low=0 , high=arr.length-1;
        Arrays.sort(arr);
        while(low<high){
            int num=arr[low]+arr[high];
            if(num>sum){
                high--;
            }
            else if(num<sum){
                low++;
            }
            else{
                System.out.println("("+arr[low]+","+arr[high]+")");
                low++;
                high--;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { 1,1, 5, 7, -1 ,5 };
        int sum=6;
        System.out.println(Arrays.toString(arr));
        printPair1(arr,sum);
    }
}
