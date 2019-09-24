package tree;
import java.util.*;


// Create iterator from BST: next() and hasNext() methods
// Use stack: store left nodes, next() pop one node out, push right node in
// Extend: implement prev and has Prev
// Use List to store previous processed node
// hasPrev: check if prevIndex >= 0, prev: get from prevIndex, decrease prevIndex
// hasNext: prevIndex < pre.size - 1 or stack is not empty
// next: if prevIndex < pre.size - 1, get from prev, increase prevIndex
// otherwise: remove from stack, increase prev Index
public class BSTIterator {
    private Stack<TreeNode> stack;
    private List<TreeNode> prev = new ArrayList<TreeNode> ();
    private int prevIndex = -1;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();

        TreeNode p = root;
        while(p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty() || (prevIndex < prev.size() - 1);
    }

    public int next() {
        if(prevIndex < prev.size() - 1) {
            TreeNode node = prev.get(prevIndex + 1);
            prevIndex ++;
            return node.val;
        }

        TreeNode node = stack.pop();
        // Push to prev list
        prev.add(node);
        prevIndex ++;

        int res = node.val;
        node = node.right;

        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        return res;
    }

    public boolean hasPrev() {
        return prevIndex >= 0;
    }

    public int prev() {
        TreeNode node = prev.get(prevIndex);
        prevIndex --;
        return node.val;
    }
}
