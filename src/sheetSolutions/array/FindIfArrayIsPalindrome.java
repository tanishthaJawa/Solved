package sheetSolutions.array;

/*
Given a Integer array A[] of n elements. Your task is to complete the function PalinArray. Which will return 1 if all the elements
of the Array are palindrome otherwise it will return 0.
 */
public class FindIfArrayIsPalindrome {
    // reversed each element and compare it with existing element. If all elements are palindrome then array is palindrome.
    public static int palindromeArray(int[] a, int n) {
        // add code here.
        for (int i = 0; i < n; i++) {
            if (isPalin(a[i]) != a[i]) {
                return 0;
            }
        }
        return 1;
    }

    static int isPalin(int n) {
        int num = 0, r;
        while (n != 0) {
            r = n % 10;
            num = num * 10 + r;
            n = n / 10;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] arr = {111, 222, 333, 444};
        System.out.println(palindromeArray(arr, 4));
    }
}
