package sheetSolutions.searchSort;

/*
finds the first and last occurrence in sorted array
 */
import java.util.Arrays;

public class firstAndLastOccurrence {
    //recursive approach .Takes O(log N) time and O(log n) space
   static int first(int []ar,int low,int high, int x){
    int mid;
       if (low<=high){
           mid=low+(high-low)/2;
           if( (mid==0 || ar[mid-1]<x) && ar[mid]==x )
               return mid;
           else if(x > ar[mid])
               return first(ar,mid+1,high,x);
           else
               return  first(ar,low,mid-1,x);
       }
       return -1;
   }
    static int last(int []ar,int low,int high, int x){
        if (low<=high){
           int mid=low+(high-low)/2;
            if((mid==ar.length-1 || ar[mid+1]>x) && ar[mid]==x){
                return mid;
            }
            else if(x<ar[mid])
                return last(ar,low,mid-1,x);
            else
                return  last(ar,mid+1,high,x);
        }
        return -1;
    }
    static int first1(int []ar,int low,int high, int x){
       //iterative approach .Takes O(log N) time and O(1) space
        int mid,res=-1;
        while (low<=high){
            mid=low+(high-low)/2;
            // If arr[mid] is same as
            // x, we update res and
            // move to the left half.
            if( ar[mid]==x ){
                res=mid;
                high=mid-1;
            }
            else if(x < ar[mid])
               high=mid-1;
            else
                low=mid+1;
        }
        return res;
    }
    static int last1(int []ar,int low,int high, int x){
       int res=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            // If arr[mid] is same as
            // x, we update res and
            // move to the right half.
            if(ar[mid]==x){
                res= mid;
                low=mid+1;
            }
            else if(x<ar[mid])
                high=mid-1;
            else
              low=mid+1;
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr={2,3,5,5,6,6,7,7,7,7,8,8};
        System.out.println(Arrays.toString(arr));
        System.out.println(first(arr,0,arr.length-1,7));
        System.out.println(last(arr,0,arr.length-1,7));
        System.out.println(first1(arr,0,arr.length-1,7));
        System.out.println(last1(arr,0,arr.length-1,7));
    }

}