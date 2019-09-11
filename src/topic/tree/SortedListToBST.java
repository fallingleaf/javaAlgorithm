package tree;
import java.util.*;


// Google
// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
// Use 2 slow and fast pointer to find mid node, use prev pointer to store
// previous pointer, detach left part and create root using mid node
// create right part using mid.next
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);

        // Detach left part
        if(prev != null) {
            prev.next = null;
            root.left = sortedListToBST(head);
        }

        root.right = sortedListToBST(slow.next);
        return root;
    }
}
