package com.challenges.leetcode.twentyone.feb;

import java.util.Stack;

public class MinRemoveToValidParantheses {
	public String minRemoveToMakeValid(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder newString = new StringBuilder("");
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(newString.length());
				newString.append(c);
			} else if (c == ')') {
				if (!stack.isEmpty()) {
					stack.pop();
					newString.append(c);
				}
			} else {
				newString.append(c);
			}
		}
		while (!stack.isEmpty()) {
			Integer remInd = stack.pop();
			newString = newString.deleteCharAt(remInd);
		}
		return newString.toString();
	}
}
