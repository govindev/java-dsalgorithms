package com.challenges.leetcode.twentyone.july;

import java.util.*;

public class MakingALargestIceland {
	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 0 }, { 1, 0 } };
		System.out.println("Grid length : " + largestIsland(grid));
	}

	static int size = 0;

	public static int largestIsland(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				boolean markedToOne = false;
				if (grid[i][j] == 0) {
					grid[i][j] = 1;
					markedToOne = true;
				}
				Arrays.stream(visited).forEach(a -> Arrays.fill(a, false));
				// Arrays.fill(visited, false);
				size = 0;
				explore(i, j, grid, visited);
				if (size > max)
					max = size;
				if (markedToOne)
					grid[i][j] = 0;
			}
		}
		return max;
	}

	private static void explore(int i, int j, int[][] grid, boolean[][] visited) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid.length) {
			return;
		}
		if (visited[i][j])
			return;
		if (grid[i][j] == 0)
			return;
		visited[i][j] = true;
		size++;
		explore(i - 1, j, grid, visited);
		explore(i + 1, j, grid, visited);
		explore(i, j - 1, grid, visited);
		explore(i, j + 1, grid, visited);
	}
}
