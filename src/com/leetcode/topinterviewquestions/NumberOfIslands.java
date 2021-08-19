package com.leetcode.topinterviewquestions;

import java.util.*;

public class NumberOfIslands {

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		NumberOfIslands solution = new NumberOfIslands();
		System.out.println(solution.numIslands(grid));
	}

	boolean[][] visited;
	char[][] grid;

	public int numIslands(char[][] grid) {
		this.grid = grid;
		visited = new boolean[grid.length][grid[0].length];
		for (boolean[] v : visited) {
			Arrays.fill(v, false);
		}
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (!visited[i][j] && grid[i][j] != '0') {
					count++;
					visit(i, j);
				}
			}
		}
		return count;
	}

	public void visit(int i, int j) {
		if (i > -1 && j > -1 && i < visited.length && j < visited[i].length && !visited[i][j] && grid[i][j] == '1') {
			visited[i][j] = true;
			visit(i + 1, j);
			visit(i, j + 1);
			visit(i - 1, j);
			visit(i, j - 1);
		}
	}
}
