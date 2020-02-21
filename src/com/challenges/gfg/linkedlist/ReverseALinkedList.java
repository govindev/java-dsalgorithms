package com.challenges.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
 * 
 * Given a linked list of N nodes. The task is to reverse this list.
 * 
 * Input: Head of following linked list 1->2->3->4->NULL Output: Linked list
 * should be changed to, 4->3->2->1->NULL
 * 
 * Input: Head of following linked list 1->2->3->4->5->NULL Output: Linked list
 * should be changed to, 5->4->3->2->1->NULL
 * 
 * Input: NULL Output: NULL
 * 
 * Input: 1->NULL Output: 1->NULL
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * first line contains length of linked list and next line contains the elements
 * of linked list.
 * 
 * Output: Reverse the linked list and return head of the modified list.
 * 
 * User Task: The task is to complete the function reverseList() which head
 * reference as the only argument and should return new head after reversing the
 * list.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 103
 * 
 * Example: Input: 2 6 1 2 3 4 5 6 5 2 7 8 9 10
 * 
 * Output: 6 5 4 3 2 1 10 9 8 7 2
 * 
 * Explanation: Testcase 1: After reversing the list, elements are as
 * 6->5->4->3->2->1.
 * 
 * @author Govind
 *
 */
public class ReverseALinkedList {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int length = Integer.parseInt(br.readLine());
			String[] sElements = br.readLine().trim().split(" ");
			LinkedList ll = new LinkedList();
			for (int j = length - 1; j >= 0; j--) {
				ll.insertAtHead(Integer.parseInt(sElements[j]));
			}

			// Reverse the linked list
			Node head = ll.head;
			reverse(head);
			ll.head = newHead;
			head.next = null;

			// Print the linked list
			Node current = ll.head;
			while (current.next != null) {
				output.append(current.data + " ");
				current = current.next;
			}
			output.append(current.data + "\n");
		}
		System.out.println(output);
	}

	private static Node newHead;

	private static Node reverse(Node current) {
		if (current.next == null) {
			// this is the new head
			newHead = current;
			return current;
		} else {
			Node next = reverse(current.next);
			current.next = null;
			next.next = current;
			return current;
		}
	}
}
