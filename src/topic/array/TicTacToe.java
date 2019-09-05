package array;
import java.util.*;


// Design tic toc toe game
// https://leetcode.com/problems/design-tic-tac-toe
// Assign value for each player move, win score = n*playerScore
// Choose score so that values are not overlapsed, e.g: 1 and -1
// Store total value for row, column and 2 diagonals (x+y = n-1 and y-x = 0)
// Runtime O(1), space O(n)
public class TicTacToe {

    private int[] cols;
    private int[] rows;
    private int diagonal1;
    private int diagonal2;
    private int size;
    private int player1Score = 1;
    private int player2Score = -1;
    private int player1WinScore;
    private int player2WinScore;
    private int winner;

    public TicTacToe(int n) {
        size = n;
        cols = new int[n];
        rows = new int[n];
        player1WinScore = n;
        player2WinScore = -n;
    }


    public int move(int row, int col, int player) {
        int score = player == 1 ? player1Score : player2Score;
        int winScore = player == 1 ? player1WinScore : player2WinScore;

        rows[row] += score;
        cols[col] += score;

        if(row - col == 0) {
            diagonal1 += score;
        }

        if(row + col == size - 1) {
            diagonal2 += score;
        }

        if(rows[row] == winScore || cols[col] == winScore || diagonal1 == winScore || diagonal2 == winScore) {
            winner = player;
            return player;
        }

        return 0;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(3);

        game.move(0, 0, 1);
        game.move(0, 1, 2);
        game.move(1, 1, 1);
        game.move(2, 2, 2);
        game.move(2, 1, 1);

        System.out.println("Winner is..." + game.winner);
    }
}
