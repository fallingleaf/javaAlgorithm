package tree;


// https://leetcode.com/problems/maximum-binary-tree/
// Find max index and recurse
public class MaximumBinaryTree {
    private TreeNode buildTree(int[] nums, int left, int right) {

        if(left > right) {
            return null;
        }

        if(left == right) {
            return new TreeNode(nums[left]);
        }

        int maxIdx = left;
        for(int i = left + 1; i <= right; i++) {
            if(nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = buildTree(nums, left, maxIdx - 1);
        root.right = buildTree(nums, maxIdx + 1, right);
        return root;

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
}
