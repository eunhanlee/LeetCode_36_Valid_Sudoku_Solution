package org.example;

public class Solution2 {
    /**
     * Checks if the given Sudoku board is valid.
     *
     * @param board The Sudoku board represented as a 2D char array.
     * @return Returns true if the board is valid, false otherwise.
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !valid(board, i, j))
                    return false;
            }
        }

        return true;
    }

    /**
     * Checks if the value at a specific position (i, j) on the board is valid.
     *
     * @param board The Sudoku board represented as a 2D char array.
     * @param i     The row index of the cell.
     * @param j     The column index of the cell.
     * @return Returns true if the cell value is valid, false otherwise.
     */
    boolean valid(char[][] board, int i, int j) {
        for (int x = 0; x < 9; x++) {
            if (x != i && board[x][j] == board[i][j])
                return false;

            if (x != j && board[i][x] == board[i][j])
                return false;

            int row = i / 3 * 3 + x / 3; // matrix row
            int col = j / 3 * 3 + x % 3; // matrix col

            if ((row != i || col != j) && board[i][j] == board[row][col])
                return false;
        }

        return true;
    }
}
