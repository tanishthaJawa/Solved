package sheetSolutions.string;

import java.util.HashMap;
import java.util.Map;

public class countDuplicates {
    //using hashmap.O(NlogN).N-length of string logN-for insertion.
    //Space complexity-O(k) k-size of map
    static void countNoOfDuplicates(String s){
        HashMap<Character,Integer> hs= new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            if(hs.containsKey(s.charAt(i))){
                hs.put(s.charAt(i),hs.get(s.charAt(i))+1);
            }
            else{
                hs.put(s.charAt(i),1);
            }
        }
      for(Map.Entry mapSet: hs.entrySet()){
         char ch= (char)mapSet.getKey();
         int count=(int)mapSet.getValue();
         if(count>1){
             System.out.println(ch+" "+ count);
         }
      }
    }
    static void countNoOfDuplicates1(String s){
        //using hashing. O(n) space complexity-O(no. of characters(256 here))
        int []ar= new int[256];
        for (int i = 0; i < s.length(); i++) {
            ar[s.charAt(i)]++;
        }
        for (int i = 0; i < ar.length; i++) {
            if(ar[i]>1)
                System.out.println((char)i+" "+ar[i] );
        }
    }

    public static void main(String[] args) {
        String s="GeeksForGeeks";
        countNoOfDuplicates(s);
        countNoOfDuplicates1(s);
    }
}
