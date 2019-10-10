package tree;
import java.util.*;


// Find longest consecutive sequence in binary tree, from parent to children
// Recursively call left and right, passing the current parent value
// check if node value = parent value + 1, if equal update current length,
// other wise length = 1
public class LongestConsecutive {
    private int ans;

    private void findLongest(TreeNode node, int currentVal, int currentLen) {
        if(node == null) {
            return;
        }

        currentLen = node.val == currentVal + 1 ? currentLen + 1 : 1;
        ans = Math.max(ans, currentLen);
        findLongest(node.left, node.val, currentLen);
        findLongest(node.right, node.val, currentLen);
    }

    public int longestConsecutiveSequence(TreeNode root) {
        if(root == null) {
            return 0;
        }

        findLongest(root, root.val - 1, 0);
        return ans;
    }


    // Version 2: longest through child to parent to child can be decreasing
    // Call recursive left and right, compare value with parent
    // = parent + 1 then increasing, = parent -1 decreasing
    // return both increase and decrease length
    int[] helper(TreeNode node, TreeNode parent) {
        if(node == null) {
            return new int[] {0, 0};
        }

        int[] left = helper(node.left, node);
        int[] right = helper(node.right, node);

        // increase from right -> node -> left
        ans = Math.max(ans, left[0] + right[1] + 1);
        // increase from left -> node -> right
        ans = Math.max(ans, left[1] + right[0] + 1);

        int inc = 0, desc = 0;

        if(node.val == parent.val + 1) {
            inc = Math.max(left[0], right[0]) + 1;
        } else if(node.val + 1 == parent.val) {
            desc = Math.max(left[1], right[1]) + 1;
        }

        return new int[] {inc, desc};
    }

    public int longestConsecutiveSequence2(TreeNode root) {
        helper(root, root);
        return ans;
    }
}
