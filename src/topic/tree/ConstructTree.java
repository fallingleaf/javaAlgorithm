package tree;
import java.util.*;


// Build tree from preOrder and inOrder array
// pre order: root -> left -> right, inOrder left -> root -> right
// root = preorder[0], find root in inorder at index k, len = k - inorder start
// e.g [3, 9, 20] and [9, 3, 20] -> k = 1, preorder: [9], [20], inorder[9], [20]
// Use hashmap to decrease lookup time
public class ConstructTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd,
        int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap)
    {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = helper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = helper(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}
