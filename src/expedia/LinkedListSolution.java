package expedia;
import java.util.*;


// Use 2 nodes fast and slow to detect cycle, if 2 nodes equals then we have
// a cycle
// Math: T number of nodes outside cycle, k number of step made inside cycle
// T + K = 2T + 2K mode C
// T + K = 0 mode C
public class LinkedListSolution {
    class LinkedListNode {
        int value;
        LinkedListNode next;

        public LinkedListNode(int val) {
            value = val;
        }
    }

    public LinkedListNode detectCycleNode(LinkedListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        LinkedListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Found cycle, if we made T more step, slow pointer finishes cycle
            // where T is number of nodes outside cycles
            if(slow == fast) {
                fast = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    // Find node make the loop and set next pointer to null
    private void removeLoop(LinkedListNode p, LinkedListNode q) {
        while(p != q.next) {
            p = p.next;
            q = q.next;
        }

        q.next = null;
    }
}
