package sheetSolutions.string;
/*
Given a binary string str of length N, the task is to find the maximum count of consecutive substrings str
can be divided into such that all the substrings are balanced i.e. they have equal number of 0s and 1s. If it is
not possible to split str satisfying the conditions then print -1.
 */
public class splitBinaryString {
/*
This method takes a string as  input and traverses the string and counts the number of zeroes and ones . If they
are equal it increments the count and return count else it returns -1;
Time complexity:O(n),Space complexity:O(1)
 */
    static int split(String str){
        int count=0;
        int c0=0,c1=0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='0'){
                c0++;
            }
            else{
                c1++;
            }
            if(c0==c1){
                count++;
            }
        }
        if(count==0)
            return -1;
        else
            return count;
    }

    public static void main(String[] args) {
      String str = "0100110101";
        System.out.println(split(str));
    }
}
