package com.challenges.leetcode.twentyone.feb;

import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3629/
 * 
 * @author Govind
 *
 */
public class SimplifyPath {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		System.out.println(simplifyPath1(str));
	}

	private static String simplifyPath1(String s) {
		Stack<String> stack = new Stack<>();
		String[] vals = s.split("/");

		for (String val : vals) {
			if (val.equals("..") && !stack.isEmpty()) {
				stack.pop();
			} else if (!val.equals(".") && !val.equals("..") && !val.equals("")) {
				stack.push(val);
			}
		}
		return "/" + String.join("/", stack);
	}

	private static String simplifyPath(String s) {
		Stack1 stack = new Stack1();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// Before pushing
			char top = stack.top();
			if (c == '/' && top == '/') {
				// push is not required
				continue;
			}
			if (c == '/' && top == '.') {
				// remove the . and don't push /
				stack.pop();
				continue;
			}
			if (c == '.' && top == '.') {
				// remove the prev directory and don't push this .
				// eg : /a/b/.. should be /a/
				stack.pop(); // 1st dot
				stack.pop(); // 1st /
				while (stack.top() != '/') {
					stack.pop(); // removed the directory name
				}
				continue;
			}
			stack.push(c);
		}
		// Reversed String
		StringBuilder sp = new StringBuilder();
		while (stack.top() != 0) {
			char top = stack.pop();
			sp.append(top);
		}
		String simPath = sp.toString();
		simPath = simPath.substring(0, simPath.length() - 1);
		return simPath;
	}
}

class Node {
	char value;
	Node prev;

	public char getValue() {
		return value;
	}

	public Node getPrev() {
		return prev;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
}

class Stack1 {
	Node top;

	public char pop() {
		if (top == null)
			return 0;
		char val = top.getValue();
		top = top.getPrev();
		return val;
	}

	public void push(char value) {
		Node curr = new Node();
		curr.setValue(value);
		curr.setPrev(top);
		top = curr;
	}

	public char top() {
		if (top == null)
			return 0;
		return top.getValue();
	}

}
