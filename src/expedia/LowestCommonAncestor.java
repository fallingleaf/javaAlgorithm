package expedia;
import java.util.*;


// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Iteractive: store parent of node p into set, check parent of q in set
// Recursive: return node if node equal p or q or null
public class LowestCommonAncestor {
    // Interactive approach
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(p == null) {
            return q;
        }

        if(q == null) {
            return p;
        }
        Queue<TreeNode> queue = new LinkedList<> ();
        HashMap<TreeNode, TreeNode> parent = new HashMap<> ();

        parent.put(root, null);
        queue.offer(root);

        while(!queue.isEmpty() && (!parent.containsKey(p) || !parent.containsKey(q))) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                parent.put(node.left, node);
                queue.offer(node.left);
            }

            if(node.right != null) {
                parent.put(node.right, node);
                queue.offer(node.right);
            }
        }

        Set<TreeNode> nodes = new HashSet<> ();

        while(p != null) {
            nodes.add(p);
            p = parent.get(p);
        }

        while(q != null) {
            if(nodes.contains(q)) {
                return q;
            }

            q = parent.get(q);
        }
        return null;
    }

    // Recursive approach
    private TreeNode backtrack(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null || node == p || node == q) {
            return node;
        }

        TreeNode left = backtrack(node.left, p, q);
        TreeNode right = backtrack(node.right, p, q);

        if(left != null && right != null) {
            return node;
        }

        return left != null ? left: right;
    }

    // Node has link to its parent
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> parent = new HashSet<> ();
        while(p != null) {
            parent.add(p);
            p = p.parent;
        }

        while(q != null) {
            if(parent.contains(q)) {
                return q;
            }

            q = q.parent;
        }

        return null;
    }
}
