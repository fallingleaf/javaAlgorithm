package dynamicprogramming;
import java.util.*;


// https://leetcode.com/problems/palindrome-partitioning
// Find all palidrome partition for a string
// Solution: DFS for each positon check if it's palidrome, add to res and continue
// Optimize use matrix to pre-check if substring i, j is palidrome and use dfs
// similar to wordbreak:
public class PalindromePartition {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int len = 1; len <= n; len++) {
            for(int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if(s.charAt(i) == s.charAt(j)) {
                    if(j <= i + 1 || dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();

        helper(ans, dp, s, 0, new ArrayList<>());
        return ans;
    }

    private void helper(List<List<String>> ans, boolean[][] dp, String s, int pos, ArrayList<String> curr) {
        if(pos >= s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                curr.add(s.substring(pos, i+1));
                helper(ans, dp, s, i+1, curr);
                curr.remove(curr.size() - 1);
            }
        }

    }
}
