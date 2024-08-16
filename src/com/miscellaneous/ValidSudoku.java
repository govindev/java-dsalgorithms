package com.miscellaneous;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> sudoku = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (!sudoku.add("row"+i+ch) || !sudoku.add("col"+j+ch) || !sudoku.add("box"+boxIndex+ch)) return false;
            }
        }
        return true;
    }


    public boolean isValidSudoku1(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> box = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (rows.get(i) == null) rows.put(i, new HashSet<>());
                if (columns.get(j) == null) columns.put(j, new HashSet<Character>());
                if (box.get(boxIndex) == null) box.put(boxIndex, new HashSet<Character>());

                if (rows.get(i).contains(board[i][j]) ||
                        columns.get(j).contains(board[i][j]) ||
                        box.get(boxIndex).contains(board[i][j])) {
                    return false;
                }

                rows.get(i).add(board[i][j]);
                columns.get(j).add(board[i][j]);
                box.get(boxIndex).add(board[i][j]);
            }
        }
        return true;
    }
}
