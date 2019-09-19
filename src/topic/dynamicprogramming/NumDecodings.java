package dynamicprogramming;
import java.util.*;


// https://leetcode.com/problems/decode-ways/description/
// Number ways of decoding integer to alphabet 'A' -> 1,
// 'B' -> 2, ..., 'Z' -> 26
// Dynamic programing: x(n) = x(n-1) + x(n-2)
public class NumDecodings {
    public int numDecodings(String s) {
        if(s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[0] = 1;
        char curr, prev;
        int p, q;

        for(int i = 1; i < s.length(); i++) {
            curr = s.charAt(i);
            prev = s.charAt(i-1);

            p = curr > '0' ? dp[i-1] : 0;
            q = 0;

            if(prev == '1' || (prev == '2' && curr <= '6')) {
                q = i >= 2 ? dp[i-2] : 1;
            }

            dp[i] = p + q;
            if(dp[i] == 0) {
                return 0;
            }
        }

        return dp[s.length() - 1];
    }
}
