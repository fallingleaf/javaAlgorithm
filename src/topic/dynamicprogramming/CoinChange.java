package dynamicprogramming;
import java.util.*;


// Find minimum number of coins to change
// Dynamic: dp[i] = 1 + dp[i - coin] if i >= coin
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount <= 0 || coins.length == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int coin: coins) {
                if(i >= coin) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount];
    }
}
