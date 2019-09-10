package tree;
import java.util.*;


// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// Flatten tree in order traversal
// Recursive flatten left and right, return last node of left to connect to
// first node of right
// Iteractive approach: use stack to store right nodes, set right = left,
// set left to null, if cannot process more, pop from stack
public class FlattenBinaryTree {
    private TreeNode helper(TreeNode node) {
        if(node == null) {
            return node;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;

        if(left != null) {
            TreeNode lastLeft = helper(left);
            node.right = left;
            node.left = null;
            node = lastLeft;
        }

        if(right != null) {
            TreeNode lastRight = helper(right);
            node.right = right;
            node = lastRight;
        }

        return node;
    }

    public void flatten(TreeNode root) {
        helper(root);
    }

    public void flattenIteractive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(node != null) {
            if(node.right != null) {
                stack.push(node.right);
            }

            if(node.left != null) {
                node.right = node.left;
                node.left = null;
            } else if(!stack.isEmpty()) {
                TreeNode tmp = stack.pop();
                node.right = tmp;
            }
            node = node.right;
        }
    }
}
