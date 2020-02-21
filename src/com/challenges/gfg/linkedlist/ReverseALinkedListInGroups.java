package com.challenges.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
 * 
 * Given a linked list of size N. The task is to reverse every k nodes (where k
 * is an input to the function) in the linked list.
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * first line contains length of linked list and next line contains the linked
 * list elements.
 * 
 * Output: For each testcase, there will be a single line of output which
 * contains the linked list with every k group elements reversed.
 * 
 * User Task: The task is to complete the function reverse() which should
 * reverse the linked list in group of size k.
 * 
 * Example: Input: 2 8 1 2 2 4 5 6 7 8 4 5 1 2 3 4 5 3
 * 
 * Output: 4 2 2 1 8 7 6 5 3 2 1 5 4
 * 
 * Explanation: Testcase 1: Since, k = 4. So, we have to reverse everty group of
 * two elements. Modified linked list is as 4, 2, 2, 1, 8, 7, 6, 5.
 * 
 * @author Govind
 *
 */
public class ReverseALinkedListInGroups {
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
			int groupSize = Integer.parseInt(br.readLine());
			ll.reverseInGroups(groupSize);
			output.append(ll.getPrintString() + "\n");
		}
		System.out.println(output);
	}
}
