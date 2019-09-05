package stack;
import java.util.*;


// Use current stack implementation, keep track of min value by pushing value - min
// when pop or peek, compare value < 0m if then update min = min - value
// Another implementation: use LinkedListNode with: value, min and next
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private int min;

    public void push(int value) {
        if(stack.isEmpty()) {
            stack.push(0);
            min = value;
        } else {
            stack.push(value - min);
            if(value < min) {
                min = value;
            }
        }
    }

    public int pop() {
        if(stack.isEmpty()) {
            return -1;
        }

        int value = stack.pop();
        int tmp = min;

        if(value < 0) {
            min = min - value;
            return tmp;
        }

        if(stack.isEmpty()) {
            min = -1;
        }
        return value + tmp;
    }

    public int peek() {
        if(stack.isEmpty()) {
            return -1;
        }

        int value = stack.peek();
        if(value < 0) {
            return min;
        }
        return value + min;
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(10);
        ms.push(3);
        ms.push(5);
        ms.push(1);
        System.out.println("curr min: " + ms.getMin());
        System.out.println("pop: " + ms.pop());
        System.out.println("curr min: " + ms.getMin());
        System.out.println("pop: " + ms.pop());
        System.out.println("pop: " + ms.pop());
        System.out.println("curr min: " + ms.getMin());
        System.out.println("pop: " + ms.pop());
        System.out.println("curr min: " + ms.getMin());
    }
}
