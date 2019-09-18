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
}
