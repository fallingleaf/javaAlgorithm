package tree;
import java.util.*;


// Google
// https://leetcode.com/problems/longest-univalue-path/submissions/
// Find longest path in bst with same value
// Recursive call to left and right child to calculate length
// compare left value to node, if equal -> left + 1, same to right
// update ans = max(left + right), return max(left, right)
class LongestUnivaluePath {
    int ans;

    private int univaluePath(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = univaluePath(node.left);
        int right = univaluePath(node.right);

        int leftPath = 0, rightPath = 0;
        if(node.left != null && node.left.val == node.val) {
            leftPath += left + 1;
        }

        if(node.right != null && node.right.val == node.val) {
            rightPath += right + 1;
        }

        ans = Math.max(ans, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        univaluePath(root);
        return ans;
    }
}
