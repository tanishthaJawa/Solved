package sheetSolutions.string;

/*
This program aims to find longest palindrome substring in a string.In case of clash it returns first substring that
occurs in string.
 */
public class longestPalindromeSubstring {

    private String result;
    private int lengthOfPalindrome;

    /*
     Brute Force.
Approach: The simple approach is to check each substring whether the substring is a palindrome or not.
 To do this first, run three nested loops, the outer two loops pick all substrings one by one by fixing the
 corner characters, the inner loop checks whether the picked substring is palindrome or not.
     */
    static int longestPalindrome(String str) {
        //O(n3) space complexity:O(1)
        int maxLength = 1, start = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;
                for (int k = 0; k < (j - i + 1) / 2; k++) {//check palindrome
                    if (str.charAt(i + k) != str.charAt(j - k)) {
                        flag = 0;
                        break;
                    }
                }
                if (flag != 0 && (j - i + 1) > maxLength) {//palindrome
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        printSubString(str, start, start + maxLength - 1);
        return maxLength;
    }

    /*
    this approach is about expanding wings towards left and towards right. complexity: o(n2)
     */

    public String longestPalindrome3(String s) {

        if (s.length() < 2) {
            return s;
        }

        for (int index = 0; index < s.length() - 1; index++) {
            palindromeSubstring(s, index, index);
            palindromeSubstring(s, index, index + 1);
        }
        return result;
    }

    private void palindromeSubstring(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (lengthOfPalindrome < right - left + 1) {
                lengthOfPalindrome = right - left + 1;
                result = s.substring(left, right + 1);
            }
            left--;
            right++;
        }

    }

    /*
    this approach uses dynamic programming. The idea is to create a boolean table that contains a true value if
    char at i and j matches .
     */
    static int longestPalindrome1(String str) {
        int n = str.length(), start = 0, maxLength = 0;
        boolean[][] table = new boolean[n][n];
        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }
        // check for sub-string of length 2.
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        for (int k = 3; k <= n; k++) {

        }
        return maxLength;
    }

    static void printSubString(String str, int low, int high) {
        for (int i = low; i <= high; i++) {
            System.out.print(str.charAt(i));
        }
        System.out.println();

    }

    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        int l = longestPalindrome(str);
        System.out.println(l);
    }
}
