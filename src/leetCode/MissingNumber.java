package leetCode;
/*
In this problem we are given an array nums containing n distinct numbers in the range [0, n], return the only
number in the range that is missing from the array.
 */
public class MissingNumber {
    // the idea is to sum the numbers in array and subtract from sum of all natural numbers.
    public static int missingNumber(int[] nums) {
        int n= nums.length,sum=0,x;
        for (int num : nums) {
            sum = sum + num;
        }
        x=(n*(n+1))/2-sum;
        return x;
    }

    public static void main(String[] args) {
        int [] ar= {4,2,1,0};
        System.out.println(missingNumber(ar));
    }
}
