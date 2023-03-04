package sheetSolutions.array;

/*
https://leetcode.com/problems/trapping-rain-water/solutions/1374608/c-java-python-maxleft-maxright-so-far-with-picture-o-1-space-clean-concise/

A ith bar can trap the water if and only if there exists a higher bar to the left and a higher bar to the right of ith bar.
To calculate how much amount of water the ith bar can trap, we need to look at the maximum height of the left bar and the maximum height of the right bar, then
The water level can be formed at ith bar is: waterLevel = min(maxLeft[i], maxRight[i])
If waterLevel >= height[i] then ith bar can trap waterLevel - height[i] amount of water.

We start with maxLeft = height[0], maxRight = height[n-1], using 2 pointers left point to the next bar on the left side, right point to the next bar on the right side.
How to decide to move left or move right?
If maxLeft < maxRight, it means the water level is based on the left side (the left bar is smaller) then move left side:
If height[left] > maxLeft then there is no trap water, we update maxLeft by maxLeft = height[left].
Else if height[left] < maxLeft then it can trap an amount of water, which is maxLeft - height[left].
Move left by left += 1
Else if maxLeft > maxRight, it means the water level is based on the right side (the right bar is smaller) then move right side:
If height[right] > maxRight then there is no trap water, we update maxRight by maxRight = height[right].
Else if height[right] < maxRight then it can trap an amount of water, which is maxRight - height[right].
Move right by right -= 1.
 */
public class TrappingRainWaterProblem {
    public int trap(int[] height) {
        if (height.length < 2) return 0;
        int maxLeft = height[0], maxRight = height[height.length - 1];
        int left = 1, right = height.length - 2, trappedWater = 0;
        while (left <= right) {
            if (maxLeft < maxRight) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    trappedWater += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    trappedWater += maxRight - height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }
}
