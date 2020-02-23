package com.challenges.gfg.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/***
 * https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1
 * 
 * You are given N elements and your task is to Implement a Stack in which you
 * can get minimum element in O(1) time.
 * 
 * Input: The first line of the input contains an integer 'T' denoting the
 * number of test cases. Then T test cases follow. First line of each test case
 * contains an integer Q denoting the number of queries. A Query Q may be of 3
 * Types: 1. 1 x (a query of this type means pushing 'x' into the stack) 2. 2 (a
 * query of this type means to pop element from stack and print the poped
 * element) 3. 3 (a query of this type means to print the minimum element from
 * the stack) The second line of each test case contains Q queries seperated by
 * space.
 * 
 * Output: The output for each test case will be space separated integers having
 * -1 if the stack is empty else the element poped out or min element from the
 * stack.
 * 
 * User Task: You are required to complete the three methods push() which take
 * one argument an integer 'x' to be pushed into the stack, pop() which returns
 * a integer poped out from the stack and getMin() which returns the min element
 * from the stack.
 * 
 * Constraints: 1 <= T <= 100 1 <= Q <= 100 1 <= x <= 100
 * 
 * Example: Input: 1 6 1 2 1 3 2 3 1 1 3
 * 
 * Output: 3 2 1
 * 
 * Explanation: Testcase 1: In the first test case for query 1 2 the stack will
 * be {2} 1 3 the stack will be {2 3} 2 poped element will be 3 the stack will
 * be {2} 3 min element will be 2 1 1 the stack will be {2 1} 3 min element will
 * be 1 and
 * 
 * @author Govind
 *
 */
public class GetMinimumElementFromStack {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int noOfQueries = Integer.parseInt(br.readLine());
			String[] data = br.readLine().trim().split(" ");
			GmeStack stack = new GmeStack();
			boolean lookForPushValue = false;
			for (int j = 0; j <= data.length - 1; j++) {
				int value = Integer.parseInt(data[j]);
				if (lookForPushValue) {
					stack.push(value);
					lookForPushValue = false;
				} else if (value == 1) {
					lookForPushValue = true;
				} else if (value == 2) {
					output.append(stack.pop() + " ");
				} else if (value == 3) {
					output.append(stack.getMin() + " ");
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}
}

class GmeStack {
	int minEle;
	Stack<Integer> s = new Stack<Integer>();

	/* returns min element from stack */
	int getMin() {
		// Your code here
		if (s.empty())
			return -1;
		return minEle;
	}

	/* returns poped element from stack */
	int pop() {
		// Your code here
		if (s.empty())
			return -1;
		int remElement = s.pop();
		if (remElement == minEle) {
			if (!s.empty()) {
				minEle = s.peek();
				// Find the next minimum
				Stack<Integer> s2 = new Stack<Integer>();
				while (!s.empty()) {
					int x = s.pop();
					if (x < minEle)
						minEle = x;
					s2.push(x);
				}
				while (!s2.empty()) {
					s.push(s2.pop());
				}
			}
		}
		return remElement;
	}

	/* push element x into the stack */
	void push(int x) {
		// Your code here
		if (s.empty())
			minEle = x;
		else if (x < minEle)
			minEle = x;
		s.push(x);
	}
}