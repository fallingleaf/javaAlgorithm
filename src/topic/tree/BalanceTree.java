package tree;
import java.util.*;


// Check if tree is balance, height not different than 1
// Recursively check height from left and right
// if = -1, return -1 otherwise compare height
public class BalanceTree {
    public boolean isBalance(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(getHeight(root) == -1) {
            return false;
        }

        return true;

    }

    public int getHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        if(left == -1 || right == -1) {
            return -1;
        }

        if(Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}
