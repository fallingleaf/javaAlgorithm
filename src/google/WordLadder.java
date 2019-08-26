package google;
import java.util.*;


// https://leetcode.com/problems/word-ladder-ii/
// Find shortest list of words different 1 character
// Run BFS to find shortest transform, use distance hashmap to eliminate longer
// word list
class WordLadder {
    public List<String> getNeighbors(String word, Set<String> words) {
        List<String> list = new ArrayList<> ();

        for(int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            for(char c = 'a'; c <= 'z'; c++) {
                if(c == word.charAt(i)) {
                    continue;
                }
                sb.setCharAt(i, c);
                String newWord = sb.toString();
                if(words.contains(newWord)) {
                    list.add(newWord);
                }
            }
        }

        // System.out.println("neighbor for..." + word + " is " + String.join(", ", list));
        return list;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<> (wordList);
        List<List<String>> ans = new ArrayList<>();

        // Distance between word and begin word
        HashMap<String, Integer> visited = new HashMap<> ();
        visited.put(beginWord, 0);

        List<String> path = new ArrayList<>();
        path.add(beginWord);

        Queue<List<String>> queue = new LinkedList<> ();
        queue.offer(path);

        int length = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            Queue<List<String>> newQueue = new LinkedList<> ();
            for(List<String> p: queue) {
                String last = p.get(p.size() - 1);
                if(last.equals(endWord) && p.size() <= length) {
                    ans.add(p);
                    length = p.size();
                    continue;
                }

                // next distance
                int step = visited.get(last) + 1;

                for(String word: getNeighbors(last, words)) {
                    int d = visited.getOrDefault(word, Integer.MAX_VALUE);
                    // Already visited this word
                    if(step > d) {
                        continue;
                    }

                    List<String> newPath = new ArrayList<> (p);
                    newPath.add(word);
                    visited.put(word, step);
                    newQueue.offer(newPath);
                }
            }

            queue = newQueue;
        }

        return ans;

    }
}
