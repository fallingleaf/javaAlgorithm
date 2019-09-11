package tree;
import java.util.*;


// Google
// https://leetcode.com/problems/binary-tree-maximum-path-sum/
// Find maximum path sum value for any starting nodes
// Find max of left and right, update answer = max of node value + left or right
// or both left and right or node value itself
// return only node value + left or right
public class MaxPathSum {
    private int ans = Integer.MIN_VALUE;

    private int maxPath(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = maxPath(node.left);
        int right = maxPath(node.right);

        int maxCurrent = Math.max(node.val, Math.max(node.val + left, node.val + right));
        ans = Math.max(ans, Math.max(node.val + left + right, maxCurrent));
        return maxCurrent;
    }

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return ans;
    }
}
