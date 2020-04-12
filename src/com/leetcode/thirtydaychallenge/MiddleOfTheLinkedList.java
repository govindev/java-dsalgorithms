package com.leetcode.thirtydaychallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/***
 * Middle of the Linked List
 * 
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3290/
 * 
 * Given a non-empty, singly linked list with head node head, return a middle
 * node of linked list.
 * 
 * If there are two middle nodes, return the second middle node.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5] Output: Node 3 from this list (Serialization: [3,4,5]) The
 * returned node has value 3. (The judge's serialization of this node is
 * [3,4,5]). Note that we returned a ListNode object ans, such that: ans.val =
 * 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 * 
 * Input: [1,2,3,4,5,6] Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second
 * one.
 * 
 * 
 * Note:
 * 
 * The number of nodes in the given list will be between 1 and 100.
 * 
 * @author Govind
 *
 */
public class MiddleOfTheLinkedList {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().trim().split(",");
		ListNode head = new ListNode(Integer.parseInt(strArr[0]));
		ListNode prevNode = head;
		for (int i = 1; i < strArr.length; i++) {
			ListNode node = new ListNode(Integer.parseInt(strArr[i]));
			prevNode.next = node;
			prevNode = node;
		}
		ListNode middleNode = middleNode(head);
		// Print the elements from here
		StringBuilder output = new StringBuilder();
		while (middleNode != null) {
			output.append(middleNode.val + ", ");
			middleNode = middleNode.next;
		}
		System.out.println(output);
	}

	public static ListNode middleNode(ListNode head) {
		// Find the length of the Linked List
		ListNode current = head;
		int length = 0;
		while (current != null) {
			length++;
			current = current.next;
		}
		// Find the mid
		int mid = length / 2;
		// Travel till the mid and return the node
		int i = 0;
		current = head;
		while (i < mid) {
			current = current.next;
			i++;
		}
		return current;
	}
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
