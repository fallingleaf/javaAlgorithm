package array;
import java.util.*;


// HARD: Google
// https://www.programcreek.com/2014/07/leetcode-best-meeting-point-java/
// Give matrix with houses as 1, find point to meet to has min total distance
// Analyse: meeting point should be middle point between these house
// Find all houses x and y, take the middle point of x and y
// Bug: col is not sorted, not to sort before process
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        int ans = 0;
        if(rows.size() == 0) {
            return ans;
        }
        Collection.sort(cols);

        int midRow = rows.get(rows.size()/2);
        int midCol = cols.get(cols.size()/2);

        for(int row: rows) {
            ans += Math.abs(row - midRow);
        }

        for(int col: cols) {
            ans += Math.abs(col - midCol);
        }

        return ans;
    }
}
