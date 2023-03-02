package leetCode;

import java.util.HashSet;

/*
Given a string s, find the length of the longest substring without repeating characters.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int longestSubstringLength = 0;
        HashSet<Character> substrings = new HashSet<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (substrings.contains(s.charAt(right))) {
                substrings.remove(s.charAt(left));
                left++;
            }
            substrings.add(s.charAt(right));
            longestSubstringLength = Math.max(longestSubstringLength, right - left + 1);

        }
        return longestSubstringLength;
    }
}
