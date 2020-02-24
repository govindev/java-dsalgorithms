package com.challenges.gfg.stackandqueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

/***
 * https://practice.geeksforgeeks.org/problems/rotten-oranges/0
 * 
 * Given a matrix of dimension r*c where each cell in the matrix can have values
 * 0, 1 or 2 which has the following meaning: 0 : Empty cell 1 : Cells have
 * fresh oranges 2 : Cells have rotten oranges
 * 
 * So, we have to determine what is the minimum time required to rot all
 * oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes
 * [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time.
 * If it is impossible to rot every orange then simply return -1.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. Each test case contains two integers r and c, where r is the
 * number of rows and c is the number of columns in the array a[]. Next line
 * contains space separated r*c elements each in the array a[].
 * 
 * Output: Print an integer which denotes the minimum time taken to rot all the
 * oranges (-1 if it is impossible).
 * 
 * Constraints: 1 <= T <= 100 1 <= r <= 100 1 <= c <= 100 0 <= a[i] <= 2
 * 
 * Example: Input: 2 3 5 2 1 0 2 1 1 0 1 2 1 1 0 0 2 1 3 5 2 1 0 2 1 0 0 1 2 1 1
 * 0 0 2 1
 * 
 * Output: 2 -1
 * 
 * Explanation: Testcase 1: 2 | 1 | 0 | 2 | 1 1 | 0 | 1 | 2 | 1 1 | 0 | 0 | 2 |
 * 1
 * 
 * Oranges at positions {0,0}, {0, 3}, {1, 3} and {2, 3} will rot oranges at {0,
 * 1}, {1, 0}, {0, 4}, {1, 2}, {1, 4}, {2, 4} during 1st unit time. And, during
 * 2nd unit time, orange at {1, 0} got rotten and will rot orange at {2, 0}.
 * Hence, total 2 unit of time is required to rot all oranges.
 * 
 * @author Govind
 *
 */
public class RottenOranges {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] lengths = br.readLine().trim().split(" ");
			int r = Integer.parseInt(lengths[0]);
			int c = Integer.parseInt(lengths[1]);
			// String[] elements = br.readLine().trim().split(" ");
			int[] elements = Arrays.asList(br.readLine().trim().split(" ")).stream().mapToInt(Integer::parseInt)
					.toArray();
			int elementsIndex = 0;
			int[][] array = new int[r][c];
			int[][] ongoingArray = new int[r][c];
			for (int p = 0; p < r; p++) {
				for (int q = 0; q < c; q++) {
					// int value = Integer.parseInt(elements[elementsIndex]);
					int value = elements[elementsIndex];
					array[p][q] = value;
					ongoingArray[p][q] = value;
					elementsIndex++;
				}
			}

			// Now data input is done. Start the actual logic
			int noOfTurns = 0;
			boolean freshOneSorroundedByAll0sFound = false;
			while (true) {
				int noOf1s = 0;
				for (int p = 0; p < r; p++) {
					for (int q = 0; q < c; q++) {
						// If it is 0 or 2 ignore
						if (array[p][q] == 1) {
							noOf1s++;
							// 1. We have to check the adjucent elements and while doing so we have figure
							// out whether the adjucent elements indexes are valid
							int validIndexCount = 0, sourrounding0sCount = 0;
							if (isValidIndex(p - 1, 0, r - 1)) {
								validIndexCount++;
								if (array[p - 1][q] == 2) {
									ongoingArray[p][q] = 2;
									continue;
								} else if (array[p - 1][q] == 0) {
									sourrounding0sCount++;
								}
							}
							if (isValidIndex(p + 1, 0, r - 1)) {
								validIndexCount++;
								if (array[p + 1][q] == 2) {
									ongoingArray[p][q] = 2;
									continue;
								} else if (array[p + 1][q] == 0) {
									sourrounding0sCount++;
								}
							}
							if (isValidIndex(q - 1, 0, c - 1)) {
								validIndexCount++;
								if (array[p][q - 1] == 2) {
									ongoingArray[p][q] = 2;
									continue;
								} else if (array[p][q - 1] == 0) {
									sourrounding0sCount++;
								}
							}
							if (isValidIndex(q + 1, 0, c - 1)) {
								validIndexCount++;
								if (array[p][q + 1] == 2) {
									ongoingArray[p][q] = 2;
									continue;
								} else if (array[p][q + 1] == 0) {
									sourrounding0sCount++;
								}
							}
							if (validIndexCount == sourrounding0sCount) {
								// This element is all sourrounded by 0s and it is never gonna be rotten
								// So we can very well break this loop
								freshOneSorroundedByAll0sFound = true;
								break;
							}
						}
					}
					if (freshOneSorroundedByAll0sFound)
						break;
				}
				if (freshOneSorroundedByAll0sFound) {
					output.append("-1\n");
					break;
				} else if (noOf1s == 0) {
					// No fresh oranges
					output.append(noOfTurns + "\n");
					break;
				} else {
					if (noOf1s == 1) {
						// No fresh oranges
						noOfTurns++;
						output.append(noOfTurns + "\n");
						break;
					}
					noOfTurns++;
					array = ongoingArray.clone();
					for (int p = 0; p < array.length; p++) {
						array[p] = array[p].clone();
					}
				}
			}
		}
		System.out.println(output);
	}

	static boolean isValidIndex(int i, int min, int max) {
		if (i >= min && i <= max)
			return true;
		return false;
	}
}
