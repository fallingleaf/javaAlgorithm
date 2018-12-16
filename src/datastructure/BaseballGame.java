package datastructure;
import java.util.*;


public class BaseballGame {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<> ();

        int ans = 0, top, curr;

        for(String op: ops) {
            if(op.equals("+")) {
                top = stack.pop();
                curr = top + stack.peek();
                stack.push(top);
                stack.push(curr);
            } else if(op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if(op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        for(int score: stack) {
            ans += score;
        }

        return ans;
    }

    public static void main(String[] args) {
        BaseballGame baseBall = new BaseballGame();
        System.out.println("Total score...." + baseBall.calPoints(new String[] {"5", "2", "C", "D", "+"}));
    }
}
