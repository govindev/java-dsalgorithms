package com.challenges.leetcode.twentyone.feb;

import java.util.Stack;

/***
 * Validate Stack Sequences
 * 
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3653/
 * 
 * @author Govind
 *
 */
public class ValidateStackSequences {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int j = 0;
		while (i < pushed.length) {
			if (pushed[i] != popped[j]) {
				stack.push(pushed[i]);
				i++;
			} else {
				while (!stack.isEmpty() && stack.peek() == popped[j + 1]) {
					stack.pop();
					j++;
				}
				i++;
				j++;
			}
		}
		while (j < popped.length) {
			if (popped[j] == stack.peek()) {
				stack.pop();
				j++;
			} else {
				return false;
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}
}
