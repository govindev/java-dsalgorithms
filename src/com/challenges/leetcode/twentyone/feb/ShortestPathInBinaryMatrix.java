package com.challenges.leetcode.twentyone.feb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;

public class ShortestPathInBinaryMatrix {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int r = Integer.parseInt(br.readLine().trim());
		String[] elements = br.readLine().trim().split(",");
		int[][] grid = new int[r][r];
		for (int i = 0, k = 0; i < r; i++) {
			for (int j = 0; j < r; j++, k++) {
				grid[i][j] = Integer.parseInt(elements[k]);
			}
		}

		// System.out.println(shortestPathBinaryMatrix(grid));
		System.out.println(distance(0, 0, grid, 0, 1));
		System.out.println(minElementsCount);
	}

	static int minElementsCount = 0;
	static Integer minDistance = null;

	private static int shortestPathBinaryMatrix(int[][] grid) {
		System.out.println(distance(0, 0, grid, 0, 1));
		return minElementsCount;
	}

	private static int distance(int r, int c, int[][] grid, int distance, int elementsCount) {
		int n = grid.length;
		if (r == c && r == (n - 1)) {
			// Last node reached.
			int dist = distance + grid[r][c];
			if (minDistance == null || dist <= minDistance) {
				if (minDistance != null && minDistance == dist) {
					minElementsCount = Math.min(minElementsCount, elementsCount);
				} else {
					minElementsCount = elementsCount;
				}
				minDistance = dist;
			}
			return dist;
		}
		if (r > n - 1 || c > n - 1) {
			return distance;
		}
		int forwardWayDistance = distance(r, c + 1, grid, distance + grid[r][c], elementsCount + 1);
		int downwardWayDistance = distance(r + 1, c, grid, distance + grid[r][c], elementsCount + 1);
		int crossWayDistance = distance(r + 1, c + 1, grid, distance + grid[r][c], elementsCount + 1);

		return Math.min(forwardWayDistance, Math.min(downwardWayDistance, crossWayDistance));
	}

}
