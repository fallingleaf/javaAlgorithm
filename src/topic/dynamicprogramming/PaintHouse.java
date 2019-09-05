package dynamicprogramming;
import java.util.*;


// Facebook
// Each house has 3 colors red, blue, green. Find minimum cost to paint all
// house so that no two adjacent houses have same color
// if paint house i with color 0, then house i - 1 color min(color 1, color 2)
// cost[i][0] += min(cost[i-1][1], cost[i-1][2])
// Same for paint house i with color 1
public class PaintHouse {
    public int minCost(int[][] costs) {
        int len = costs.length;
        if(len == 0) {
            return 0;
        }
        for(int i = 1; i < len; i++) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }

        return Math.min(costs[len-1][0], Math.min(costs[len-1][1], costs[len-1][2]));
    }


    // Paint house with k colors
    // Same as above, cost[i][j] += min(cost[i][x]) x = 1...k x != j
    // Optimize: everytime store previous min cost and second min
    // if current idx = index of min, add second min
    public int minCost2(int[][] costs) {
        int house = costs.length;
        int color = costs[0].length;
        if(house == 0) {
            return 0;
        }

        int prevMin = 0;
        int prevSecond = 0;
        int minIdx = -1;

        for(int i = 0; i < house; i++) {
            int tmpMin = Integer.MAX_VALUE, tmpSecond = Integer.MAX_VALUE, tmpIdx = -1;

            for(int j = 0; j < color; j++) {
                if(j == minIdx) {
                    costs[i][j] += prevSecond;
                } else {
                    costs[i][j] += prevMin;
                }

                if(costs[i][j] < tmpMin) {
                    tmpMin = costs[i][j];
                    tmpIdx = j;
                } else if(costs[i][j] < tmpSecond) {
                    tmpSecond = costs[i][j];
                }
            }

            prevMin = tmpMin;
            prevSecond = tmpSecond;
            minIdx = tmpIdx;
        }

        return prevMin;
    }
}
