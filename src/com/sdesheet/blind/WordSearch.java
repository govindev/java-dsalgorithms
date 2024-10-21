package com.sdesheet.blind;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, used, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean exist(char[][] board, boolean[][] used, int i, int j, String word, int ind) {
        if (i < 0 || i > board.length-1
                || j < 0 || j > board[i].length-1
                || ind > word.length()-1
                || used[i][j]) {
            return false;
        }

        char ch = word.charAt(ind);
        if (ch != board[i][j]) {
            return false;
        }
        if (ind == word.length()-1) {
            return true;
        }

        used[i][j] = true;
        if (exist(board, used, i-1, j, word, ind+1)
                || exist(board, used, i, j+1, word, ind+1)
                || exist(board, used, i+1, j, word, ind+1)
                || exist(board, used, i, j-1, word, ind+1)) {
            return true;
        }
        used[i][j] = false;

        return false;
    }
}
