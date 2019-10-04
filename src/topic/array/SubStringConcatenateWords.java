package array;
import java.util.*;


// https://leetcode.com/problems/substring-with-concatenation-of-all-words/
// Find substring contains all words, no interfer chars, each word same length
// use map store frequency of words, for each window = word length * list length
// check if window contains all word
public class SubStringConcatenateWords {
    private boolean isValid(String s, int left, int right, int len,
        HashMap<String, Integer> map, HashMap<String, Integer> curr) {

        for(int i = left; i < right; i += len) {
            String sub = s.substring(i, i + len);
            if(!map.containsKey(sub) || curr.getOrDefault(sub, 0) >= map.get(sub)) {
                return false;
            }

            curr.put(sub, curr.getOrDefault(sub, 0) + 1);
        }

        return true;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if(s == null || words.length == 0) {
            return ans;
        }

        int n = s.length();
        int wordLen = words[0].length();
        int window = wordLen * words.length;

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> curr = new HashMap<>();


        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for(int i = 0; i <= s.length() - window; i++) {
            if(isValid(s, i, i + window, wordLen, map, curr)) {
                ans.add(i);
            }

            curr.clear();
        }

        return ans;
    }
}
