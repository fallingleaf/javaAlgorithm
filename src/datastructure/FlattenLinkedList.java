package datastructure;


// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};


// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/submissions/
class FlattenLinkedList {
    public Node flatten(Node head) {
        Node curr = head;
        while(curr != null) {
            if(curr.child != null) {
                Node child = curr.child;
                Node tmp = child;
                Node next = curr.next;

                while(tmp.next != null) {
                    tmp = tmp.next;
                }

                tmp.next = next;
                if(next != null) {
                    next.prev = tmp;
                }

                curr.next = child;
                curr.child = null;
                child.prev = curr;
            }

            curr = curr.next;
        }

        return head;

    }
}
