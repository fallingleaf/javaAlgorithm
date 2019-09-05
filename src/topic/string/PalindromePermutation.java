package string;

import java.util.*;
import java.lang.StringBuilder;

// https://leetcode.com/problems/palindrome-permutation-ii
// 2 cases: number chars are even or odd. Count number of character,
// add first half of chars to string buffer, and permutate them, reverse and
// add middle char (if odd)
public class PalindromePermutation {

    HashSet<String> set = new HashSet<> ();

    public void swap(StringBuilder sb, int i, int j) {
        char p = sb.charAt(i);
        char q = sb.charAt(j);
        sb.setCharAt(i, q);
        sb.setCharAt(j, p);
    }

    public void permutate(StringBuilder sb, int l, int r) {
        if(l == r) {
            set.add(sb.toString());
            return;
        }

        for(int i = l; i <= r; i++) {
            if(sb.charAt(i) != sb.charAt(l) || i == l) {
                swap(sb, i, l);
                permutate(sb, l+1, r);
                swap(sb, l, i);
            }
        }
    }

    public List<String> findPalindromePermutation(String s) {
        ArrayList<String> res = new ArrayList<> ();

        if(s.length() <= 1) {
            res.add(s);
            return res;
        }

        HashSet<Character> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()) {
            if(hs.contains(c)) {
                hs.remove(c);
                sb.append(c);
            } else {
                hs.add(c);
            }
        }

        // Cannot form palindrome from current string
        if(hs.size() > 1) {
            return res;
        }

        String middle = "";
        if(s.length() % 2 == 1) {
            middle = hs.iterator().next().toString();
        }

        System.out.println("current buffer..." + sb);

        permutate(sb, 0, sb.length() - 1);

        System.out.println("List of permutation...." + set);

        for(String first: set) {
            StringBuilder m = new StringBuilder(first);
            res.add(first + middle + m.reverse().toString());
        }

        return res;

    }

    public static void main(String[] args) {
        PalindromePermutation pp = new PalindromePermutation();
        System.out.println(pp.findPalindromePermutation("abbbbccdd"));
    }
}
