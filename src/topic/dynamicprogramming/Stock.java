package dynamicprogramming;
import java.util.*;


// Find stock purchase profit given list of stock prices
// e.g [6, 8, 12, 1, 4, 10]
// one transaction, unlimited transactions, max k transactions
// For k transactions, call profit[k][n] is profit at day n and k transactions
// profit[k][n] = max(profit[k-1][x] + prices[n] - prices[x]) x = 0...n-1
// base case: profit[0][i] = 0
public class Stock {
    public int maxProfitOne(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }

        int profit = 0;
        int minPrice = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > minPrice) {
                profit = Math.max(profit, nums[i] - minPrice);
            } else {
                minPrice = nums[i];
            }
        }

        return profit;
    }

    public int maxProfitTwo(int[] nums) {
        int profit = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                profit += nums[i] - nums[i-1];
            }
        }

        return profit;
    }

    public int maxProfitThree(int[] nums, int k) {
        if(nums.length < 2) {
            return 0;
        }

        int[][] profit = new int[k+1][nums.length];
        for(int i = 1; i <= k; i++) {
            for(int j = 0; j < nums.length; j++) {
                for(int x = 0; x < j; x++) {
                    profit[i][j] = Math.max(profit[i][j], profit[i-1][x] + nums[j] - nums[x]);
                }
            }
        }

        return profit[k][nums.length - 1];
    }
}
