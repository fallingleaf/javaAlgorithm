package datastructure;
import java.util.*;


// Google, Facebook
// https://leetcode.com/problems/lru-cache/
// LRU cache: when insert, evit least use key before inserting
// Use: double linkedlist to modify nodes with O(1), hash table to store key
// and node, use 2 dummy head and tail nodes for easily modify
class Node {
    public Node prev;
    public Node next;
    public int value;
    public int key;

    @Override
    public String toString() {
        return "" + key + "-" + value;
    }
}


public class LRUCache {

    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> cache = new HashMap<> ();

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node();
        tail = new Node();

        head.next = tail;
        head.prev = null;

        tail.prev = head;
        tail.next = null;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        putToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(!cache.containsKey(key)) {
            Node node = new Node();
            node.key = key;
            node.value = value;

            cache.put(key, node);
            addNode(node);
            // Remove last node if over capacity
            if(cache.size() > capacity) {
                Node last = popTailNode();
                cache.remove(last.key);
            }
        } else {
            // Update value and move node to head if node exists
            Node node = cache.get(key);
            node.value = value;
            putToHead(node);
        }

    }

    private void removeNode(Node node) {
        Node nprev = node.prev;
        Node nnext = node.next;
        nprev.next = nnext;
        nnext.prev = nprev;
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void putToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node popTailNode() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
