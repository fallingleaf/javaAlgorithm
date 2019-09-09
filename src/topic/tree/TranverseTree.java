package tree;
import java.util.*;


public class TranverseTree {

    // Pre order: root -> left -> right
    // Stack: push root into, then push right and left -> left at top stack
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }

            if(node.left != null) {
                stack.push(node.left);
            }
        }

        return ans;
    }

    // In order: left -> root -> right
    // Stack: push all left nodes from root, pop node out -> processed
    // then push right of node, then repeat
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }

        while(!stack.isEmpty()) {
            node = stack.pop();
            ans.add(node.val);

            node = node.right;
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        return ans;
    }

    // Post order: left -> right -> root
    // Stack and prev pointer
    // if prev is null or prev is parent of current node
    // we're moving down -> push current node left or right to stack
    // if prev is child of current node -> moving up
    // if prev is left child, push right child
    // prev is right child -> complete process, pop node and continue
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        TreeNode prev, curr;
        while(!stack.isEmpty()) {
            curr = stack.peek();
            // Tranverse down
            if(prev == null || prev.left == curr || prev.right == curr) {
                if(curr.left != null) {
                    stack.push(curr.left);
                } else if(curr.right != null) {
                    stack.push(curr.right);
                } else {
                    // leaf node, cannot tranverse more
                    stack.pop();
                    ans.push(curr.val);
                }
            }
            // Tranverse up from left node
            else if(curr.left == prev) {
                if(curr.right != null) {
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    ans.push(curr.val);
                }
            }
            // Tranverse up from right node
            else if(curr.right == prev){
                stack.pop();
                ans.push(curr.val);
            }
            prev = curr;
        }

        return ans;
    }
}
