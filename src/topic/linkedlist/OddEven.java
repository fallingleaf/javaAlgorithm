package linkedlist;
import java.util.*;


// https://leetcode.com/problems/odd-even-linked-list/
// Give a linkedlist group odd nodes followed by even nodes
// 1->2->3->4->5 => 1->3->5->2->4
// Use 2 pointers p1 = head and p2 = head.next
// Move 2 pointers along the list, store first even node to concat later
// 1 -> 3 -> 5, 2 -> 4 the concat 5 -> 2
public class OddEven {
    public ListNode oddEventList(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode connectNode = p2;

        while(p1 != null && p2 != null && p2.next != null) {
            p1.next = p2.next;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p1.next;
        }

        p1.next = connectNode;
        return head;
    }
}
