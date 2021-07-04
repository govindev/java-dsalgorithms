package com.leetcode.topinterviewquestions;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		Set<String> store = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				char ch = board[i][j];
				if (ch != '.') {
					int b = (i / 3 * 3) + (j / 3);
					if (!store.add("r" + i + ch) || !store.add("c" + j + ch) || !store.add("b" + b + ch)) {
						return false;
					}
				}
			}
		}
		return true;
	}
}