package array;
import java.util.*;


// Hard:
// https://www.programcreek.com/2014/05/leetcode-shortest-distance-from-all-buildings-java/
// Grid contains house 1, empty 0, and obstacle 2, build new house to have shortest
// distance to all other houses
// BFS from each house, use distance matrix to store total distance from other houses
// reach matrix to store number of houses can reach
public class ShortestDistanceFromHouses {
    public int shortestDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] distance = new int[row][col];
        int[][] reach = new int[row][col];
        int numHouses = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    distance[i][j] = Integer.MAX_VALUE;
                    numHouses ++;
                    helper(grid, i, j, distance, reach);
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(distance[i][j] < minDistance && reach[i][j] == numHouses) {
                    minDistance = distance[i][j];
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    // Run BFS from x, y and record distance and number of houses reached
    private void helper(int[][] grid, int x, int y, int[][] distance, int[][] reach) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<Integer> distanceQueue = new LinkedList<>();

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};

        queue.offer(new int[] {x, y});
        distanceQueue.offere(1);

        while(!queue.isEmpty()) {
            int[] coord = queue.poll();
            int dis = distanceQueue.poll();

            for(int k = 0; k < 4; k++) {
                int i = coord[0] + dx[k];
                int j = coord[1] + dy[k];
                if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 0) {
                    continue;
                }

                distance[i][j] += dis;
                reach[i][j] ++;

                grid[i][j] = -1;
                queue.offer(new int[] {i, j});
                distanceQueue.offer(dis + 1);
            }
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == -1) {
                    grid[i][j] = 0;
                }
            }
        }
    }

}
