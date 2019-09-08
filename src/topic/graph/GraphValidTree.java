package graph;
import java.util.*;


// Check if undirected graph is a valid tree => if no cycle in graph
// Can use either DFS or BFS
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();

        queue.offer(0);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(visited.contains(node)) {
                return false;
            }

            visited.add(node);
            for(int neighbor: graph.get(node)) {
                // if node not parent
                if(!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }

        // disconnected graph
        if(visited.size() < n) {
            return false;
        }

        return true;

    }

    public boolean dfs(int node, int parent, HashMap<Integer, ArrayList<Integer>> map, boolean[] visited) {
        if(visited[node]) {
            return false;
        }

        visited[node] = true;

        for(int i: map.get(node)) {
            if(i != parent && !dfs(i, node, map, visited)) {
                return false;
            }
        }

        return true;
    }
}
