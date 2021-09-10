package GeeksForGeeks.Arrays;
import java.util.*;
public class leftRotation {
   static int[] getData(int n , int d){
       Scanner in = new Scanner(System.in);
       n = 5;
       d = 3;
       System.out.println("Enter the elements of array");
       int[] arr = new int[n];
       for (int i = 0; i < n; i++) {
           arr[i] = in.nextInt();
       }
       return arr;
   }
   static void compute(int n , int d, int[] arr){
       n=5;
       d=3;
       int [] temp=new int[d];
       for(int i=0;i<d;i++){
           temp[i]=arr[i];
       }
       for(int j=0;j<n-d;j++){
           arr[j]=arr[j+d];
       }
       for (int k = 0; k <d; k++) {
           arr[k+n-d]=temp[k];
       }
   }
   static void putData(int n , int d, int[] arr){
       n=5;
       d=3;
       System.out.println("Rotated array" + arr.length);
       System.out.println("N =" + n);
       for(int i=0;i<n;i++){
           System.out.println(arr[i]);
       }
   }

    public static void main(String[] args) {
        int n=0,d=0;
        int[] arr = getData(n,d);
        compute(n,d,arr);
        putData(n,d,arr);
    }
}









