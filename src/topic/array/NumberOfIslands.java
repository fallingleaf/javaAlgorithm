package array;


// Give matrix with 0 water, 1 land, count island
// DFS if cell = 1, dfs adjection cells, set it to 2, runtime O(m*n)
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0||grid[0].length==0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    count++;
                    merge(grid, i, j);
                }
            }
        }

        return count;
    }

    public void merge(char[][] grid, int i, int j){
        int m=grid.length;
        int n=grid[0].length;

        if(i<0||i>=m||j<0||j>=n||grid[i][j]!='1')
            return;

        grid[i][j]='X';

        merge(grid, i-1, j);
        merge(grid, i+1, j);
        merge(grid, i, j-1);
        merge(grid, i, j+1);
    }


    // Hard
    // https://www.programcreek.com/2015/01/leetcode-number-of-islands-ii-java/
    // Count number of island after adding land to water
    // Use disjoint set, check if neighbor is filled parent != -1 and if different set
    // join them and reduce count, set neighbor parent to current
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m * n];
        Arrays.fill(parent,-1);

        ArrayList<Integer> result = new ArrayList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 0;
        for (int[] position : positions) {
            count++;
            int idx = n * position[0] + position[1];

            if (parent[idx] == -1) {
                parent[idx] = idx;
            }

            for (int k = 0; k < 4; k++) {
                int x = position[0] + dx[k];
                int y = position[1] + dy[k];

                int idxNeighbor = n * x + y;

                if (x >= 0 && x < m && y >= 0 && y < n && parent[idxNeighbor] != -1) {
                    int p = getParent(parent, idxNeighbor);

                    //set neighor's parent to be current idx
                    if (parent[p] != idx) {
                        parent[p] = idx;
                        count--;
                    }
                }
            }

            result.add(count);
        }

        return result;
    }

    private int getParent(int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[i];
        }

        return i;
    }
}
