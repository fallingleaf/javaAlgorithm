package dynamicprogramming;
import java.util.*;


// https://leetcode.com/problems/maximum-subarray/
// f(n) = { f(n-1) > 0 ? f(n-1) : 0 } + nums[n]
// f(0) = nums[0]
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
