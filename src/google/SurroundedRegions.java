package google;
import java.util.*;


// https://leetcode.com/problems/surrounded-regions/
// board contains only 'X' and 'O', flip all surrounded 'O' to 'X', 'O'
// at border is not surrounded
// - Solution: BFS all 'O' connected to 'O' at border and flip them to 'H'
// flip remaining O to X and H to O
class SurroundedRegions {
    public static final int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void bfs(char[][] board, int x, int y) {
        board[x][y] = 'H';

        Queue<int[]> queue = new LinkedList<> ();
        queue.offer(new int[] {x, y});
        while(!queue.isEmpty()) {
            int[] coord = queue.poll();
            for(int[] dir: directions) {
                int newx = coord[0] + dir[0];
                int newy = coord[1] + dir[1];
                if(newx >= 0 && newx < board.length && newy >= 0
                    && newy < board[0].length && board[newx][newy] == 'O') {
                    board[newx][newy] = 'H';
                    queue.offer(new int[] {newx, newy});
                }
            }
        }
    }

    public void solve(char[][] board) {
        if(board.length == 0) {
            return;
        }
        int row = board.length, col = board[0].length;

        // All O at column 0 and col - 1
        for(int i = 0; i < row; i++) {
            if(board[i][0] == 'O') {
                bfs(board, i, 0);
            }

            if(board[i][col-1] == 'O') {
                bfs(board, i, col-1);
            }
        }

        for(int j = 0; j < col; j++) {
            if(board[0][j] == 'O') {
                bfs(board, 0, j);
            }

            if(board[row-1][j] == 'O') {
                bfs(board, row-1, j);
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if(board[i][j] == 'H') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
