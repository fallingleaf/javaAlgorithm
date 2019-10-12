package array;
import java.util.*;



// A knight on infinite board, find min step to reach x, y
// Use bfs, with tracking step already move by knight
class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int MAXN = 310, steps = 0;
        int[] dx = {-2,-1,1,2,2,1,-1,-2};
        int[] dy = {1,2,2,1,-1,-2,-2,-1};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[MAXN][MAXN];
        q.add(new int[]{0,0});
        visited[0][0] = true;

        while(q.size() > 0) {
            int sz = q.size();
            for(int i = 0; i < sz; i++) {
                int[] curr = q.poll();
                if(curr[0] == x && curr[1] == y) {
                    return steps;
                }
                for(int j = 0; j < 8; j++) {
                    int x1 = curr[0] + dx[j];
                    int y1 = curr[1] + dy[j];
                    if(x1 < 0 || y1 < 0 || x1 >= MAXN || y1 >= MAXN) {
                        continue;
                    }
                    if(!visited[x1][y1]) {
                        visited[x1][y1] = true;
                        q.add(new int[]{x1, y1});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
