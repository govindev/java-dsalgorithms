package com.leetcode.topinterviewquestions;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		// We would to store whether first row is a zero row or not
		boolean isFirstAZeroRow = false;
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				isFirstAZeroRow = true;
				break;
			}
		}

		// Store whether each column is a zero or column or not
		// We store this in the first row jth column
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			// Check whether the current row is a zero row or not
			boolean isCurrentAZeroRow = false;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					isCurrentAZeroRow = true;
					break;
				}
			}
			
			// 1. If current row is a zero row then all the elements are zero
			// 2. If it is a zero column then the current element is zero
			// For the second to determine we already have this value in the first zero jth index
			for (int j = 0; j < n; j++) {
				if (isCurrentAZeroRow || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// If the first a zero row, then have all the row elements assigned to zero
		if (isFirstAZeroRow) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}

	}

}
