package com.leetcode.thirtydaychallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/***
 * Min Stack
 * 
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3292/
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 * 
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
 * minStack.push(-3); minStack.getMin(); --> Returns -3. minStack.pop();
 * minStack.top(); --> Returns 0. minStack.getMin(); --> Returns -2.
 * 
 * @author Govind
 *
 */
public class MinStackImpl {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().trim().split(",");
		// Fill the stack
		MinStack obj = new MinStack();
		for (int i = 0; i < strArr.length; i++) {
			obj.push(Integer.parseInt(strArr[i]));
		}
		// Find the min of the stack
		System.out.println("Min of the stack is : " + obj.getMin());
	}
}

class MinStack {

	Node head = null;

	/** initialize your data structure here. */
	public MinStack() {
		this.head = null;
	}

	public void push(int x) {
		Node newNode = new Node(x);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void pop() {
		if (head != null) {
			head = head.next;
		}
	}

	public int top() {
		return head.value;
	}

	public int getMin() {
		// Traverse through the entire Linked List
		Node current = head;
		int min = head.value;
		while (current != null) {
			if (current.value < min) {
				min = current.value;
			}
			current = current.next;
		}
		return min;
	}
}

class Node {
	int value;
	Node next;

	public Node(int value) {
		this.value = value;
	}
}