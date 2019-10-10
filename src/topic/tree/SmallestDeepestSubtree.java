package tree;

import java.util.*;


// https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
// Find subtre contain all deepest nodes
// Find max distance from node and deepest node for left and right
// if dist left > dist right return node left and left distance
// if equal return node
public class SmallestDeepestSubtree {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    // Return the result of the subtree at this node.
    public Result dfs(TreeNode node) {
        if (node == null) return new Result(null, 0);
        Result L = dfs(node.left),
               R = dfs(node.right);

        if (L.dist > R.dist) return new Result(L.node, L.dist + 1);
        if (L.dist < R.dist) return new Result(R.node, R.dist + 1);

        return new Result(node, L.dist + 1);
    }

    class Result {
        TreeNode node;
        int dist;
        Result(TreeNode n, int d) {
            node = n;
            dist = d;
        }
    }
}
