package com.sdesheet.striver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuSolver {

    // 1. We can solve it using the Backtracking approach
    // 2. Place a certain number at certain place and check whether this number is already there either in the row / column / grid
    // 3. If it exists we will not add the number and proceed to add the next number
    // 4. If the number doesn't exist we will add it and proceed to the next number
    public static void solveSudoku(char[][] board) {

        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> grids = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            grids.add(new HashSet<>()); // 0,0
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                grids.get(getGrid(i, j)).add(board[i][j]);
            }
        }
        sudoku(board, 0, 0, rows, cols, grids);
    }

    private static int getGrid(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }

    private static boolean canFill(char ch, Set<Character> row, Set<Character> col, Set<Character> grid) {
        return !row.contains(ch) && !col.contains(ch) && !grid.contains(ch);
    }


    private static boolean sudoku(char[][] board, int row, int col, List<Set<Character>> rows, List<Set<Character>> cols, List<Set<Character>> grids) {

        if (col == board.length) {
            // finished with the entire row
            // go to the next row
            return sudoku(board, row+1, 0, rows, cols, grids);
        }


        if (row > board.length-1) {
            // Traversed the entire matrix
            // We have the result
            // Simply return it
            return true;
        }

        // Move on to the next cell if the current is filled
        if (board[row][col] != '.') {
            return sudoku(board, row, col+1, rows, cols, grids);
        }

        // Here we have an empty cell and want to put some number
        for (char i = '1'; i <= '9'; i++) {
            // Check whether we can put this here or not
            Set<Character> rowSet = rows.get(row);
            Set<Character> colSet = cols.get(col);
            Set<Character> gridSet = grids.get(getGrid(row, col));

            if (canFill(i, rowSet, colSet, gridSet)) {
                board[row][col] = i;
                rowSet.add(i);
                colSet.add(i);
                gridSet.add(i);

                if (sudoku(board, row, col+1, rows, cols, grids)) {
                    return true;
                }
                board[row][col] = '.';
                rowSet.remove(i);
                colSet.remove(i);
                gridSet.remove(i);
            }
        }
        return false;
    }
}
