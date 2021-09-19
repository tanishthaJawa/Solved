package sheetSolutions.string;

import java.util.Arrays;

/*
This program checks if a string is a valid shuffle of two distinct strings.
 */
public class shuffleOfTwoStrings {
    // length of result string should be equal to sum of two strings
    static boolean checkLength(String s, String s1, String result) {
        return s1.length() + s.length() == result.length();
    }
    // this method converts the string to char array
    // sorts the char array
    // convert the char array to string and return it
    static String sortString(String x) {
        char[] s = x.toCharArray();
        Arrays.sort(s);
        return String.valueOf(s);
    }
// this method compares each character of the result with
    // individual characters of the first and second string

    static boolean shuffleCheck(String s, String s1, String result) {
        // sort each string to make comparison easier
        s = sortString(s);
        s1 = sortString(s1);
        result = sortString(result);
        int i = 0, j = 0, k = 0;
        while (k <= result.length()) {
            // check if first character of result matches
            // with first character of first string
            if (i < s.length() && result.charAt(k) == s.charAt(i))
                i++;
            else if (j < s1.length() && result.charAt(k) == s1.charAt(j))
                j++;
            else
                return false;
            k++;
        }
        // after accessing all characters of result
        // if either first or second has some characters left
        return i >= s.length() && j >= s1.length();
    }

    public static void main(String[] args) {
        String first = "XY";
        String second = "12";
        String[] results = {"1XY2", "Y1X2", "Y21XX"};

        // call the method to check if result string is
        // shuffle of the string first and second
        for (String result : results) {
            if (checkLength(first, second, result) && shuffleCheck(first, second, result)) {
                System.out.println(result + " is a valid shuffle of " + first + " and " + second);
            } else {
                System.out.println(result + " is not a valid shuffle of " + first + " and " + second);
            }
        }
    }
}
