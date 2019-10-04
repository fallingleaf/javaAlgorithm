package queuestack;
import java.util.*;


/*
HARD
Longest valid parenthesis
https://leetcode.com/problems/longest-valid-parentheses/
- Solution: consider simple case )()(),
- if char ( length = 0, if char ) check previous
char, if it is (, then there's match, dp[i] = 2 + dp[i-2]
otherwise if there's valid sequence dp[i-1] > 0
- check char before valid sequence i - dp[i-1] - 1, if match (
then dp[i] = 2 + dp[i-1] + dp[prev - 1]
- Solution2: same as valid parentheses, store index together with char into stack
if ) pop from stack, and calculate length current i - prev index + 1
*/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<int[]> stack = new Stack<>();
        int result = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == ')') {
                if(!stack.isEmpty() && stack.peek()[0] == 0){
                    stack.pop();
                    result = Math.max(result, i- (stack.isEmpty() ? -1 : stack.peek()[1]));
                } else {
                    stack.push(new int[] {1, i});
                }
            } else {
                stack.push(new int[] {0, i});
            }
        }

        return result;
    }


    public int longestValidParentheses2(String s) {
        int n = s.length();

        int[] dp = new int[n];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                if(i == 0) continue;

                if(s.charAt(i-1) == '(') {
                    dp[i] = 2 + (i >= 2 ? dp[i-2] : 0);
                } else if(dp[i-1] > 0) {
                    int prev = i - dp[i-1] - 1;
                    if(prev >= 0 && s.charAt(prev) == '(') {
                        dp[i] = 2 + dp[i-1] + (prev >= 1 ? dp[prev - 1] : 0);
                    }
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
