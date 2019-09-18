package dynamicprogramming;
import java.util.*;


// https://leetcode.com/problems/maximum-product-subarray/
// Find max product of sub array contains negative and positive integer
// Use 2 vars max and min to store local max and min
// if number < 0, if max * num will create new min, min * num create new max
public class MaximumSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];
        int tmp;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <= 0) {
                tmp = max;
                max = Math.max(nums[i], min * nums[i]);
                min = Math.min(nums[i], tmp * nums[i]);
            } else {
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
            }

            ans = Math.max(ans, max);
        }
        return ans;
    }
}
