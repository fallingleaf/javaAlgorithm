package tree;
import java.util.*;


// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
// Use 3 pointers, parent pointer, head pointer for current head, curr running
// pointer
public class PopulateNextRight {
    public Node connect(Node root) {
        Node parent = root;
        Node prev = null;
        Node curr = null;
        Node head = null;

        while(parent != null) {
            prev = parent;

            while(prev != null) {
                if(prev.left != null) {
                    if(head == null) {
                        head = prev.left;
                        curr = prev.left;
                    } else {
                        curr.next = prev.left;
                        curr = curr.next;
                    }
                }

                if(prev.right != null) {
                    if(head == null) {
                        head = prev.right;
                        curr = prev.right;
                    } else {
                        curr.next = prev.right;
                        curr = curr.next;
                    }
                }

                prev = prev.next;
            }
            // Move to next level
            parent = head;
            head = null;
        }

        return root;
    }
}
