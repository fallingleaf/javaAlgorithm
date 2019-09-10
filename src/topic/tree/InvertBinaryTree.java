package tree;
import java.util.*;


// https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left)
        TreeNode right = invertTree(root.right)

        root.right = left;
        root.left = right;
        return root;
    }
}
