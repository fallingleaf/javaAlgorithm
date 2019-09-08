package graph;
import java.util.*;


// https://leetcode.com/problems/minimum-height-trees/
// Find all root that can form a tree with minimum height
// Add each edge to form graph, root is at the middle of
// tree will have minimum height, have maximum of 2 root
// (if 3 then we choose middle root)
// Do BFS from leaves, and remove leaves one by one from
// its neighbor, the remain nodes are root
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();

        if(n == 0) {
            return ans;
        }

        if(n == 1) {
            ans.add(0);
            return ans;
        }

        HashSet<Integer>[] graph = new HashSet[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }

        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        LinkedList<Integer> leaves = new LinkedList<Integer>();

        for(int i = 0; i < n; i++) {
            if(graph[i].size() == 1) {
                leaves.offer(i);
            }
        }

        while(n > 2) {
            n = n - leaves.size();
            LinkedList<Integer> newLeaves = new LinkedList<>();
            for(int leaf: leaves) {
                int neighbor = graph[leaf].iterator().next();
                graph[neighbor].remove(leaf);
                if(graph[neighbor].size() == 1) {
                    newLeaves.add(neighbor);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}
