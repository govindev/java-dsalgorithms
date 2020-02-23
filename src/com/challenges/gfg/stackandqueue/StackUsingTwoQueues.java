package com.challenges.gfg.stackandqueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.io.IOException;

/**
 * Implement a Stack using two queues q1 and q2.
 * 
 * Input Format: The first line of the input contains an integer 'T' denoting
 * the number of test cases. Then T test cases follow. First line of each test
 * case contains an integer Q denoting the number of queries . A Query Q is of 2
 * Types (i) 1 x (a query of this type means pushing 'x' into the stack) (ii) 2
 * (a query of this type means to pop element from stack and print the poped
 * element) The second line of each test case contains Q queries seperated by
 * space.
 * 
 * Output Format: The output for each test case will be space separated integers
 * having -1 if the stack is empty else the element poped out from the stack .
 * You are required to complete the two methods push() which take one argument
 * an integer 'x' to be pushed into the stack and pop() which returns a integer
 * poped out from the stack.
 * 
 * Your Task: Since this is a function problem, you don't need to take inputs.
 * Just complete the provided functions push() and pop().
 * 
 * Constraints: 1 <= T <= 100 1 <= Q <= 100 1 <= x <= 100
 * 
 * Example: Input: 2 5 1 2 1 3 2 1 4 2 4 1 2 2 2 1 3
 * 
 * Output: 3 4 2 -1
 * 
 * Explanation: Testcase1: 1 2 the stack will be {2} 1 3 the stack will be {2 3}
 * 2 poped element will be 3 the stack will be {2} 1 4 the stack will be {2 4} 2
 * poped element will be 4
 * 
 * @author Govind
 *
 */
public class StackUsingTwoQueues {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int noOfQueries = Integer.parseInt(br.readLine());
			String[] data = br.readLine().trim().split(" ");
			Queues stack = new Queues();
			boolean lookForPushValue = false;
			for (int j = 0; j <= data.length - 1; j++) {
				int value = Integer.parseInt(data[j]);
				if (value == 1) {
					lookForPushValue = true;
				} else if (lookForPushValue) {
					stack.push(value);
					lookForPushValue = false;
				} else if (value == 2) {
					output.append(stack.pop() + " ");
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}
}

class Queues {
	Queue<Integer> q1 = new java.util.LinkedList<Integer>();
	Queue<Integer> q2 = new java.util.LinkedList<Integer>();

	/* The method pop which return the element poped out of the stack */
	int pop() {
		int x = -1;
		if (q1.isEmpty()) {
			return x;
		} else {
			while (!q1.isEmpty()) {
				x = q1.poll();
				if (!q1.isEmpty())
					q2.add(x);
			}
			while (!q2.isEmpty()) {
				q1.add(q2.poll());
			}
			return x;
		}

	}

	/* The method push to push element into the stack */
	void push(int a) {
		q1.add(a);

	}
}