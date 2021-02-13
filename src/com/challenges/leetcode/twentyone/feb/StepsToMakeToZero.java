package com.challenges.leetcode.twentyone.feb;

/***
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3637/
 * 
 * @author Govind
 *
 */
class StepsToMakeToZero {
	public int numberOfSteps(int num) {
		int numOfSteps = 0;
		while (num != 0) {
			if (num % 2 == 0) {
				num = num / 2;
			} else {
				num = num - 1;
			}
			numOfSteps++;
		}
		return numOfSteps;
	}
}