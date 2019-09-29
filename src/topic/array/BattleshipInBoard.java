package array;
import java.util.*;


// Facebook
// https://leetcode.com/problems/battleships-in-a-board/
// Each battleships is in same row or column, at least one space
// count how many battleships
// Solution: loop i, j if encounter X, check if we already count battleships
// for this X or not by checking i - 1, j and i, j - 1 is also X
public class BattleshipsInBoard {
    public int countBattleships(char[][] board) {
        int ans = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'X') {
                    if(i > 0 && board[i-1][j] == 'X') {
                        continue;
                    }

                    if(j > 0 && board[i][j-1] == 'X') {
                        continue;
                    }

                    ans ++;
                }
            }
        }

        return ans;
    }
}
