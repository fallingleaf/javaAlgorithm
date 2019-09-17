package math;
import java.util.*;


// https://leetcode.com/problems/powx-n/
// Calculate pow, recursively call function with n / 2, check if n is odd or
// even, handle n negative and overflow
public class Pow {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }

        if(n == -1) {
            return 1/x;
        }

        double half = myPow(x, n/2);
        int m = Math.abs(n);

        if(m % 2 == 1) {
            return n > 0 ? x * half * half: 1/x * half * half;
        }
        return half * half;
    }
}
