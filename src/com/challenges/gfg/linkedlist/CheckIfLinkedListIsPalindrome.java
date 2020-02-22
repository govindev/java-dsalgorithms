package com.challenges.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
 * 
 * Given a singly linked list of size N of integers. The task is to check if the
 * given linked list is palindrome or not.
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * first line of input contains length of linked list N and next line contains N
 * integers as data of linked list.
 * 
 * Output: For each test case output will be 1 if the linked list is a
 * palindrome else 0.
 * 
 * User Task: The task is to complete the function isPalindrome() which takes
 * head as reference as the only parameter and returns true or false if linked
 * list is palindrome or not respectively.
 * 
 * Constraints: 1 <= T <= 103 1 <= N <= 50
 * 
 * Example(To be used only for expected output): Input: 2 3 1 2 1 4 1 2 3 4
 * 
 * Output: 1 0
 * 
 * Explanation: Testcase 1: 1 2 1, linked list is palindrome.
 * 
 * @author Govind
 *
 */

public class CheckIfLinkedListIsPalindrome {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int length = Integer.parseInt(br.readLine());
			String[] elements = br.readLine().trim().split(" ");
			LinkedList ll = new LinkedList();
			for (int j = length - 1; j >= 0; j--) {
				ll.insertAtHead(Integer.parseInt(elements[j]));
			}
			output.append((isPalindrome(ll.head)) ? "1\n" : "0\n");
		}
		System.out.println(output);
	}

	private static boolean isPalindrome(Node head) {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		while (current.next != null) {
			sb.append(current.data);
			current = current.next;
		}
		sb.append(current.data);
		if (sb.toString().equals(sb.reverse().toString())) {
			return true;
		}
		return false;
	}

}