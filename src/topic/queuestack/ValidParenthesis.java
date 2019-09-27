package queuestack;
import java.util.*;


public class ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<> ();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                if(stack.isEmpty() || map.get(c) != stack.pop()) {
                    return false;
                }

            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    // https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
    // Given string with parentheses return number of add to make it valid
    // Use stack to push parentheses, remain parentheses in stack will be result
    // Optimize: count number of left and right parentheses to add
    // if ( increase right, if ) decrese right (if right > 0), otherwise increase left
    public int minAddToMakeValid(String S) {
        int left = 0, right = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                right++;
            } else if (right > 0) {
                right--;
            } else {
                left++;
            }
        }
        return left + right;
    }

    public int minAddToMakeValid2(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
            }

            stack.push(S.charAt(i));
        }

        return stack.size();
    }
}
