package tree;

import java.util.*;


// https://www.programcreek.com/2014/05/leetcode-closest-binary-search-tree-value-java/
// Find closest value to target in tree
// Solution: binary search and compare different value and target
public class ClosestValue {
    int goal;
    double min = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return goal;
    }

    public void helper(TreeNode root, double target){
        if(root==null)
            return;

        if(Math.abs(root.val - target) < min){
            min = Math.abs(root.val-target);
            goal = root.val;
        }

        if(target < root.val){
            helper(root.left, target);
        }else{
            helper(root.right, target);
        }
    }

    /* HARD: Facebook K closest binary search tree value
    https://leetcode.com/problems/closest-binary-search-tree-value-ii/description/
    Use 2 stacks to store predecessor and successor as traversing
    Compare 2 stacks top values and choose nearest values
    As getting one value from stack, continue to push right successor or left
    predecessor to current stack */
    public List<Integer> KClosestValues(TreeNode root, int target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null || k <= 0) {
            return ans;
        }

        TreeNode current = root;
        Stack<TreeNode> smaller = new Stack<>();
        Stack<TreeNode> larger = new Stack<>();

        while(current != null) {
            if(current.val >= target) {
                larger.push(current);
                current = current.left;
            } else {
                smaller.push(current);
                current = current.right;
            }
        }

        while(k > 0) {
            if(smaller.isEmpty()) {
                getLarger(larger, ans);
            } else if(larger.isEmpty()) {
                getSmaller(smaller, ans);
            } else {
                int diff1 = target - smaller.peek().val;
                int diff2 = larger.peek().val - target;

                if(diff1 > diff2) {
                    getLarger(larger, ans);
                } else {
                    getSmaller(smaller, ans);
                }
            }

            k--;
        }

        return ans;

    }

    void getSmaller(Stack<Integer> stack, List<Integer> ans) {
        TreeNode node = stack.pop();
        ans.add(node.val);
        node = node.left;

        while(node != null) {
            stack.push(node);
            node = node.right;
        }
    }

    void getLarger(Stack<Integer> stack, List<Integer> ans) {
        TreeNode node = stack.pop();
        ans.add(node.val);
        node = node.right;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
