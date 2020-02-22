package com.challenges.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
 * 
 * Given two numbers represented by two linked lists of size N and M. The task
 * is to return a sum list. The sum list which is a linked list representation
 * of addition of two input numbers.
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * first line of input contains length of first linked list and next line
 * contains N elements of the linked list. Again, next line contains M, and
 * following line contains M elements of the linked list.
 * 
 * Output: Output the resultant linked list.
 * 
 * User Task: The task is to complete the function addTwoLists() which has node
 * reference of both the linked lists and returns the head of new list.
 * 
 * Constraints: 1 <= T <= 100 1 <= N, M <= 100
 * 
 * Example: Input: 2 2 4 5 3 3 4 5 2 6 3 1 7
 * 
 * Output: 0 9 3 0 7
 * 
 * Explaination: 5->4 // linked list repsentation of 45. 5->4->3 // linked list
 * representation of 345. 0->9 ->3 // linked list representation of 390
 * resultant linked list.
 * 
 * @author Govind
 *
 */
public class AddTwoNumbersRepresentedByLinkedLists {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int ll1Length = Integer.parseInt(br.readLine());
			String[] ll1Elements = br.readLine().trim().split(" ");
			LinkedList ll1 = new LinkedList();
			for (int j = ll1Elements.length - 1; j >= 0; j--) {
				ll1.insertAtHead(Integer.parseInt(ll1Elements[j]));
			}
			int ll2length = Integer.parseInt(br.readLine());
			String[] ll2Elements = br.readLine().trim().split(" ");
			LinkedList ll2 = new LinkedList();
			for (int j = ll2Elements.length - 1; j >= 0; j--) {
				ll2.insertAtHead(Integer.parseInt(ll2Elements[j]));
			}
			Node sumHead = addTwoLists(ll1.head, ll2.head);
			Node current = sumHead;
			StringBuilder sb = new StringBuilder();
			while (current.next != null) {
				sb.append(current.data + " ");
				current = current.next;
			}
			sb.append(current.data);
			output.append(sb + "\n");
		}
		System.out.println(output);
	}

	private static Node addTwoLists(Node first, Node second) {
		Node sumNode = null;
		Node sumHead = null;
		int leftOver = 0;
		while (true) {
			int sum = leftOver;
			if (first != null) {
				sum += first.data;
				first = first.next;
			}
			if (second != null) {
				sum += second.data;
				second = second.next;
			}
			leftOver = 0;
			if (sum > 9) {
				String num = sum + "";
				leftOver = Integer.parseInt(num.substring(0, num.length() - 1));
				sum = Integer.parseInt(num.substring(num.length() - 1, num.length()));
			}
			if (sumHead == null) {
				sumNode = new Node(sum);
				sumHead = sumNode;
			}

			else {
				sumNode.next = new Node(sum);
				sumNode = sumNode.next;
			}

			if (first == null && second == null && leftOver <= 0) {
				break;
			}
		}
		return sumHead;
	}
}
