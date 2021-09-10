package sheetSolutions.searchSort;

import java.util.ArrayList;
import java.util.HashMap;

public class firstAndLastOccurence {
    ArrayList<Long> find(long[] arr, int n, int x) {
        // code here
        return binarySearch(arr, x);
////        HashMap<Long,HashMap<Integer,Integer>> hs = new HashMap<>();
////        for (int i = 0; i < n; i++) {
////            if(hs.containsKey(arr[i])){
////                hs.put(arr[i],new Integer(i,hs.get(arr[i]);
////            }
////            else{
////                hs.put(arr[i],1);
////            }
////        }
   }
        private ArrayList<Long> binarySearch ( long[] arr, int x){
            int mid,low=0,high= arr.length;
            int midR, midL;
            ArrayList<Long> index = new ArrayList<>();
            index.add((long) -1);
            index.add((long) -1);
            while (low <= high) {
                mid = low + (high-low) / 2;
                if (arr[mid] == x) {
                    midR = mid ;
                    midL = mid ;
                    while (arr[midR + 1] == x) {
                        midR++;
                    }
                    while (arr[midL - 1] == x) {
                        midL--;
                    }
                    index.set(0, (long) midL);
                    index.set(1, (long) midR);
                    return index;
                } else if (arr[mid] < x) {
                    low = mid+1;
                } else {
                   high=mid-1;
                }
            }
            return index;

        }

    public static void main(String[] args) {
       long[] arr = { 1, 3, 5, 5, 5, 5, 7, 123, 125 };
       firstAndLastOccurence ob = new firstAndLastOccurence();
       ArrayList<Long> hs =ob.find(arr,9,7);
        for (Long h : hs) {
            System.out.println(h);
        }
    }
}

