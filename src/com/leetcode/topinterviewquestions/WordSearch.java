package com.leetcode.topinterviewquestions;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCB";
		System.out.println(exist(board, word));
	}

	public static boolean exist(char[][] board, String word) {
		// DFS approach
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (word.charAt(0) == board[i][j] && isAMatch(board, i, j, 0, word)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isAMatch(char[][] board, int i, int j, int current, String word) {
		if (current == word.length()) {
			return true;
		}
		if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(current)) {
			return false;
		}

		char temp = board[i][j];
		board[i][j] = ' ';

		boolean isAMatch = isAMatch(board, i, j + 1, current + 1, word) || isAMatch(board, i, j - 1, current + 1, word)
				|| isAMatch(board, i - 1, j, current + 1, word) || isAMatch(board, i + 1, j, current + 1, word);
		board[i][j] = temp;

		return isAMatch;
	}
}
