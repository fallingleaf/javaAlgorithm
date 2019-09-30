package string;


// https://leetcode.com/problems/wildcard-matching/submissions/
// '?' match single character, '*' match empty or more characters
// 2 cases: s[i] = p[j] => dp[i][j] = dp[i-1][j-1]
// - p[j] = '*' =>
// - match multiple characters: dp[i-1][j]
// - match single characters: dp[i][j-1]
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            dp[0][i+1] = p.charAt(i) == '*' && dp[0][i];
        }

        for (int i = 1 ; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }

                else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
