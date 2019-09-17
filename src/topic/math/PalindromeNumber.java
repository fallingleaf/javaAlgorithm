package math;
import java.util.*;

// https://leetcode.com/problems/palindrome-number/
// Check if a number is palindrome e.g 124421 or 12421
// divide number into 2 parts by devise 10 to number and mul 10
// check if right number = left number or left number = right number/10
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return x == rev || x == rev/10;

    }
}
