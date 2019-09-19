package dynamicprogramming;
import java.util.*;


// https://leetcode.com/problems/longest-increasing-subsequence/solution/
// Dynamic: nums[i] > nums[j] => dp[i] = max(dp[i], dp[j] + 1) => update ans
// Second approach use binary search:
// Store encounter number in sorted order by finding its index and replace it
// result is len of final array
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
