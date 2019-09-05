package linkedlist;
import java.util.*;

// Facebook, Google
// https://leetcode.com/problems/merge-k-sorted-lists/
// Merge k sorted list
// Use divide and conquer strategy, list array and merge 2 list recursively
public class MergeKSortedLists {
    private ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }

        int mid = left + (right - left)/2;
        ListNode leftHead = merge(lists, left, mid);
        ListNode rightHead = merge(lists, mid + 1, right);
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while(leftHead != null && rightHead != null) {
            if(leftHead.val < rightHead.val) {
                tmp.next = leftHead;
                leftHead = leftHead.next;
            } else {
                tmp.next = rightHead;
                rightHead = rightHead.next;
            }

            tmp = tmp.next;
        }

        ListNode remain = leftHead == null ? rightHead : leftHead;
        tmp.next = remain;
        head = head.next;
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }
}
