package tree;
import java.util.*;


// Create iterator from BST: next() and hasNext() methods
// Use stack: store left nodes, next() pop one node out, push right node in
public class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();

        TreeNode p = root;
        while(p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        int res = node.val;
        node = node.right;

        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        return res;
    }
}
