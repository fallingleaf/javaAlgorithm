package dynamicprogramming;
import java.util.*;


// Google HARD
// https://leetcode.com/problems/distinct-subsequences/
// Give two strings S and T, count number of subsequences in S = T
// S(0, i) and T(0, j) if S[i] = T[j] => dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
// if S[i] != T[j] => dp[i][j] = dp[i-1][j]
// Base case: dp[i][0] = 1 (empty string T), dp[0][j] = 0 j != 0
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if(t == null) {
            return 1;
        }

        if(s == null) {
            return 0;
        }

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }

}
