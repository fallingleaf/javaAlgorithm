import java.util.*;
package google;


// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
// Use DFS to search for longest path, optimize by using hashmap or array to
// cache visited nodes
class LongestIncreasingPath {
    public static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int dfs(int[][] matrix, int x, int y, int n, int m, int[][] cache) {
        int nx, ny;
        int ans = 1;
        if(cache[x][y] != 0) {
            return cache[x][y];
        }

        for(int[] dir: dirs) {
            nx = x + dir[0];
            ny = y + dir[1];

            if((nx >= 0) && (nx < n) && (ny >= 0) && (ny < m)) {
                if(matrix[nx][ny] > matrix[x][y]) {
                    ans = Math.max(ans, 1 + dfs(matrix, nx, ny, n, m, cache));
                }
            }
        }
        cache[x][y] = ans;
        return ans;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        if(n == 0) {
            return ans;
        }
        int m = matrix[0].length;

        int [][] cache = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, n, m, cache));
            }
        }

        return ans;
    }
}
