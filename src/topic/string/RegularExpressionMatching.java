package string;
import java.util.*;


/* Facebook
- Regex pattern matching:
- https://leetcode.com/problems/regular-expression-matching/description/
- '.' match single character, '*' match empty or more preceding characters

DP solutions:
- s[i] = p[j] or p[j] = '.': dp[i][j] = dp[i-1][j-1]
- p[j] = '*': 2 cases
- Case 1: not equal p[j-1] != s[i] && p[j-1] != .:
    empty match: dp[i][j] = dp[i][j-1]
- Case 2: equal:
    dp[i][j] = dp[i-1][j] (match multiple)
    or dp[i][j-1] (single match)
    or dp[i][j-2] (empty)
*/
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for (int i = 2; i <= p.length(); i++) {
            dp[0][i] = p.charAt(i-1) == '*' && dp[0][i-2];
        }

        for (int i = 1 ; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }

                else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i][j-2];
                    // Compare prev char with current char in S: e.g a* = a
                    if (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.') {
                        dp[i][j] |= dp[i-1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
