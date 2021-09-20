package sheetSolutions.searchSort;
/*
this program consists of unsorted N positive integers from 0...N . a number occurs twice in an array and a number is missing.
Find those.
 */

import java.util.Arrays;

public class findRepeatedAndMissing {
    static  int[] findTwoElement(int[] arr, int n) {
        // code here
        int[] arr1 = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int abs_value= Math.abs(arr[i]);// abs value of positive numbers are positive numbers.3
             if(arr[abs_value-1]>0){//-1 for index .if num is 2 it would be at 0 or 1
                 arr[abs_value-1]=-arr[abs_value-1];//abs_value is index here
             }
             else// if a number is already negative it occurs twice
                 arr1[0]=abs_value;
        }
        for (int i = 0; i < n; i++) {
            if(arr[i]>0){
                arr1[1]=i+1;// the above loop will terminate just after finding repeating value . thus a positive
                //value will be encountered at index just less than missing value.
            }

        }
        return arr1;
    }
    static  long[] findTwoElement1(long[] arr, int n) {
        // code here
        /*
        SumN = 1 + 2 + 3 + … + N = (N * (N + 1)) / 2
        And, let the sum of all the array elements be Sum. Now,
        SumN = Sum – A + B
        A – B = Sum – SumN …(equation 1)
        SumSqN = 12 + 22 + 32 + … + N2 = (N * (N + 1) * (2 * n + 1)) / 6
         And, let the sum of the squares of all the array elements be SumSq. Now,
        SumSq = SumSqN + A2 – B2
        SumSq – SumSqN = (A + B) * (A – B) …(equation 2)
        Put value of (A – B) from equation 1 in equation 2,
        SumSq – SumSqN = (A + B) * (Sum – SumN)
        A + B = (SumSq – SumSqN) / (Sum – SumN) …(equation 3)
       Solving equation 1 and equation 3 will give,
         B = (((SumSq – SumSqN) / (Sum – SumN)) + SumN – Sum) / 2
       And, A = Sum – SumN + B

         */
        long[] arr1 = new long[2];
        long sumN= ((long) n *(n+1))/2;//sum of all integers
        long sumSqN =(n*(n+1)*(2L *n+1))/6;//product of all squares of integers
        long sum=0,sumSq=0;
        for (long j : arr) {
            sum += j;
            sumSq += Math.pow(j, 2);
        }

       long B=(((sumSq-sumSqN)/(sum-sumN))+sumN-sum)/2; //missing
        long A=sum-sumN+B;//repeating
        arr1[0]=A;
        arr1[1]=B;
        return arr1;
    }
    public static void main(String[] args) {
        int []arr={4,2,1,2};
        long []arr2={4,2,1,2};
        int []ar=findTwoElement(arr,4);
        System.out.println(Arrays.toString(ar));
        long []ar1=findTwoElement1(arr2,4);
        System.out.println(Arrays.toString(ar1));
    }
}


