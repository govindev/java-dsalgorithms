package com.challenges.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
 * 
 * Given a linked list of N nodes where nodes can contain values 0s, 1s and 2s
 * only. The task is to segregate 0s, 1s and 2s linked list such that all zeros
 * segregate to headside, 2s at the end of the linked list and 1s in the mid of
 * 0s and 2s.
 * 
 * Input Format: First line of input contains number of testcases T. For each
 * testcase, first line of input contains length of linked list and next line
 * contains N elements as the data in the linked list.
 * 
 * Output Format: For each testcase, segregate the 0s, 1s and 2s and display the
 * linked list.
 * 
 * Your Task: The task is to complete the function segregate() which segregate
 * the nodes in the linked list as asked in the problem statement. The printing
 * is done automatically by the driver code.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 103
 * 
 * User Task: The task is to complete the function sortList() which takes head
 * reference as the argument and returns void.
 * 
 * Example: Input: 2 8 1 2 2 1 2 0 2 2 4 2 2 0 1
 * 
 * Output: 0 1 1 2 2 2 2 2 0 1 2 2
 * 
 * Explanation: Testcase 1: All the 0s are segregated to left end of the linked
 * list, 2s to the right end of the list and 1s in between.
 * 
 * @author Govind
 *
 */
public class GivenALinkedListOf0s1sAnd2sSortIt {
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
			head = segragate(head);
			current = head;
			StringBuilder sb = new StringBuilder();
			while (current != null) {
				sb.append(current.data + " ");
				current = current.next;
			}
			// Sort the numbers
			output.append(sb + "\n");
		}
		System.out.println(output);

	}

	private static Node segragate(Node head) {
		Node current = head;
		int[] countOfNos = { 0, 0, 0 };
		while (current != null) {
			if (current.data == 0)
				countOfNos[0]++;
			else if (current.data == 1)
				countOfNos[1]++;
			else
				countOfNos[2]++;
			current = current.next;
		}
		current = head;
		while (current != null) {
			if (countOfNos[0] > 0) {
				current.data = 0;
				countOfNos[0] = countOfNos[0] - 1;
			} else if (countOfNos[1] > 0) {
				current.data = 1;
				countOfNos[1] = countOfNos[1] - 1;
			} else if (countOfNos[2] > 0) {
				current.data = 2;
				countOfNos[2] = countOfNos[2] - 1;
			}
			current = current.next;
		}
		return head;
	}
}