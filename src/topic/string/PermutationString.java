package string;
import java.util.*;


// https://leetcode.com/problems/permutation-in-string/submissions/
// Check if s2 contains permutation of s1
// Use window algorithm, check for each window of size s1 in s2, the number
// of chars are equals
public class PermutationString {

    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null) {
            return true;
        }

        if(s2 == null) {
            return false;
        }

        int len1 = s1.length(), len2 = s2.length();
        if(len2 < len1) {
            return false;
        }

        int[] seq1 = new int[26];
        int[] seq2 = new int[26];

        for(int i = 0; i < len1; i++) {
            seq1[s1.charAt(i) - 'a'] ++;
            seq2[s2.charAt(i) - 'a'] ++;
        }

        if(Arrays.equals(seq1, seq2)) {
            return true;
        }

        for(int j = 0; j < len2 - len1; j++) {
            seq2[s2.charAt(j) - 'a'] --;
            seq2[s2.charAt(len1 + j) - 'a'] ++;
            if(Arrays.equals(seq1, seq2)) {
                return true;
            }
        }

        return false;
    }

    private void swap(char[] seq, int i, int j) {
        char tmp = seq[i];
        seq[i] = seq[j];
        seq[j] = tmp;
    }

    private void permute(char[] seq, int left, int right, List<String> res) {
        if(left == right) {
            res.add(String.valueOf(seq));
            return;
        }

        for(int i = left; i <= right; i++) {
            swap(seq, i, left);
            permute(seq.clone(), left + 1, right, res);
            swap(seq, left, i);
        }
    }

    public List<String> findPermutations(String s) {
        List<String> res = new ArrayList<> ();
        permute(s.toCharArray(), 0, s.length() - 1, res);
        return res;
    }

    public static void main(String[] args) {
        PermutationString ps = new PermutationString();
        List<String> res = ps.findPermutations("abc");
        System.out.println("All permutations of \n");
        for(String s: res) {
            System.out.println(s);
        }
    }

}
