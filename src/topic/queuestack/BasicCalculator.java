package queuestack;


// https://leetcode.com/submissions/detail/189997745/
// String contains: number +/-, calculate expression
// Solution: - recursive: if encounter number, add to it previous number,
// - Sign +/- add current number with sign into result
// - (: recursive call using current index or use stack to push current result
// and sign into stack
// - ) push sign from stack and +/- current result, add to previous result from stack
public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }else if(c == '+' || c == '-'){
                result += sign * number;
                number = 0;
                sign = c == '+' ? 1 : -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            }else if(c == ')'){
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if(number != 0) result += sign * number;
        return result;
    }


    // https://leetcode.com/problems/basic-calculator-ii/
    // calculator 2: contains only number and + - * /, no parentheses
    // Store previous number amd previous operation
    // If have new number, check previous op
    // if + or - just add previous number into result, set prev number = current
    // if * or - calculate prev */ curr, set prev to result
    public int calculate2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        s = s.trim();

        long prevNum = 0;
        int sum = 0;
        char prevOp = '+';

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(Character.isDigit(c)) {
                int val = c - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    val = val * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                if (prevOp == '+') {
                    sum += prevNum;
                    prevNum = val;
                } else if (prevOp == '-') {
                    sum += prevNum;
                    prevNum = -val;
                } else if (prevOp == '*') {
                    prevNum = prevNum * val;
                } else if (prevOp == '/') {
                    prevNum = prevNum/val;
                }
            } else {
                prevOp = c;
            }
        }

        sum += prevNum;
        return sum;
    }
}
