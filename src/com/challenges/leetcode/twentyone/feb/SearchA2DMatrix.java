package com.challenges.leetcode.twentyone.feb;

/***
 * Search a 2d Matrix
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3650/
 * 
 * @author Govind
 *
 */
public class SearchA2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == target)
				return true;
			if (matrix[i][0] > target)
				return false;
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][j] == target)
					return true;
				if (matrix[i][j] > target)
					continue;
			}
		}
		return false;
	}
}