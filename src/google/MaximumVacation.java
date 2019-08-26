package google;

import java.util.*;
import java.lang.Math;

/*
- Google
- HARD: https://leetcode.com/problems/maximum-vacation-days
- Brute force: use DFS to find all available vacation trips, runtime O(n^k)
- Dynamic programing: 2D array to store maximum vacation, dp[i][j] is maximum
vacation at week i and city j => dp[i][j] = max dp[i][j], dp[i-1][x] + days[x][i-1]
if there's connecting flight between x and j, flights[x][j] = 1
- Optimize space: observe that dp[i] depend on only dp[i-1], we can use only
1 array for city
*/
public class MaximumVacation {

    public int res = 0;

    public void dfs(int[][] flights, int[][] days, int week, int city, int total) {
        if(week >= flights.length) {
            res = Math.max(res, total);
            return;
        }

        // Stay at current city
        dfs(flights, days, week+1, city, total + days[city][week]);

        // Flight to next available city
        for(int i = 0; i < flights.length; i++) {
            if(flights[city][i] == 1) {
                dfs(flights, days, week+1, i, total + days[i][week]);
            }
        }

    }

    public int maximumVacation(int[][] flights, int[][] days) {
        // dfs(flights, days, 0, 0, 0);
        int n = days.length, k = days[0].length;

        int[][] dp = new int[k+1][n];

        for(int i = 1; i <= k; i++) {
            for(int j = 0; j < n; j++) {
                for(int x = 0; x < n; x++) {
                    if(flights[x][j] == 1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][x] + days[x][i-1]);
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumVacation mv = new MaximumVacation();
        int flights[][] = new int[][] {
            {0, 0, 1},
            {1, 0, 1},
            {1, 1, 0}
        };

        int days[][] = new int[][] {
            {7, 0, 0},
            {3, 7, 3},
            {3, 3, 7}
        };

        int res = mv.maximumVacation(flights, days);
        System.out.println("Maximum vacation...." + res);
    }

}
