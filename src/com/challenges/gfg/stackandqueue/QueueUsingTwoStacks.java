package com.challenges.gfg.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://practice.geeksforgeeks.org/problems/queue-using-two-stacks/1
 * 
 * Implement a Queue using 2 stacks s1 and s2 .
 * 
 * Input Format: The first line of the input contains an integer 'T' denoting
 * the number of test cases. Then T test cases follow. First line of each test
 * case contains an integer Q denoting the number of queries . A Query Q is of 2
 * Types (i) 1 x (a query of this type means pushing 'x' into the queue) (ii) 2
 * (a query of this type means to pop element from queue and print the poped
 * element) The second line of each test case contains Q queries seperated by
 * space.
 * 
 * Output Format: The output for each test case will be space separated integers
 * having -1 if the queue is empty else the element poped out from the queue .
 * You are required to complete the two methods push which take one argument an
 * integer 'x' to be pushed into the quee and pop which returns a integer poped
 * out from other queue.
 * 
 * Your Task: Since this is a function problem, you don't need to take inputs.
 * Just complete the provided functions. The printing is done automatically by
 * the driver code.
 * 
 * Constraints: 1 <= T <= 100 1 <= Q <= 100 1 <= x <= 100
 * 
 * Example: Input 2 5 1 2 1 3 2 1 4 2 4 1 2 2 2 1 4 Output 2 3 2 -1
 * 
 * Explanation: Testcase1: 1 2 the quee will be {2} 1 3 the queue will be {2 3}
 * 2 poped element will be 2 the queue will be {3} 1 4 the queue will be {3 4} 2
 * poped element will be 3
 * 
 * Note:The Input/Ouput format and Example given are used for system's internal
 * purpose, and should be used by a user for Expected Output only. As it is a
 * function problem, hence a user should not read any input from stdin/console.
 * The task is to complete the function specified, and not to write the full
 * code.
 * 
 * @author Govind
 *
 */
public class QueueUsingTwoStacks {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int noOfQueries = Integer.parseInt(br.readLine());
			String[] data = br.readLine().trim().split(" ");
			StackQueue queue = new StackQueue();
			boolean lookForPushValue = false;
			for (int j = 0; j <= data.length - 1; j++) {
				int value = Integer.parseInt(data[j]);
				if (value == 1) {
					lookForPushValue = true;
				} else if (lookForPushValue) {
					queue.insert(value);
					lookForPushValue = false;
				} else if (value == 2) {
					output.append(queue.remove() + " ");
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}
}

class StackQueue {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	/*
	 * The method insert to push element into the queue
	 */
	void insert(int B) {
		// Your code here
		s1.push(B);
	}

	/*
	 * The method remove which return the element popped out of the queue
	 */
	int remove() {
		// Your code here
		int x = (s1.empty()) ? -1 : 0;
		if (x != -1) {
			while (!s1.empty()) {
				x = s1.pop();
				if (!s1.empty()) {
					s2.push(x);
				}
			}
			while (!s2.empty()) {
				s1.push(s2.pop());
			}
		}
		return x;
	}
}