package tree;
import java.util.*;


// Find longest consecutive sequence in binary tree
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
}
