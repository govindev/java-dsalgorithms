package com.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;

                if (!set.add("r"+i+board[i][j])
                        || !set.add("c"+j+board[i][j])
                        || !set.add("b"+(i/3)+(j/3)+board[i][j])) return false;
            }
        }
        return true;
    }
}
