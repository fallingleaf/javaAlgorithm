

// Facebook
// https://leetcode.com/problems/range-sum-of-bst/
// Calculate total sum in range L and R
// check if left not null and current root val >= L then call left
// same for right
public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) {
            return 0;
        }
        int ans = 0;

        if(root.val >= L && root.val <= R) {
            ans += root.val;
        }

        if(root.left != null && root.val >= L) {
            ans += rangeSumBST(root.left, L, R);
        }

        if(root.right != null && root.val <= R) {
            ans += rangeSumBST(root.right, L, R);
        }

        return ans;
    }
}
