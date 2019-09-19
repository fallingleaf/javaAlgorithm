package array;
import java.util.*;


// Google
// https://leetcode.com/problems/house-robber/
// Give array of integer, thief cannot steal two adjective houses
// f(k+1) = max(f[k-1] + nums[k], f[k])
// Base case: f(0) = 0, f(1) = nums[0]
// Optimize: dp only need 2 variables f[k] and f[k-1] to store
// use 2 vars: prev and curr
// => curr = max(prev + nums[k], curr) and prev = curr
public class HouseRobber {

    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        return dp[nums.length];
    }

    public int robImprove(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        int prev = 0, curr = 0, tmp;
        for(int i = 0; i < nums.length; i++) {
            tmp = curr;
            curr = Math.max(prev + nums[i], curr);
            prev = tmp;
        }

        return curr;
    }

    // https://leetcode.com/problems/house-robber-ii/
    // Each house is put in circle
    // Analyse: house at 0 and n - 1 cannot be robbed
    // so either choose to rob from 0 to n - 2 or 1 to n - 1
    public int helper(int[] nums, int left, int right) {
        if(left == right) {
            return nums[right];
        }

        int prev = 0, curr = 0, tmp = 0;
        for(int i = left; i <= right; i++) {
            tmp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = tmp;
        }
        return curr;
    }

    public int rob2(int nums) {
        if(nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        int max1 = helper(nums, 0, nums.length - 2);
        int max2 = helper(nums, 1, nums.length - 1);
        return Math.max(max1, max2);
    }


    // https://leetcode.com/problems/house-robber-iii/
    // Every house is formed binary tree
    // At root node, recursively call left and right
    // Each call return result with node root and without node root
    // with root: root.val + without left + without right
    // without root: max(left) + max(right)
    public int[] robTree(TreeNode node) {
        if(node == null) {
            return new int[] {0, 0};
        }

        int[] left = robTree(node.left);
        int[] right = robTree(node.right);

        int[] res = new int[] {0, 0};
        res[0] = node.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }

    public int rob3(TreeNode root) {
        int[] ans = robTree(root);
        return Math.max(ans[0], ans[1]);
    }
}
