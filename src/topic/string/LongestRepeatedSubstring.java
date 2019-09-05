package generic;
import java.util.*;


// Find longest repeated substring, non-overlap
public class LongestRepeatedSubstring {

    public String findLongestRepeatedSubstring(String s) {
        if(s == null) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>();
        String res = "";
        int len = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+1; j < s.length(); j++) {
                String substr = s.substring(i, j);
                if(map.containsKey(substr)) {
                    // If longer and not overlap
                    if(i > map.get(substr) && substr.length() > len) {
                        len = substr.length();
                        res = substr;
                    }
                } else {
                    map.put(substr, j);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestRepeatedSubstring lr = new LongestRepeatedSubstring();
        System.out.println("longest substring..." + lr.findLongestRepeatedSubstring("aaaabcddeabcdeab"));
    }
}
