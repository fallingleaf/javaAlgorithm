package generic;
import java.util.*;


// Check if there's subset of nums can sum to K
// S = {s1, s2, ..., si} => dp(i, k)
// at i we can choose to add si or not so dp(i, k) = dp(i - 1, k)
// or dp(i - 1, k - s(i))
// base case: dp(0, k) = true if s[0] == k; dp(n, 0) = true because empty
// Clarify if k = 0
// Bug: k < s(i) will throw error, fixed it
public class SubsetSum {

    public boolean canSumToK(int[] nums, int k) {
        if(k == 0) {
            return true;
        }

        int n = nums.length;

        if(n == 0) {
            return false;
        }

        boolean[][] dp = new boolean[n][k+1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= k; j++) {
                if(i == 0) {
                    dp[i][j] = nums[i] == j;
                } else if(j == 0) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i-1][j];

                    if(j >= nums[i]) {
                        dp[i][j] |= dp[i-1][j - nums[i]];
                    }
                }

            }
        }

        return dp[n-1][k];
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] nums = new int[] {2, 7, 3, 8, 0, 12, 6};
        boolean res = ss.canSumToK(nums, 40);
        System.out.println("result is: " + res);
    }
}
