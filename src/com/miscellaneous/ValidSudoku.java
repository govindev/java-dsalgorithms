package com.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> sudoku = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                if (sudoku.contains("row"+i+ch) || sudoku.contains("col"+j+ch) || sudoku.contains("grid"+i/3+j/3+ch)) {
                    return false;
                }
                sudoku.add("row"+i+ch);
                sudoku.add("col"+j+ch);
                sudoku.add("grid"+i/3+j/3+ch);
            }
        }
        return true;
    }
}
