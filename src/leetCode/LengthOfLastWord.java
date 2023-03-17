package leetCode;

/*
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
 */
public class LengthOfLastWord {
    // One solution is to split the string and to return the length of last string but below alogo is more faster
    public int lengthOfLastWord(String s) {
        // if string is of one length
        if (s.length() == 1 && s.charAt(0) == ' ') {
            return 1;
        }
        int length = s.length() - 1;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == ' ') {
                if (length - i != 0 && s.charAt(i + 1) != ' ') { // if space is not the last character and next character to space is a string
                    return length - i ;
                } else {
                    length = i - 1;
                }
            }
        }
        if (s.charAt(0) != ' ') {
            return length + 1;
        }
        return 0;
    }
}
