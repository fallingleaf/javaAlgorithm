package tree;
import java.util.*;


// https://leetcode.com/problems/path-sum/
// https://leetcode.com/problems/path-sum-ii/
// Find if there's a path from root to leaf that sum to value k
// Path sum II: return list of paths
// DFS (or backtrack) left and right
public class PathSum {

    private List<List<Integer>> ans = new ArrayList<>();

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }

        if(root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) {
            return ans;
        }
        ArrayList<Integer> curr = new ArrayList<>();
        curr.add(root.val);
        backtrack(root, sum - root.val, curr);
        return ans;
    }

    private void backtrack(TreeNode node, int sum, ArrayList<Integer> curr) {

        if(sum == 0 && node.left == null && node.right == null) {
            ArrayList<Integer> res = new ArrayList<>();
            res.addAll(curr);
            ans.add(res);
            return;
        }

        if(node.left != null) {
            curr.add(node.left.val);
            backtrack(node.left, sum - node.left.val, curr);
            curr.remove(curr.size() - 1);
        }

        if(node.right != null) {
            curr.add(node.right.val);
            backtrack(node.right, sum - node.right.val, curr);
            curr.remove(curr.size() - 1);
        }
    }


}
