package com.challenges.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/***
 * https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
 * 
 * Given a linked list consisting of L nodes and given a number N. The task is
 * to find the Nth node from the end of the linked list.
 * 
 * Input: First line of input contains number of testcase T. For each testcase,
 * first line of input contains number of nodes in the linked list and the
 * number N. Next line contains N nodes of linked list.
 * 
 * Output: For each testcase, output the data of node which is at Nth distance
 * from end.
 * 
 * User Task: The task is to complete the function getNthFromLast() which takes
 * two arguments: reference to head and N and you need to return Nth from end.
 * 
 * Constraints: 1 <= T <= 200 1 <= L <= 103 1 <= N <= 103
 * 
 * Example: Input: 2 9 2 1 2 3 4 5 6 7 8 9 4 5 10 5 100 5
 * 
 * Output: 8 -1
 * 
 * Explanation: Testcase 1: In the first example, there are 9 nodes in linked
 * list and we need to find 2nd node from end. 2nd node from end os 8. Testcase
 * 2: In the second example, there are 4 nodes in linked list and we need to
 * find 5th from end. Since 'n' is more than number of nodes in linked list,
 * output is -1.
 * 
 * @author Govind
 *
 */

public class NthNodeFromEndOfLinkedList {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] nos = br.readLine().trim().split(" ");
			int length = Integer.parseInt(nos[0]);
			int n = Integer.parseInt(nos[1]);
			String[] sElements = br.readLine().trim().split(" ");
			LinkedList ll = new LinkedList();
			for (int j = length - 1; j >= 0; j--) {
				ll.insertAtHead(Integer.parseInt(sElements[j]));
			}
			output.append(getNthFromLast(ll.head, n) + "\n");
		}
		System.out.println(output);
	}

	private static int getNthFromLast(Node head, int n) {
		// Figure out the length of the
		Node current = head;
		int count = 1;
		while (current.next != null) {
			current = current.next;
			count++;
		}
		// Length is the count
		// Now we have to find the nth element from the end of the list
		// What will be the equivalent index from start for the same
		int nFromStart = count - n;
		if (nFromStart < 0)
			return -1;
		current = head;
		while (nFromStart > 0) {
			current = current.next;
			nFromStart--;
		}
		return current.data;
	}

}