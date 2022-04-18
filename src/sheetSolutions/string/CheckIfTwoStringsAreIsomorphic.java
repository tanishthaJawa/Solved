package sheetSolutions.string;
/*
Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.
Two strings str1 and str2 are called isomorphic if there is a one to one mapping possible for every character of str1 to
every character of str2 while preserving the order.
Note: All occurrences of every character in ‘str1’ should map to the same character in ‘str2’

Example 1:

Input:
str1 = aab
str2 = xxy
Output: 1
Explanation: There are two different
characters in aab and xxy, i.e a and b
with frequency 2and 1 respectively.
 */
public class CheckIfTwoStringsAreIsomorphic {
  static boolean checkIsomorphism(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    int[] countChars1 = new int[26];
    int[] countChars2 = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      countChars1[s1.charAt(i) - 'a']++; // frequency for each char
      countChars2[s2.charAt(i) - 'a']++; // frequency for each char for string 2
    }
    for (int i = 0; i < s1.length(); i++) {
      if (countChars1[s1.charAt(i) - 'a']
          != countChars2[s2.charAt(i) - 'a']) { // if freq at each index is different from
        // then return false
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s1 = "aba";
    String s2 = "xyy";
    System.out.println(checkIsomorphism(s1, s2));
  }
}
