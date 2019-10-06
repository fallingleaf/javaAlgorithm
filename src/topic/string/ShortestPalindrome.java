package string;
import java.util.*;

// HARD
// https://leetcode.com/problems/shortest-palindrome/solution/
// Add characters at beginning to form shortest palindome
// Solution: similar to longest palidrome substring
// Find longest palindrome substring and reverse suffix to add at beginning
// Optimize: run 2 pointers i, j, if i == j increase i, the largest substring
// will be in range 0, i, reverse the last part i, n as prefix and recursive
// part 0, i
class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int i=0;
        for(int j = s.length() - 1; j >= 0; j--) {
            if(s.charAt(i)==s.charAt(j)) {
                i++;
            }
        }

        if(i==s.length())
            return s;

        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, i));
        return prefix+mid+suffix;
    }

}
