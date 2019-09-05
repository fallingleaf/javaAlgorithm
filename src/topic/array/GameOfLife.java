package array;
import java.util.*;


// Use 2 bits to store next states: 0 -> 10 or 00, 1 -> 11 or 01
// Live cell 1, only num live = 2 or 3, it changes to b11 = 3
// Death cell 0, only num live = 3, it changes to b10 = 2
public class GameOfLife {
    private int[] dirx = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
    private int[] diry = new int[] {1, 1, 1, 0, 0, -1, -1, -1};

    private int numberOfLive(int[][] board, int x, int y) {
        int count = 0, coordX, coordY;
        for(int i = 0; i < 8; i++) {
            coordX = x + dirx[i];
            coordY = y + diry[i];
            if(coordX < board.length && coordX >= 0 && coordY < board[0].length
                && coordY >= 0 && (board[coordX][coordY] & 1) == 1) {
                count ++;
            }
        }
        return count;
    }

    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int count = numberOfLive(board, i, j);
                if(board[i][j] == 1) {
                    if(count == 2 || count == 3) {
                        board[i][j] = 3;
                    }
                } else {
                    if(count == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
}
