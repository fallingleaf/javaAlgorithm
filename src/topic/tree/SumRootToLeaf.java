package tree;
import java.util.*;


// https://leetcode.com/problems/sum-root-to-leaf-numbers/
// node contains value from 1->9, e.g 2 <- 1 -> 3 => 12 + 13 = 25
// Recursively pass number along the path, and current sum
// if node is leaf calculate current sum and return
public class SumToLeaf {
    public int sum(TreeNode node, int num, int acc) {
        if(node == null) {
            return 0;
        }

        num = num * 10 + node.val;
        if(node.left == null && node.right == null) {
            return acc + num;
        }

        return sum(node.left, num, acc) + sum(node.right, num, acc);
    }

    public int sumNumbers(TreeNode root) {
        return sum(root, 0, 0);
    }
}
