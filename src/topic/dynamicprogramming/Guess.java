package dynamicprogramming;
import java.util.*;


/* Google
- https://leetcode.com/problems/guess-number-higher-or-lower-ii/
- If guess x failed, pay $x money
- Find the amount of money to guarantee find correct answer
- Range 1...n, if guess x: if higher: go with range x+1 ... n
- If lower go with 1 ... x-1
- call problem: P(1, n) = min(x + max(P(1, x-1), P(x+1, n)) for x in 1...n
- P(i, j) = min(k + max(P(i, k-1), P(k+1, j)))
- Base case: P[i][i] = 0, P[i][i+1] = i bc we have 2 choices, choose the lower
number will be lower cost
=> Dynamic programing, runtime O(n^2)
*/
class Guess {

    int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];

        for(int l=1; l <= n; l++) {
            for(int i=1; i <= n-l; i++ ) {
                int j = i + l;
                int gMin = Integer.MAX_VALUE;

                if(j == i+1) {
                    dp[i][j] = i;
                    continue;
                }

                for(int k = i+1; k < j; k++) {
                    int lMax = k + Math.max(dp[i][k-1], dp[k+1][j]);
                    gMin = Math.min(lMax, gMin);
                }

                dp[i][j] = gMin;
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        Guess g = new Guess();
        System.out.println("amount of money..." + g.getMoneyAmount(10));
    }

}
