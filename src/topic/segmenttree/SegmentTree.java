package segmenttree;
import java.util.*;


// Segment tree store start, end and total sum for that sumRange
// left node: range from start, mid
// right node: range from mid + 1, end
// Create full tree by recursively create left and right tree
// Update by index: find left or right node to update node value and total
// Query: recursively find sum of left and right
class Node {
    int start;
    int end;
    int sum;
    Node left;
    Node right;

    Node(int _start, int _end) {
        start = _start;
        end = _end;
    }
}


public class SegmentTree {
    private Node root;

    public SegmentTree(int[] nums) {
        root = initTree(nums, 0, nums.length - 1);
    }

    private Node initTree(int[] nums, int start, int end) {
        Node node = new Node(start, end);

        if(start == end) {
            node.sum = nums[start];
            return node;
        }

        int mid = (start + end) / 2;

        node.left = initTree(nums, start, mid);
        node.right = initTree(nums, mid + 1, end);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }

    // Sum from start to end
    private int query(Node node, int start, int end) {
        if(node.start == start && node.end == end) {
            return node.sum;
        }

        int mid = (node.start + node.end) / 2;
        if(end <= mid) {
            return query(node.left, start, end);
        } else if(start > mid) {
            return query(node.right, start, end);
        } else {
            return query(node.left, start, mid) + query(node.right, mid + 1, end);
        }
    }

    // Update at index with value
    private void update(Node node, int index, int value) {
        if(node == null) {
            return;
        }

        if(node.start == index && node.end == index) {
            node.sum = value;
            return;
        }

        int mid = (node.start + node.end) / 2;
        if(index <= mid) {
            update(node.left, index, value);
        } else {
            update(node.right, index, value);
        }

        node.sum = node.left.sum + node.right.sum;
    }

    // public method
    public int sum(int start, int end) {
        return query(root, start, end);
    }

    public void updateAtIndex(int index, int value) {
        update(root, index, value);
    }

}
