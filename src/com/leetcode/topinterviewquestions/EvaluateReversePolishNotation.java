package com.leetcode.topinterviewquestions;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<>();
		int i = 0;
		stack.push(tokens[i++]);
		while (!stack.isEmpty() && i < tokens.length) {
			String ch = tokens[i];
			if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
				// Pop last two elements
				int post = Integer.parseInt(stack.pop());
				int pre = Integer.parseInt(stack.pop());
				int res = 0;
				switch (ch) {
				case "+":
					res = pre + post;
					break;
				case "-":
					res = pre - post;
					break;
				case "*":
					res = pre * post;
					break;
				case "/":
					res = pre / post;
					break;
				}
				if (i == tokens.length - 1)
					return res;
				else
					stack.push(res + "");
			} else {
				stack.push(tokens[i]);
			}
			i++;
		}
		return Integer.parseInt(stack.pop());
	}
}
