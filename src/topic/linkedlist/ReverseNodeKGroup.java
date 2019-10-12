package linkedlist;
import java.util.*;


// HARD: Facebook
// https://leetcode.com/problems/reverse-nodes-in-k-group/
// Reverse every group of k nodes from head
// Find last node in k group, detach it, reverse from last node
// After reverse, connect previous group last node to this group
// Update head to first reversed group
public class ReverseNodeKGroup {
    private void reverseList(ListNode head) {
        ListNode prev = null;
        ListNode tmp = null;
        ListNode curr = head;
        while(curr != null) {
            tmp = curr.next;
            curr.next = prev;
            // Move to next node
            prev = curr;
            curr = tmp;
        }

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode currNode = head;
        ListNode groupLastNode = null;
        ListNode groupHeadNode = null;
        ListNode prevGroupNode = null;

        while(currNode != null) {
            groupLastNode = currNode;
            groupHeadNode = currNode;

            // Find last node in group
            int count = 1;
            while(count < k && groupLastNode.next != null) {
                groupLastNode = groupLastNode.next;
                count ++;
            }

            // Cannot form group k nodes, keep it
            if(count < k) {
                if(prevGroupNode != null) {
                    prevGroupNode.next = groupHeadNode;
                }
                break;
            }
            // Store next group first node
            currNode = groupLastNode.next;
            // Detach group last node
            groupLastNode.next = null;

            // Reverse current group
            reverseList(groupHeadNode);

            if(prevGroupNode == null) {
                head = groupLastNode;
            } else {
                // Connect previous group to current group
                prevGroupNode.next = groupLastNode;
            }

            prevGroupNode = groupHeadNode;
        }

        return head;
    }
}
