package org.example;

import java.util.*;

public class Solution {

    /**
     * Checks if the given Sudoku board is valid.
     *
     * @param board The Sudoku board represented as a 2D char array.
     * @return True if the board is valid, false otherwise.
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if(chkMetrixHasDuplicate(board, i, j)) return false;
                    if(chkRowHasDuplicate(board, i, j)) return false;
                    if(chkColumnHasDuplicate(board, i, j)) return false;
                }
            }
        }

        return true;
    }

    private boolean chkMetrixHasDuplicate(char[][] board, int i, int j) {
        return hasDuplicate(getMetrix(board, i, j));
    }

    private boolean chkRowHasDuplicate(char[][] board, int i, int j) {
        return hasDuplicate(getRow(board, i, j));
    }

    private boolean chkColumnHasDuplicate(char[][] board, int i, int j) {
        return hasDuplicate(getColumn(board, i, j));
    }

    /**
     * Retrieves the values in the 3x3 matrix that contains the cell at position (i, j).
     *
     * @param board The Sudoku board represented as a 2D char array.
     * @param i     The row index of the cell.
     * @param j     The column index of the cell.
     * @return A list of characters representing the values in the matrix.
     */
    private List<Character> getMetrix(char[][] board, int i, int j) {
        List<Character> result = new ArrayList<>();
        int startX = (i/3)*3;
        int startY = (j/3)*3;

        for (int x = startX; x < startX+3; x++) {
            for (int y = startY; y < startY+3; y++) {
                if (board[x][y] != '.') {
                    result.add(board[x][y]);
                }
            }
        }

        return result;
    }

    /**
     * Retrieves the values in the same row as the cell at position (i, j).
     *
     * @param board The Sudoku board represented as a 2D char array.
     * @param i     The row index of the cell.
     * @param j     The column index of the cell.
     * @return A list of characters representing the values in the row.
     */
    private List<Character> getRow(char[][] board, int i, int j) {
        List<Character> result = new ArrayList<>();

        for (int y = 0; y < 9; y++) {
            if (board[i][y] != '.')
                result.add(board[i][y]);
        }

        return result;
    }

    /**
     * Retrieves the values in the same column as the cell at position (i, j).
     *
     * @param board The Sudoku board represented as a 2D char array.
     * @param i     The row index of the cell.
     * @param j     The column index of the cell.
     * @return A list of characters representing the values in the column.
     */
    private List<Character> getColumn(char[][] board, int i, int j) {
        List<Character> result = new ArrayList<>();

        for (int x = 0; x < 9; x++) {
            if (board[x][j] != '.')
                result.add(board[x][j]);
        }

        return result;
    }

    /**
     * Checks if a list of characters contains any duplicates.
     *
     * @param list The list of characters to be checked.
     * @return True if the list contains duplicates, false otherwise.
     */
    private boolean hasDuplicate(List<Character> list) {
        HashSet<Character> set = new HashSet<>();
        for (char c : list) {
            if (set.contains(c)) {
                return true;
            }
            set.add(c);
        }

        return false;
    }
}
