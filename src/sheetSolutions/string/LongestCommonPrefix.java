package sheetSolutions.string;

import java.util.Arrays;

public class LongestCommonPrefix {

    // Using Divide and Conquer
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    // Using Sorting
    public String longestCommonPrefix1(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length -1];
        int idx =0;
        while(idx<s1.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            }
            else{
                break;
            }
        }

        return s1.substring(0, idx);
    }
}
