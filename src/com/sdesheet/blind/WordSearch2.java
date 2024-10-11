package com.sdesheet.blind;

public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (findWord(board, word)) {
                result.add(word);
            }
        }
        return result;
    }


    private boolean findWord(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (findWord(board, used, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, boolean[][] used, int i, int j, String word, int ind) {
        if (i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1 || ind > word.length()-1) {
            return false;
        }
        if (used[i][j] || board[i][j] != word.charAt(ind)) {
            return false;
        }
        if (ind == word.length()-1) {
            return true;
        }
        used[i][j] = true;
        if (findWord(board, used, i-1, j, word, ind+1)
                || findWord(board, used, i, j+1, word, ind+1)
                || findWord(board, used, i+1, j, word, ind+1)
                || findWord(board, used, i, j-1, word, ind+1)
        )
        {
            return true;
        }
        used[i][j] = false;

        return false;
    }
}
