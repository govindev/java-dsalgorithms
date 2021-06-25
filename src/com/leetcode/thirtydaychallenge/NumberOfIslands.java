package com.leetcode.thirtydaychallenge;

public class NumberOfIslands {

	public static void main(String[] args) {
		char[][] array = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		System.out.println("Count : " + numIslands(array));
	}

	public static int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (checkWhetherIsland(i, j, grid) && Character.getNumericValue(grid[i][j]) == 1)
					count++;
			}
		}
		return count;
	}

	private static boolean checkWhetherIsland(int i, int j, char[][] grid) {
		int adjCount = 0;
		if (i - 1 >= 0) {
			adjCount += Character.getNumericValue(grid[i - 1][j]);
		}
		if (j - 1 >= 0) {
			adjCount += Character.getNumericValue(grid[i][j - 1]);
		}
		if (j + 1 < grid[0].length) {
			adjCount += Character.getNumericValue(grid[i][j + 1]);
		}
		if (i + 1 < grid.length) {
			adjCount += Character.getNumericValue(grid[i + 1][j]);
		}
		if (adjCount < 2) {
			return true;
		} else {
			return false;
		}
	}
}