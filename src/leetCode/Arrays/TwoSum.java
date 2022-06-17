package leetCode.Arrays;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int num;
        HashMap<Integer,Integer> hs = new HashMap<>();
        int[] arr = new int[2];
        for(int i=0;i<nums.length;i++){
            num=target-nums[i];
            if(hs.containsKey(num)){
                arr[0]=hs.get(num);
                arr[1]=i;
            }
            else{
                hs.put(nums[i],i);
            }
        }
        return arr;
    }
}
