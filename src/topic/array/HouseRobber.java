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

    public static void main(String[] args) {
        HouseRobber hb = new HouseRobber();
        int res = hb.rob(new int[] {1, 4, 3, 5, 11});
        System.out.println("House rob..." + res);
    }
}
