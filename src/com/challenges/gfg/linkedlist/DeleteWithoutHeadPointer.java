package com.challenges.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
 * 
 * You are given a pointer/ reference to the node which is to be deleted from
 * the linked list of N nodes. The task is to delete the node. Pointer/
 * reference to head node is not given.
 * 
 * Note: No head reference is given to you.
 * 
 * Input Format: First line of input contains number of testcases T. For each
 * testcase, first line of input contains length of linked list and next line
 * contains the data of the linked list. The last line contains the node to be
 * deleted.
 * 
 * Output Format: For each testcase, in a newline, print the linked list after
 * deleting the given node.
 * 
 * Your Task: This is a function problem. You only need to complete the function
 * deleteNode that takes reference to the node that needs to be deleted. The
 * printing is done automatically by the driver code.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 103
 * 
 * Example: Input: 2 2 1 2 1 4 10 20 4 30 20
 * 
 * Output: 2 10 4 30
 * 
 * Explanation: Testcase 1: After deleting 20 from the linked list, we have
 * remaining nodes as 10, 4 and 30.
 * 
 * @author Govind
 *
 */
public class DeleteWithoutHeadPointer {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int length = Integer.parseInt(br.readLine());
			String[] elements = br.readLine().trim().split(" ");
			Node head = null;
			Node current = null;
			for (int j = 0; j <= elements.length - 1; j++) {
				Node node = new Node(Integer.parseInt(elements[j]));
				if (head == null) {
					head = node;
					current = node;
				} else {
					current.next = node;
					current = current.next;
				}
			}
			int deleteValue = Integer.parseInt(br.readLine());
			current = head;
			while (current != null) {
				if (current.data == deleteValue) {
					// Delete this node which has the delete value
					deleteNode(current);
					break;
				}
				current = current.next;
			}

			// Print the linked list
			current = head;
			StringBuilder sb = new StringBuilder();
			while (current != null) {
				sb.append(current.data + " ");
				current = current.next;
			}
			output.append(sb + "\n");
		}
		System.out.println(output);

	}

	private static void deleteNode(Node node) {
		// Your code here
		while (node.next != null) {
			int data = node.next.data;
			node.next.data = node.data;
			node.data = data;
			if (node.next.next == null) {
				node.next = null;
			} else {
				node = node.next;
			}
		}
	}
}
