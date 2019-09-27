package bfs;
import java.util.*;


// HARD: Facebook
// Give a string with parentheses, remove invalid parentheses
// String may contains other char
// Count number of open and close char, if close > open, then remove random none 2 continuous
// DFS: from next position where close > open and position where we remove close bracket
// How about open > close, reverse string and do the same
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, '(', ')');
        return ans;
    }

    public void remove(String s, List<String> ans, int lastInvalid, int lastRemove, char open, char close) {
        int count = 0;

        for (int i = lastInvalid; i < s.length(); i++) {
            if (s.charAt(i) == open) {
                count ++;
            }

            if (s.charAt(i) == close) {
                count --;
            }

            // Invalid position
            if(count < 0) {
                // Remove close bracket from last remove position to avoid duplicate
                for (int j = lastRemove; j <= i; j++) {
                    if (s.charAt(j) == close && (j == lastRemove || s.charAt(j - 1) != close)) {
                        remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, open, close);
                    }
                }
                return;
            }
        }

        String reversed = new StringBuilder(s).reverse().toString();
        // Finished left to right, reverse string and do the same
        if (open == '(')
            remove(reversed, ans, 0, 0, ')', '(');
        // Finished right to left, add to result
        else
            ans.add(reversed);
    }
}
