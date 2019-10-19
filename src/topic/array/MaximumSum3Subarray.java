package array;


// HARD: Facebook
// https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
// Find maximum of 3 non overlap sub arrays size K
// Solution: Find sum of size K at each index
// Find the largest running sum from left to right and right to left
// middle sub array j value will be at index from K to len - 2K
// calculate max: W(left(j-k)) + W(j) + W(right(j+K))
public class MaximumSum3Subarray {
    public int[] maxSumOfThreeSubarrays(int[] nums, int K) {
        //W is an array of sums of windows
        int[] W = new int[nums.length - K + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= K) sum -= nums[i-K];
            if (i >= K-1) W[i-K+1] = sum;
        }

        int[] left = new int[W.length];
        int best = 0;
        for (int i = 0; i < W.length; i++) {
            if (W[i] > W[best]) best = i;
            left[i] = best;
        }

        int[] right = new int[W.length];
        best = W.length - 1;
        for (int i = W.length - 1; i >= 0; i--) {
            if (W[i] >= W[best]) best = i;
            right[i] = best;
        }

        int[] ans = new int[]{-1, -1, -1};
        for (int j = K; j < W.length - K; j++) {
            int i = left[j - K], k = right[j + K];
            if (ans[0] == -1 || W[i] + W[j] + W[k] >
                    W[ans[0]] + W[ans[1]] + W[ans[2]]) {

                ans[0] = i;
                ans[1] = j;
                ans[2] = k;
            }
        }
        return ans;
    }
}
