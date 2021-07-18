package com.leetcode.topinterviewquestions;

public class SurrondedRegions {
	public static void main(String[] args) {
		char[][] board = new char[][] { { 'O', 'X', 'X', 'O', 'X' }, { 'X', 'O', 'O', 'X', 'O' },
				{ 'X', 'O', 'X', 'O', 'X' }, { 'O', 'X', 'O', 'O', 'O' }, { 'X', 'X', 'O', 'X', 'O' } };
		solve(board);
	}

	public static void solve(char[][] board) {
		int len = board.length;
		int border = 1;
		while (border < len - 1) {
			int i = border, j = border;
			while (j < len - border) {
				board[i][j] = getChar(board, i, j);
				j++;
			}
			j--;
			while (i < len - border) {
				board[i][j] = getChar(board, i, j);
				i++;
			}
			i--;
			while (j >= border) {
				board[i][j] = getChar(board, i, j);
				j--;
			}
			j++;
			while (i >= border) {
				board[i][j] = getChar(board, i, j);
				i--;
			}
			i++;
			border++;
		}
	}

	public static char getChar(char[][] board, int i, int j) {
		if ((j - 1 == 0 && board[i][j - 1] == 'O') || (j + 1 == board.length - 1 && board[i][j + 1] == 'O')
				|| (i - 1 == 0 && board[i - 1][j] == 'O') || (i + 1 == board.length - 1 && board[i + 1][j] == 'O')) {
			return 'O';
		} else {
			return 'X';
		}
	}
}
