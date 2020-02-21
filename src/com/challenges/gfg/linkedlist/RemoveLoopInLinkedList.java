package com.challenges.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
 * 
 * You are given a linked list of N nodes. The task is to remove the loop from
 * the linked list, if present.
 * 
 * Input: First line of input contains number of testcases T. T testcases
 * follow. For each testcase, first line of input contains length N of the
 * linked list and next line contains N data of the linked list. The third line
 * contains the position of the node(from head) to which the last node will get
 * connected. If it is 0 then there is no loop.
 * 
 * Output: For each testcase, in a new line, 1 will be printed if loop is
 * removed(correct answer) else 0 will be printed(for wrong answer).
 * 
 * User Task: You don't have to read the input, or print the output. Just
 * complete the function removeTheLoop() which has only argument as head
 * reference of the linked list. If you complete this function in correct way
 * and loop gets removed, the answer will be 1.
 * 
 * Constraints: 1 <= T <= 50 1 <= N <= 300
 * 
 * Example: Input: 2 3 1 3 4 2 4 1 8 3 4 0
 * 
 * Output: 1 1
 * 
 * Explanation: Testcase 1: In the first test case N = 3. The linked list with
 * nodes N = 3 is given. Here, x = 2 which means last node is connected with xth
 * node of linked list. Therefore, there exists a loop.
 * 
 * Testcase 2: N = 4 and x = 0, which means lastNode->next = NULL, thus the
 * Linked list does not contains any loop.
 * 
 * @author Govind
 *
 */
public class RemoveLoopInLinkedList {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int length = Integer.parseInt(br.readLine());
			String[] sElements = br.readLine().trim().split(" ");
			int loopedToElementIndex = Integer.parseInt(br.readLine());
			LinkedList ll = new LinkedList();
			Node last = null;
			for (int j = length - 1; j >= 0; j--) {
				ll.insertAtHead(Integer.parseInt(sElements[j]));
				if (j == length - 1) {
					// Last element insertion
					last = ll.head;
				}
				if ((j + 1) == loopedToElementIndex) {
					// There is a loop. The last node of the Linked list forms a loop by pointing to
					// this Node
					last.next = ll.head;
				}
			}
			output.append(removeTheLoop(ll.head) + "\n");
		}
		System.out.println(output);
	}

	private static int removeTheLoop(Node head) {
		Node current = head;
		Node prev = current;
		int count = 1;
		while (current.next != null) {
			prev = current;
			current = current.next;
			boolean isExists = isExistsAlready(head, current, count);
			count++;
			if (isExists) {
				// Remove the loop by making the next of the previous node to null
				prev.next = null;
				return 1;
			}

		}
		// No loop detected anyways
		return 1;
	}

	static boolean isExistsAlready(Node head, Node prevNode, int prevCount) {
		Node current = head;
		while (prevCount > 0) {
			if (current == prevNode) {
				return true;
			}
			current = current.next;
			prevCount--;
		}
		return false;
	}
}
