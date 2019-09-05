package trie;
import java.util.*;


/* Google 
HARD: https://leetcode.com/problems/prefix-and-suffix-search/
- Give a list of words, filter by prefix and suffix
- Use TrieNode and insert suffix + "#" + prefix into trie
- Edge case there's no suffix and prefix to filter, return highest index
*/
class TrieNode {
    TrieNode[] children;
    int weight;

    public TrieNode() {
        children = new TrieNode[27];
        weight = -1;
    }

    public static void insert(TrieNode node, String word, int weight) {
        TrieNode tmp = node;
        int idx;
        char c;

        for(int i = 0; i < word.length(); i++) {
            c = word.charAt(i);

            if(c == '#') {
                idx = 26;
            } else {
                idx = c - 'a';
            }
            if(tmp.children[idx] == null) {
                TrieNode n = new TrieNode();
                tmp.children[idx] = n;
            }

            tmp = tmp.children[idx];
            if(tmp.weight < weight) {
                tmp.weight = weight;
            }
        }

    }

    public static int search(TrieNode node, String word) {
        TrieNode tmp = node;
        int idx;
        char c;

        for(int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if(c == '#') {
                idx = 26;
            } else {
                idx = c - 'a';
            }

            if(tmp.children[idx] == null) {
                return -1;
            }
            tmp = tmp.children[idx];
        }

        return tmp.weight;
    }
}


class WordFilter {

    TrieNode root = new TrieNode();

    public WordFilter(String[] words) {
        // Edge case: no prefix and no suffix filter, return highest index
        root.children[26] = new TrieNode();
        root.children[26].weight = words.length - 1;

        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            for(int j = word.length(); j >= 0; j--) {
                String comp = word.substring(j) + "#" + word;
                TrieNode.insert(root, comp, i);
            }
        }

    }

    public int find(String prefix, String suffix) {
        String comp = suffix + "#" + prefix;
        return TrieNode.search(root, comp);
    }
}
