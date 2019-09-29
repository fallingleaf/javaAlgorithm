package array;


// facebook
// https://leetcode.com/problems/verifying-an-alien-dictionary/
// check if each words in list follow the order
// Solution: store index of in char in order string, check each pair of words
// handle case word1 length > word2 length e.g apple > app
class VerifyAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for(int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int k = Math.min(w1.length(), w2.length());
            int j = 0;
            for(j = 0; j < k; j++) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    if(index[w1.charAt(j) - 'a'] > index[w2.charAt(j) - 'a']) {
                        return false;
                    } else {
                        break;
                    }
                }
            }

            if(j == k && w1.length() > w2.length()) {
                return false;
            }
        }

        return true;
    }
}
