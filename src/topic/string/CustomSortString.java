package string;
import java.util.*;


// Facebook
// https://leetcode.com/problems/custom-sort-string/submissions/
// Give 2 string S and T, sort string T in order of character appear in string s
// Solution: count number of char in T, loop through S and append chars to
// string builder, then append remaining char not in S
public class CustomSortString {
    public String customSortString(String S, String T) {
        int[] charCounts = new int[26];
        for(int i = 0; i < T.length(); i++) {
            charCounts[T.charAt(i) - 'a'] ++;
        }

        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < S.length(); j++) {
            int idx = S.charAt(j) - 'a';
            for(int k = 0; k < charCounts[idx]; k++) {
                sb.append(S.charAt(j));
            }

            charCounts[idx] = 0;
        }

        for(char c = 'a'; c <= 'z'; c++) {
            for(int k = 0 ; k < charCounts[c - 'a']; k++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
