package com.leetcode.topinterviewquestions;

import java.util.Stack;

public class ValidParantheses {
	public static void main(String[] args) {
		String s = "()[]{}";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {
		// Much cleaner
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			if (a == '(' || a == '[' || a == '{')
				stack.push(a);
			else if (stack.empty())
				return false;
			else if (a == ')' && stack.pop() != '(')
				return false;
			else if (a == ']' && stack.pop() != '[')
				return false;
			else if (a == '}' && stack.pop() != '{')
				return false;
		}
		return stack.empty();
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
