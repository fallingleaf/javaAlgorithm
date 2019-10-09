package tree;
import java.util.*;


// Facebook
// Return all node values in tranverse boundary of tree
// Boundary: from root down to left then leaves, to right up to root
// Divide into 3: root to left, leaves and right to root
public class BoundaryTranversal {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> boundaryTranverse(TreeNode root) {
        if(root == null) {
            return ans;
        }

        ans.add(root.val);

        tranverseLeft(root.left);

        tranverseLeaves(root.left);
        tranverseLeaves(root.right);

        tranverseRight(root.right);
        return ans;
    }

    public void tranverseLeft(TreeNode node) {
        if(node == null) {
            return;
        }

        if(node.left != null) {
            ans.add(node.val);
            tranverseLeft(node.left);
        } else if(node.right != null) {
            ans.add(node.val);
            tranverseLeft(node.right);
        }
    }

    public void tranverseLeaves(TreeNode node) {
        if(node == null) {
            return;
        }

        if(node.left == null && node.right == null) {
            ans.add(node.val);
        } else {
            tranverseLeaves(node.left);
            tranverseLeaves(node.right);
        }
    }

    public void tranverseRight(TreeNode node) {
        if(node == null) {
            return;
        }

        if(node.right != null) {
            tranverseRight(node.right);
            ans.add(node.val);
        } else if(node.left != null) {
            tranverseRight(node.left);
            ans.add(node.val);
        }
    }
}
