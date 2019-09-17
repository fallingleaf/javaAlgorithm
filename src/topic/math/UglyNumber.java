package math;
import java.util.*;


// https://leetcode.com/problems/super-ugly-number/
// Ugly numbers are number that factorial of 2, 3, 5, ... only
// Use array to keep track of index value for each prime number
// Each time find min value, if prime multiple with its index = min
// then increase min value => run time O(kn)
// Optimize use min heap, with (val, prime, multiplier) starting with 1
public class UglyNumber {
    public boolean isUgly(int num) {
        if(num == 0) {
            return false;
        }

        if(num == 1) {
            return true;
        }

        if(num%2 == 0) {
            return isUgly(num / 2);
        }

        if(num%3 == 0) {
            return isUgly(num / 3);
        }

        if(num%5 == 0) {
            return isUgly(num / 5);
        }
        return false;
    }

    public int nthUglyNumber(int n) {
        if(n <= 0) {
            return 0;
        }

        int[] ugly = new int[n];
        ugly[0] = 1;

        int index2, index3, index5;
        int val2, val3, val5;

        int min;
        for(int i = 1; i < n; i++) {
            val2 = ugly[index2] * 2;
            val3 = ugly[index3] * 3;
            val5 = ugly[index5] * 5;
            min = Math.min(val2, Math.min(val3, val5));

            if(min == val2) {
                index2 ++;
            }

            if(min == val3) {
                index3 ++;
            }

            if(min == val5) {
                index5 ++;
            }
            ugly[i] = min;
        }

        return ugly[n-1];
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n <= 0) {
            return 0;
        }

        int[] ugly = new int[n];
        ugly[0] = 1;

        int[] primeIndex = new int[primes.length];
        int min;

        for(int i = 1; i < n; i++) {
            min = Integer.MAX_VALUE;

            for(int j = 0; j < primes.length; j++) {
                min = Math.min(primes[j] * ugly[primeIdx[j]]);
            }

            for(int j = 0; j < primes.length; j++) {
                if(min == primes[j] * ugly[primeIdx[j]]) {
                    primeIndex[j] ++;
                }
            }
        }

        return ugly[n-1];
    }
}
