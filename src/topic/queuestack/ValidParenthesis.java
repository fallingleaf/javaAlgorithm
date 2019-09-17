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
}
