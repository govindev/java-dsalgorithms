package com.challenges.leetcode.twentyone.feb;

import java.util.Stack;

/***
 * Score of Parentheses
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3651/
 * 
 * @author Govind
 *
 */

public class ScoreOfParentheses {
	public int scoreOfParentheses(String S) {
		Stack<Integer> stack = new Stack<Integer>();
		int score = 0;
		for (int i = 0; i < S.length(); i++) {
			Character c = S.charAt(i);
			if (c == '(') {
				// Assume '(' as -1
				stack.push(-1);
			} else if (c == ')') {
				Integer peek = stack.peek();
				if (peek == -1) {
					stack.pop();

					Integer val = 1;
					if (!stack.isEmpty()) {
						peek = stack.peek();
						if (peek > 0) {
							val = peek + 1;
							stack.pop();
						}
					}
					stack.push(val);
					score = val;
				} else {
					// If it is a number
					stack.pop();
					stack.pop();
					Integer val = 2 * peek;

					if (!stack.isEmpty()) {
						peek = stack.peek();
						if (peek != -1) {
							val += peek;
							stack.pop();
						}
					}
					stack.push(val);
					score = score > val ? score : val;
				}
			}
		}
		return score;
	}
}
