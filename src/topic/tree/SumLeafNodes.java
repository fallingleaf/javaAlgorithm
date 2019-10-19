package tree;

import java.util.*;

public class SumLeafNodes {
    int ans = 0;

    int sum(TreeNode node) {
        if(node == null) {
            return 0;
        }

        if(node.left == null && node.right == null) {
            ans += node.val;
        }

        sum(node.left);
        sum(node.right);
    }

    public int sumLeaves(TreeNode root) {
        sum(root);
        return ans;
    }

    // If node has link to parent, devise iteractive solution space 1
    // Same as post order transversal, use prev pointer to keep track of processed node
    // if current pointer is left or right child, process down, leaf node move up
    // if prev is left child of current, move right
    // if prev is right child or current, move up
    public int sumWithParent(TreeNode node) {
        TreeNode prev = null;
        TreeNode curr = root;
        int ans = 0;

        while(curr != null) {
            // Process down
            if(prev == null || prev.left == curr || prev.right == curr) {
                if(curr.left != null) {
                    prev = curr;
                    curr = curr.left;
                } else if(curr.right !== null) {
                    prev = curr;
                    curr = curr.right;
                }
                else {
                    ans += curr.val;
                    // Leaf node, move up
                    TreeNode tmp = curr;
                    curr = prev;
                    prev = tmp;
                }
            }
            // Already process left part, move to right part
            else if(curr.left == prev) {
                prev = curr;
                curr = curr.right;
            }
            // Already process right part, move up
            else if(curr.right == prev) {
                prev = curr;
                curr = curr.parent;
            }
        }

        return ans;
    }

}
