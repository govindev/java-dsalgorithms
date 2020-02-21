package com.challenges.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1
 * 
 * Given a singly linked list of size N. The task is to rotate the linked list
 * counter-clockwise by k nodes, where k is a given positive integer smaller
 * than or equal to length of the linked list.
 * 
 * Input Format: First line of input contains number of testcases T. For each
 * testcase, first line of input contains length of linked list and next line
 * contains linked list elements and last line contains k, by which linked list
 * is to be rotated.
 * 
 * Output Format: For each testcase, print the rotated linked list.
 * 
 * User Task: The task is to complete the function rotate() which takes head
 * reference as the first argument and k as the second argument. The printing is
 * done automatically by the driver code.
 * 
 * Constratints: 1 <= T <= 100 1 <= N <= 103 1 <= k <= 103
 * 
 * Example: Input: 3 8 1 2 3 4 5 6 7 8 4 5 2 4 7 8 9 3 2 1 2 4
 * 
 * Output: 5 6 7 8 1 2 3 4 8 9 2 4 7 1 2
 * 
 * Explanation: Testcase 1: After rotating the linked list by 4 elements
 * (anti-clockwise), we reached to node 5, which is (k+1)th node from beginning,
 * now becomes head and tail of the linked list is joined to the previous head.
 * 
 * @author Govind
 *
 */
public class RotateALinkedList {
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
			int noOfRoatations = Integer.parseInt(br.readLine());
			ll.roatate(noOfRoatations);
			output.append(ll.getPrintString() + "\n");
		}
		System.out.println(output);
	}
}
