package com.challenges.gfg.stackandqueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/***
 * https://practice.geeksforgeeks.org/problems/parenthesis-checker/0
 * 
 * Given an expression string exp. Examine whether the pairs and the orders of
 * “{“,”}”,”(“,”)”,”[“,”]” are correct in exp. For example, the program should
 * print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp =
 * “[(])”
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. Each test case consists of a string of expression, in a separate
 * line.
 * 
 * Output: Print 'balanced' without quotes if the pair of parenthesis is
 * balanced else print 'not balanced' in a separate line.
 * 
 * Constraints: 1 ≤ T ≤ 100 1 ≤ |s| ≤ 105
 * 
 * Example: Input: 3 {([])} () ([]
 * 
 * Output: balanced balanced not balanced
 * 
 * @author Govind
 *
 */

public class ParenthesisChecker {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String str = br.readLine().trim();
			StackCh newStack = new StackCh();
			boolean isBalanced = true;
			for (int j = 0; j <= str.length() - 1; j++) {
				char ch = str.charAt(j);
				if (ch == '{' || ch == '(' || ch == '[') {
					newStack.push(ch);
				} else {
					char popedCharacter = newStack.pop();
					if (ch == '}' && popedCharacter == '{') {
						continue;
					} else if (ch == ')' && popedCharacter == '(') {
						continue;
					} else if (ch == ']' && popedCharacter == '[') {
						continue;
					} else {
						isBalanced = false;
						break;
					}
				}
			}
			if (newStack.top != null) {
				isBalanced = false;
			}
			output.append((isBalanced) ? "balanced\n" : "not balanced\n");
		}
		System.out.println(output);
	}
}

class StackCh {
	StackChNode top;

	void push(char ch) {
		StackChNode newNode = new StackChNode(ch);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	char pop() {
		if (top != null) {
			char ch = top.ch;
			top = top.next;
			return ch;
		}
		return ' ';
	}
}

class StackChNode {
	char ch;
	StackChNode next;

	StackChNode(char ch) {
		this.ch = ch;
		this.next = null;
	}
}