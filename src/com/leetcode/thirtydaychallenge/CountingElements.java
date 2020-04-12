package com.leetcode.thirtydaychallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/***
 * Counting Elements
 * 
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/
 * 
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * 
 * If there're duplicates in arr, count them seperately.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,2,3] Output: 2 Explanation: 1 and 2 are counted cause 2 and 3
 * are in arr. Example 2:
 * 
 * Input: arr = [1,1,3,3,5,5,7,7] Output: 0 Explanation: No numbers are counted,
 * cause there's no 2, 4, 6, or 8 in arr. Example 3:
 * 
 * Input: arr = [1,3,2,3,5,0] Output: 3 Explanation: 0, 1 and 2 are counted
 * cause 1, 2 and 3 are in arr. Example 4:
 * 
 * Input: arr = [1,1,2,2] Output: 2 Explanation: Two 1s are counted cause 2 is
 * in arr.
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 1000 0 <= arr[i] <= 1000
 * 
 * @author Govind
 *
 */

public class CountingElements {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().trim().split(",");
		int[] arr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		System.out.println("Count of the elements : " + countElements(arr));
	}

	private static int countElements(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int searchElement = arr[i] + 1;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == searchElement) {
					count++;
					break;
				}
			}
		}
		return count;
	}
}