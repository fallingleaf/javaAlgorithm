package dynamicprogramming;
import java.util.*;


// HARD
// https://leetcode.com/problems/dungeon-game/
// Starting at 0, each cell + or - health, find minimum health to reach at
// bottom right cell, if health drop at 0 or below die
// Brute force: DFS store current health and minHealth, call dfs to right and
// bottom cell
// Dynamic programming: call dp[m][n] is health before enter at cell
// start at bottom right cell, calculate min health back to cell at top left
public class Dungeon {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] health = new int[m][n];
        health[m-1][n-1] = dungeon[m-1][n-1] >= 0 ? 1 : - dungeon[m-1][n-1] + 1;

        // Right most column can only move down
        for(int i = m - 2; i >= 0; i--) {
            health[i][n-1] = Math.max(health[i+1][n-1] - dungeon[i][n-1], 1);
        }

        // Bottom row can only move to right
        for(int j = n - 2; j >= 0; j--) {
            health[m-1][j] = Math.max(health[m-1][j+1] - dungeon[m-1][j], 1);
        }

        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                int down = Math.max(health[i+1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j+1] - dungeon[i][j], 1);
                health[i][j] = Math.min(down, right);
            }
        }

        return health[0][0];
    }
}
