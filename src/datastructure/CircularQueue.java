package datastructure;
import java.util.*;


// https://leetcode.com/problems/design-circular-queue/
// Use 2 pointers front and rear
class CircularQueue {

    private int arr[];
    private int front = 0;
    private int rear = -1;
    private int len;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        arr = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()) {
            rear = (rear + 1) % arr.length;
            arr[rear] = value;
            len += 1;
            return true;
        }
        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()) {
            front = (front + 1) % arr.length;
            len -= 1;
            return true;
        }
        return false;

    }

    /** Get the front item from the queue. */
    public int Front() {
        if(!isEmpty()) {
            return arr[front];
        }

        return -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(!isEmpty()) {
            return arr[rear];
        }
        return -1;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return len == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return len == arr.length;
    }
}
