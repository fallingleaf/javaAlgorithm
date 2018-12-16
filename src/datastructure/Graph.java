package datastructure;

import java.util.*;


class Edge {
    int u, v, w;

    Edge(int x, int y, int weight) {
        u = x;
        v = y;
        w = weight;
    }

    @Override
    public String toString() {
        return u + "=>" + v + ":" + w;
    }
}


public class Graph {

    boolean directed;
    int vertices;
    HashMap<Integer, List<Edge>> edges;

    public enum State {
        UNDISCOVERED, DISCOVERED, PROCESSED;
    }

    Graph(boolean direct) {
        directed = direct;
        vertices = 0;
        edges = new HashMap<>();
    }

    void addEdge(int x, int y, int weight) {
        if(!edges.containsKey(x)) {
            edges.put(x, new ArrayList<Edge>());
            vertices ++;
        }

        if(!edges.containsKey(y)) {
            edges.put(y, new ArrayList<Edge>());
            vertices ++;
        }

        Edge e = new Edge(x, y, weight);
        edges.get(x).add(e);

        if(!directed) {
            Edge f = new Edge(y, x, weight);
            edges.get(y).add(f);
        }
    }

    void addEdge(int x, int y) {
        addEdge(x, y, 1);
    }

    public static boolean bfs(Graph g, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] status = new boolean[g.vertices];

        queue.add(start);
        while(!queue.isEmpty()) {
            int node = queue.remove();
            if(node == end) {
                return true;
            }
            // processed
            status[node] = true;

            for(Edge e: g.edges.get(node)) {
                if(!status[e.v] || g.directed) {
                    queue.add(e.v);
                }

            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(true);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(6, 0);

        System.out.println("Graph number of vertices..." + g.vertices);
        System.out.println("Bread first search...\n" + bfs(g, 6, 5));
    }

}
