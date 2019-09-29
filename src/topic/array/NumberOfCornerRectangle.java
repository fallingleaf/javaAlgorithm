package array;
import java.util.*;


// Facebook
// http://buttercola.blogspot.com/2018/10/leetcode-750-number-of-corner-rectangles.html
// Give matrix with 0 and 1, a corner rectange has 4 corner 1
// Count how many corner rectangle in matrix
// Solution: for every 2 rows, check each column if they are equal 1
// number of rectangle = count * (count - 1)/2 e.g 2 columns 1 form rectangle
// => 2*(2-1)/2 = 1
public class NumberOfCornerRectangle {
    public int countCornerRectangles(int[][] grid) {
        if(grid == null || grid.length < 2 || grid[0].length < 2) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int ans = 0;

        for(int r1 = 0; r1 < m - 1; r1++) {
            for(int r2 = r1 + 1; r2 < m; r2++) {
                int count = 0;
                for(int col = 0; c < n; c++) {
                    if(grid[r1][col] == 1 && grid[r2][col] == 1) {
                        count ++;
                    }
                }

                ans += count * (count - 1)/2;
            }
        }
        return ans;
    }
}
