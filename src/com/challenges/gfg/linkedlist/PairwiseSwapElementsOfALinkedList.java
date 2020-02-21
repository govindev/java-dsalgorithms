package com.challenges.gfg.linkedlist;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data/1
 * 
 * Given a singly linked list of size N. The task is to swap elements in the
 * linked list pairwise.
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * first line of input contains length of linked list and next line contains
 * linked list data.
 * 
 * Output: Output the linked list after swapping pairwise nodes.
 * 
 * User Task: The task is to complete the function pairWiseSwap() which takes
 * head node as the only argument and returns the modified head.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 103
 * 
 * Example: Input: 1 8 1 2 2 4 5 6 7 8
 * 
 * Output: 2 1 4 2 6 5 8 7
 * 
 * Explanation: Testcase 1: After swapping each pair considering (1,2), (2, 4),
 * (5, 6).. so on as pairs, we get 2, 1, 4, 2, 6, 5, 8, 7 as new linked list.
 * 
 * @author Govind
 *
 */
public class PairwiseSwapElementsOfALinkedList {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int length = Integer.parseInt(br.readLine());
			String[] elements = br.readLine().trim().split(" ");
			LinkedList ll = new LinkedList();
			for (int j = elements.length - 1; j >= 0; j--) {
				ll.insertAtHead(Integer.parseInt(elements[j]));
			}
			pairwiseSwap(ll.head);
			output.append(ll.getPrintString());
		}
		System.out.println(output);
	}

	private static Node pairwiseSwap(Node head) {
		Node e1 = head;
		while (e1.next != null) {
			Node e2 = e1.next;
			int temp = e1.data;
			e1.data = e2.data;
			e2.data = temp;

			if (e2.next == null)
				break;
			e1 = e2.next;
		}
		return head;
	}
}
