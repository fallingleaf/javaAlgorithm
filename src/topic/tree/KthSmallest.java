package tree;
import java.util.*;


// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// Find k smallest value in binary tree
// Use stack to store left node, every time pop a node, decrease k, if k = 0
// return value, after pop node, push right node to stack
// Runtime and space O(H + k) where H is height of tree
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                k --;
                if(k == 0) {
                    return p.val;
                }
                p = p.right;
            }
        }

        return -1;
    }
}
