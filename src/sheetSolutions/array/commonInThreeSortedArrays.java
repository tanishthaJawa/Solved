package sheetSolutions.array;
/*
This program aims to find common elements in three sorted arrays.
 */
/*
@author tanishtha
 */
public class commonInThreeSortedArrays {
    static void common(int []ar,int []ar1,int[]ar2){
        //O(n1+n2+n3)
        int i=0,j=0,k=0;
        while(i<ar.length && j<ar1.length && k< ar2.length){
            if(ar[i] == ar1[j] && ar1[j] == ar2[k]){
                System.out.println("common element:"+ar[i]);
                i++;j++;k++;
            }
            else if(ar[i]<ar1[j]){//x<y
                i++;
            }
            else if(ar1[j]<ar2[k]){//y<z
                j++;
            }
            else// z is the smallest
                k++;
        }
    }

    static void common1(int []ar,int []ar1,int[]ar2) {
        //O(n1+n2+n3). This approach won't work for duplicate elements
        int i=0,j=0,k=0,prev,prev1,prev2;
        prev=prev1=prev2=Integer.MIN_VALUE;//keeps track of duplicates
        while(i<ar.length && j<ar1.length && k< ar2.length){
            if(ar[i]==prev){
                i++;
            }
            if(ar1[j]==prev1){
                j++;
            }
            if(ar2[k]==prev2){
                k++;
            }
            if(ar[i]==ar1[j] && ar1[j]==ar2[k]){
                System.out.println("common element:"+ar[i]);
                prev=ar[i];
                prev1=ar1[j];
                prev2=ar2[k];
                i++;
                j++;
                k++;
            }
           else if(ar[i]<ar1[j]){
                prev=ar[i];
                i++;
            }
           else if(ar1[j]<ar2[k]){
                prev1=ar1[j];
                j++;
            }
           else {
                prev2 = ar2[k];
               k++;
            }
        }
    }
    static void common2(int []ar,int []ar1,int[]ar2) {
        /*
        n this approach, we will first delete the duplicate from each array, and after this, we will find the
        frequency of each element and the element whose frequency equals 3 will be printed. For finding the
        frequency we can use a map but in this, we will use an array instead of a map. But the problem with
         using an array is, we cannot find the frequency of negative numbers so in the code given below we will
         consider each and every element of array to be positive.
         */
        int max= Integer.MIN_VALUE;// finds the max of array to determine size of new array
        int idx=0,idx1=0,idx2=0;
        for (int i = 1; i < ar.length; i++) {
            max=Math.max(ar[i],max);
            if(ar[i]!=ar[i-1]){
                ar[idx]=ar[i];
                idx++;
            }
        }
        for (int j = 1; j < ar1.length; j++) {
            max=Math.max(ar1[j],max);
            if(ar1[j]!=ar1[j-1]){
                ar1[idx1]=ar1[j];
                idx1++;
            }
        }
        for (int k = 1; k < ar2.length; k++) {
            max=Math.max(ar2[k],max);
            if(ar2[k]!=ar2[k-1]){
                ar2[idx2]=ar2[k];
                idx2++;
            }
        }
        int [] freq= new int[max+1];
        for (int i = 0; i < idx; i++) {
            freq[ar[i]]++;
        }
        for (int j = 0; j < idx1; j++) {
            freq[ar1[j]]++;
        }
        for (int k = 0; k < idx2; k++) {
            freq[ar2[k]]++;
        }
        for (int i = 0; i <=max; i++) {
            if(freq[i]==3)
                System.out.println(""+i);
        }

    }
    public static void main(String[] args) {
        int[] ar1 = {1, 5, 10, 20, 40, 80};
        int[] ar2 = {6, 7, 20, 80, 100};
        int[] ar3 = {3, 4, 15, 20, 30, 70, 80, 120};
        common(ar1,ar2,ar3);
        common1(ar1,ar2,ar3);
        common2(ar1,ar2,ar3);
    }
}
