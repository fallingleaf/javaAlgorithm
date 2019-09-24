package array;
import java.util.*;


// https://www.programcreek.com/2014/05/leetcode-walls-and-gates-java/
// Matrix contains: -1 wall, 0 gate, INF empty room
// Find shortest distance from each empty cell to its nearest gate
// BFS: put all gates into queue, update distance if it's not update yet
// DFS: update distance if new distance < current distance
public class WallAndGates {
    public void roomAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    fill(rooms, i, j, 0);
                }
            }
        }
    }

    public void fill(int[][] rooms, int i, int j, int distance) {
        int m = rooms.length;
        int n = rooms[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] < distance) {
            return;
        }

        rooms[i][j] = distance;
        fill(rooms, i - 1, j, distance + 1);
        fill(rooms, i + 1, j, distance + 1);
        fill(rooms, i, j - 1, distance + 1);
        fill(rooms, i, j + 1, distance + 1);
    }
}
