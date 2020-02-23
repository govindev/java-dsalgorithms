package com.challenges.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/implement-queue-using-linked-list/1
 * 
 * Implement a Queue using Linked List.
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
 * You are required to complete the two methods push which takes one argument an
 * integer 'x' to be pushed into the quee and pop which returns a integer poped
 * out from othe queue.
 * 
 * Your Task: Since this is a function problem, you don't need to take inputs.
 * Just complete the provided functions. The printing is done automatically by
 * the driver code.
 * 
 * Constraints: 1 <= T <= 100 1 <= Q <= 100 1 <= x <= 100
 * 
 * Example: Input: 2 5 1 2 1 3 2 1 4 2 4 1 2 2 2 1 3 Output: 2 3 2 -1
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
public class ImplementQueueUsingLinkedList {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int noOfQueries = Integer.parseInt(br.readLine());
			String[] data = br.readLine().trim().split(" ");
			MyQueue queue = new MyQueue();
			boolean lookForPushValue = false;
			for (int j = 0; j <= data.length - 1; j++) {
				int value = Integer.parseInt(data[j]);
				if (lookForPushValue) {
					queue.push(value);
					lookForPushValue = false;
				} else if (value == 1) {
					lookForPushValue = true;
				} else if (value == 2) {
					output.append(queue.pop() + " ");
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}
}

class MyQueue {
	QueueNode front, rear;

	// This function should add an item at
	// rear
	void push(int a) {
		QueueNode item = new QueueNode(a);
		// Your code here
		if (rear == null) {
			rear = item;
			front = item;
		} else {
			rear.next = item;
			rear = rear.next;
		}
	}

	// This function should remove front
	// item from queue and should return
	// the removed item.
	int pop() {
		// Your code here
		if (front != null) {
			int value = front.data;
			if (front == rear) {
				rear = rear.next;
			}
			front = front.next;
			return value;
		}
		return -1;
	}
}

class QueueNode {
	int data;
	QueueNode next;

	QueueNode(int a) {
		data = a;
		next = null;
	}
}
