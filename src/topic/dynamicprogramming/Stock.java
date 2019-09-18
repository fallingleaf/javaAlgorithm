package dynamicprogramming;
import java.util.*;


// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
// Find stock purchase profit given list of stock prices
// e.g [6, 8, 12, 1, 4, 10]
// one transaction, unlimited transactions, 2 transactions, max k transactions
public class Stock {
    // One transaction at most
    // Keep track of min price
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

    // Unlimited number of transaction
    // Check if current prices larger than previous prices, make transaction
    public int maxProfitTwo(int[] nums) {
        int profit = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                profit += nums[i] - nums[i-1];
            }
        }

        return profit;
    }

    // Two transactions
    // Divide 2 sub arrays to store max profit from 0 -> i and i + 1 to n
    // At each i, profit = left[i] + right[i]
    public int maxProfitThree(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int ans = 0;

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        int min = prices[0];
        int max = prices[prices.length - 1];

        for(int i = 1; i < prices.length; i++) {
            left[i] = Math.max(left[i-1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        for(int j = prices.length - 2; j >= 0; j--) {
            right[j] = Math.max(right[j+1], max - prices[j]);
            max = Math.max(max, prices[j]);
        }

        for(int i = 0; i < prices.length; i++) {
            ans = Math.max(ans, left[i] + right[i]);
        }

        return ans;
    }


    // At most K transactions
    // If k >= len/2 => unlimited transaction
    // Call profit[i][j] is profit at i transaction and day j
    // profit[i][j] = profit[i][j-1], max(profit[i-1][x] + prices[j] - prices[x]) for x = 0...j-1
    // base case: profit[0][i] = 0
    // Obseve that: profit[i-1][x] - prices[x] is recalculated again for j
    public int maxProfitFour(int[] prices, int k) {
        if(prices.length < 2) {
            return 0;
        }

        if(k >= prices.length/2) {
            int profit = 0;
            for(int i = 1; i < prices.length; i++) {
                if(prices[i] > prices[i-1]) {
                    profit += prices[i] - prices[i-1];
                }
            }
            return profit;
        }

        int localMax = 0;

        int[][] profit = new int[k+1][prices.length];
        for(int i = 1; i <= k; i++) {
            localMax = profit[i-1][0] - prices[0];
            for(int j = 1; j < prices.length; j++) {
                profit[i][j] = Math.max(profit[i][j-1], prices[j] + localMax);
                // Update next localMax
                localMax = Math.max(localMax, profit[i-1][j] - prices[j]);
            }
        }

        return profit[k][prices.length - 1];
    }
}
