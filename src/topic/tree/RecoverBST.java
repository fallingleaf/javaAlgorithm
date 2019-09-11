package tree;
import java.util.*;


// https://leetcode.com/problems/recover-binary-search-tree/
// Inorder transver binary tree find 2 nodes that need to swap
// e.g 6 3 4 5 2 => swap 6, 2
// use pointer, prev, first and second to track these nodes
// runtime O(N), space O(logN)
public class RecoverBST {
    TreeNode first = null, second = null;
    TreeNode prev = null;

    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        // Process node at mid
        // 6 > 3 => first element = prev
        if(first == null && prev != null && prev.val >= root.val) {
            first = prev;
        }

        // 5 > 2 => second element = current
        if(first != null && prev.val >= root.val) {
            second = root;
        }

        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);

        // swap first and second element
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
