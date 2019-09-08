package graph;
import java.util.*;


// Facebook
// https://leetcode.com/problems/clone-graph/
// Use hash table to store cloned node, recursively call clone
public class CloneGraph {

    private Node clone(Node node, HashMap<Integer, Node> map) {
        if(map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node clone = new Node();
        clone.val = node.val;
        clone.neighbors = new ArrayList<Node>();

        map.put(clone.val, clone);

        for(Node neighbor: node.neighbors) {
            Node n = clone(neighbor, map);
            clone.neighbors.add(n);
        }

        return clone;

    }


    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }

        HashMap<Integer, Node> map = new HashMap<>();
        return clone(node, map);
    }
}
