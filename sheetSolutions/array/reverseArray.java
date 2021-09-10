package sheetSolutions.array;
//Program to reverse an array
public class reverseArray {
    //iterative approach. Swapping  first element by last
   static void reverse(int[] ar, int start, int end){
       while(start<end){
           int temp=ar[start];
           ar[start]=ar[end];
           ar[end]=temp;
           start++;
           end--;
       }
   }
    static void recursiveReverse(int[] ar, int start, int end){
         if(start>=end)
             return;
          int temp=ar[start];
            ar[start]=ar[end];
            ar[end]=temp;
            recursiveReverse(ar,start+1,end-1);

    }
   static void printArray(int[] ar){
       for (int j : ar) {
           System.out.print(j + " ");
       }
       System.out.println();
   }

    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7,8};
        printArray(arr);
        reverse(arr,0,arr.length-1);
        printArray(arr);
        recursiveReverse(arr,0,arr.length-1);
        printArray(arr);
    }
}
