package datastructure;

import java.util.*;

public class MyQueue {
    Stack<Integer> input, output;

    /** Initialize your data structure here. */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    public void transfer(Stack<Integer>in, Stack<Integer>out) {
        int val;
        while(!in.empty()) {
            val = in.pop();
            out.push(val);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!output.empty()) {
            return output.pop();
        }

        transfer(input, output);

        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!output.empty()) {
            return output.peek();
        }
        transfer(input, output);
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty() && output.empty();
    }
}
