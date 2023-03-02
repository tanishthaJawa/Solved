package leetCode;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            int number = target - nums[idx];
            if (map.containsKey(number)) {
                return new int[]{map.get(number), idx};
            }
            map.put(nums[idx], idx);
        }
        return new int[]{};
    }
}
