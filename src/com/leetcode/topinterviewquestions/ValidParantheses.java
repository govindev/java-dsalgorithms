package com.leetcode.topinterviewquestions;

import java.util.Stack;

public class ValidParantheses {
	public static void main(String[] args) {
		String s = "()[]{}";
		ValidParantheses validParantheses = new ValidParantheses();
		System.out.println(validParantheses.isValid(s));
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (isOpeningCharacter(ch)) {
				stack.push(ch);
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char lastCh = stack.peek();
			if (!arePair(lastCh, ch)) {
				return false;
			}
			stack.pop();
		}
		return stack.isEmpty();
	}

	private boolean isOpeningCharacter(char ch) {
		return (ch == '(' || ch == '[' || ch == '{');
	}

	private boolean arePair(char start, char end) {
		switch(end) {
			case ']': return start == '[';
			case ')': return start == '(';
			case '}': return start == '{';
			default: return false;
		}
	}

	public static boolean isValidNaive(String s) {
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			Character ch = s.charAt(i);
			if (ch == ')' || ch == ']' || ch == '}') {
				if (stack.size() < 1)
					return false;
				Character prev = stack.peek();
				if (ch == ')') {
					if (prev == '(') {
						stack.pop();
					} else {
						return false;
					}
				}
				if (ch == ']') {
					if (prev == '[') {
						stack.pop();
					} else {
						return false;
					}
				}
				if (ch == '}') {
					if (prev == '{') {
						stack.pop();
					} else {
						return false;
					}
				}
			} else {
				stack.push(ch);
			}

		}
		if (stack.size() < 1)
			return true;
		return false;
	}
}
