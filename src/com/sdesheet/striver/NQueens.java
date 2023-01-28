package com.sdesheet.striver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        boolean[][] board = new boolean[n][n];

        backtrack(0, board, cols, posDiag, negDiag, res);
        return res;
    }

    private void createAnswer(boolean[][] board, List<List<String>> res) {
        List<String> list = new ArrayList<>();
        for (boolean[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean isQueen : row) {
                if (isQueen) sb.append("Q");
                else sb.append(".");
            }
            list.add(sb.toString());
        }
        res.add(list);
    }

    private void backtrack(int row, boolean[][] board, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag, List<List<String>> res) {
        if (row == board.length) {
            createAnswer(board, res);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (cols.contains(col)) continue;
            if (posDiag.contains(row+col)) continue;
            if (negDiag.contains(col-row)) continue;


            board[row][col] = true;
            cols.add(col);
            posDiag.add(row+col);
            negDiag.add(col-row);

            backtrack(row+1, board, cols, posDiag, negDiag, res);

            board[row][col] = false;
            cols.remove(col);
            posDiag.remove(row+col);
            negDiag.remove(col-row);
        }

    }
}
