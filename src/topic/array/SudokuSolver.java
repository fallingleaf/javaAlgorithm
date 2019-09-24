package array;
import java.util.*;


// HARD: Facebook, google
// https://leetcode.com/problems/sudoku-solver/
// Give a sudoku matrix 9x9, each row, column and sub cell 3x3 contains only
// number from 1 to 9 without any duplicate
// Bruteforce: for each empty cell, check number from 1 to 9
// if it is not in row, column and cell
// use it and continue otherwise backtrack and use other number
// each cell has 9 choice => runtime 9^m * checking = (9 * 9 * 9)
// Check sub grid start index x, y for index i, j => x = 3 * (i/3), y = 3 * (j/3)
// Optimize: because each row, column, and cell only has 9 values, can use
// a bitmap to store which number is used to reduce runtime
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }

                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if (helper(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }

        return true; //return true if all cells are checked
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }

            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }

            int x = 3 * (row/3) + i/3;
            int y = 3 * (col/3) + i%3;

            if (board[x][y] != '.' && board[x][y] == c) {
                return false;
            }
        }
        return true;
    }
}
