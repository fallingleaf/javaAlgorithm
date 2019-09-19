package dynamicprogramming;
import java.util.*;

// Give a number find minimum of square add up to number
// e.g 13 = 4 + 9
// Dynamic: dp[i] = 1 + dp[i - j*j] for j = 1...sqrt(i)
public class PerfectSquare {
    public int numSquares(int n) {
        if(n <= 0) {
            return 0;
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j*j]);
            }
        }

        return dp[n];
    }
}
