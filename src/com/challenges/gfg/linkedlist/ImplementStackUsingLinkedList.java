package com.challenges.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/implement-stack-using-linked-list/1
 * 
 * Let's give it a try! You have a linked list and you have to implement the
 * functionalities push and pop of stack using this given linked list.
 * 
 * Input: The first line of the input contains an integer 'T' denoting the
 * number of test cases. Then T test cases follow. First line of each test case
 * contains an integer Q denoting the number of queries. A Query Q is of 2 Types
 * (i) 1 x (a query of this type means pushing 'x' into the stack) (ii) 2 (a
 * query of this type means to pop element from stack and print the poped
 * element) The second line of each test case contains Q queries seperated by
 * space.Output: The output for each test case will be space separated integers
 * having -1 if the stack is empty else the element poped out from the stack .
 * 
 * Your Task: You are required to complete the two methods push() which take one
 * argument an integer 'x' to be pushed into the stack and pop() which returns a
 * integer poped out from the stack.
 * 
 * Constraints: 1 <= T <= 100 1 <= Q <= 100 1 <= x <= 100
 * 
 * Example: Input: 2 5 1 2 1 3 2 1 4 2 4 2 1 4 1 5 2
 * 
 * Output: 3 4 -1 5
 * 
 * Explanation: Testcase 1: In the first test case for query 1 2 the stack will
 * be {2} 1 3 the stack will be {2 3} 2 poped element will be 3 the stack will
 * be {2} 1 4 the stack will be {2 4} 2 poped element will be 4
 * 
 * @author Govind
 *
 */
public class ImplementStackUsingLinkedList {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int noOfQueries = Integer.parseInt(br.readLine());
			String[] data = br.readLine().trim().split(" ");
			MyStack stack = new MyStack();
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
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}
}

class MyStack {

	// Note that top is by default null
	// in Java
	StackNode top;

	void push(int a) {
		// Add your code here
		StackNode newNode = new StackNode(a);
		if (top != null) {
			newNode.next = top;
			top = newNode;
		} else {
			top = newNode;
		}

	}

	int pop() {
		// Add your code here
		if (top != null) {
			int value = top.data;
			top = top.next;
			return value;
		}
		return -1;
	}
}

class StackNode {
	int data;
	StackNode next;

	StackNode(int a) {
		data = a;
		next = null;
	}
}
