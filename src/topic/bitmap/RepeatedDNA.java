package bitmap;
import java.util.*;


// https://leetcode.com/problems/repeated-dna-sequences/
//
public class RepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        HashMap<Character, Integer> code = new HashMap<>();
        code.put('A', 0);
        code.put('C', 1);
        code.put('G', 2);
        code.put('T', 3);

        int mask = (1 << 20) - 1;
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> added = new HashSet<>();

        int hash = 0;

        for(int i = 0; i < s.length(); i++) {
            hash = (hash << 2) + code.get(s.charAt(i));
            if(i >= 9) {
                hash &= mask;
                if(visited.contains(hash) && !added.contains(hash)) {
                    ans.add(s.substring(i - 9, i + 1));
                    added.add(hash);
                }
                visited.add(hash);

            }
        }

        return ans;
    }
}
