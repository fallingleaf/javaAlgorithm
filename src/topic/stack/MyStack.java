package stack;
import java.util.*;


// Implement Stack using 2 queues
// When push: push into empty queue, remove all nodes from other queue and
// push to empty queue
// e.g queue1: [10] queue2: [] -> push 20 => queue2 [20] then remove from queue1
// queue2 => [20, 10]
public class MyStack {
    private Queue<Integer> q1, q2;
    private int size;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if(q1.isEmpty()) {
            q1.offer(x);

            while(!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
        } else {
            q2.offer(x);
            while(!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
        }

        size ++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int pop() {
        if(isEmpty()) {
            return -1;
        }

        if(!q1.isEmpty()) {
            return q1.poll();
        } else {
            return q2.poll();
        }

        size --;
    }

    public int peek() {
        if(isEmpty()) {
            return -1;
        }

        if(!q1.isEmpty()) {
            return q1.peek();
        } else {
            return q2.peek();
        }
    }

    public int size() {
        return size;
    }

}
