package tree;
import java.util.*;

// https://leetcode.com/problems/average-of-levels-in-binary-tree/submissions/
// Return average value for each level
public class AverageLevel {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            result.add(sum / n);
        }
        return result;
    }
}
