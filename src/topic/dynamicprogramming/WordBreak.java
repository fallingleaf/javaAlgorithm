package dynamicprogramming;
import java.util.*;


// Google
// https://leetcode.com/problems/word-break/
// Find if string can be broken down to list of words in word dictionary
// At each position i, check if it can break into a word from list
// and position i + len(word) can break, dp[i] = true
// if substring i to i + len(word) == word, init dp[0] = true
// Optimize: if word list is too big, turn word list into hashset
// 2 loops: j = i + 1 -> length, if exists in word list, set dp[j] = true
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i = 0; i < n; i++) {
            if(!dp[i]) {
                continue;
            }

            for(String word: wordDict) {
                int len = word.length();
                int end = i + len;

                if(end > n) {
                    continue;
                }

                if(s.substring(i, end).equals(word)) {
                    dp[end] = true;
                }
            }
        }

        return dp[n];
    }

    // Return a list of string break
    // Store break string in a list and use dfs to get result
    public List<String> wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        List<String>[] dp = new ArrayList[n+1];
        dp[0] = new ArrayList<String>();

        for(int i = 0; i < n; i++) {
            if(dp[i] == null) {
                continue;
            }

            for(String word: wordDict) {
                int end = i + word.length();
                if(end > n) {
                    continue;
                }

                if(s.substring(i, end).equals(word)) {
                    if(dp[end] == null) {
                        dp[end] = new ArrayList<String>();
                    }

                    dp[end].add(word);
                }
            }
        }

        if(dp[s.length()] == null) {
            return ans;
        }

        List<String> curr = new ArrayList<>();
        dfs(dp, s.length(), ans, curr);
        return ans;
    }

    private void dfs(List<String>[] dp, int end, List<String> ans, List<String> curr) {
        if(end <= 0) {
            String tmp = "";
            for(String word: curr) {
                tmp += " " + word;
            }
            ans.add(tmp);
            return;
        }

        for(String word: dp[end]) {
            curr.add(word);
            dfs(dp, end - word.length(), ans, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
