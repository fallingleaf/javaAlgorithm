package tree;
import java.util.*;


// https://leetcode.com/problems/unique-binary-search-trees-ii/
// Find number of unique binary search tree, given number of node
// with 1 node -> 1 tree, 2 nodes -> 2 trees, 3 nodes: choose root at 0, 1, 2
// left 0 node, right 2 node => F(0) * F(2) + F(1)*F(1) + F(2) * F(0)
// Generate all unique trees: choose node from 0 -> n-1, recursively generate
// left tree and right tree
// Optimize: n = 6 -> choose 3 -> left [0, 1, 2] and right [4, 5]
// choose 4 -> left [0, 1, 2, 3] -> choose 3 -> [0, 1, 2] overlap
// Can use hash table to store list of tree
public class UniqueBST {
    public int numTrees(int n) {
        int[] count = new int[n+1];
        count[0] = 1;
        count[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }

        return count[n];
    }

    private HashMap<String, List<TreeNode>> map = new HashMap<>();

    private List<TreeNode> generate(int m, int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(m > n) {
            ans.add(null);
            return ans;
        }

        if(m == n) {
            TreeNode node = new TreeNode(n);
            ans.add(node);
            return ans;
        }

        String key = m + " " + n;
        if(map.containsKey(key)) {
            return map.get(key);
        }

        for(int k = m; k <= n; k++) {
            List<TreeNode> left = generate(m, k-1);
            List<TreeNode> right = generate(k+1, n);

            for(TreeNode ln: left) {
                for(TreeNode rn: right) {
                    TreeNode root = new TreeNode(k);
                    root.left = ln;
                    root.right = rn;
                    ans.add(root);
                }
            }
        }

        map.put(key, ans);
        return ans;

    }

    public List<TreeNode> generateTrees(int n) {
        return generate(0, n-1);
    }
}
