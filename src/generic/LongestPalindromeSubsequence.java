package generic;
import java.util.*;


public class LongestPanlindromeSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        if(n <= 1) {
            return n;
        }

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for(int l = 2; l <= n; l++) {
            for(int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];

    }
}
