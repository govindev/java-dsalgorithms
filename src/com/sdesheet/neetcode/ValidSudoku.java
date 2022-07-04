package com.sdesheet.neetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                if (!set.add("r"+i+ch) ||
                        !set.add("c"+j+ch) ||
                        !set.add("b"+(i/3)+(j/3)+ch)) {
                    return false;
                }
            }
        }
        return true;
    }
}
