package com.challenges.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1/
 * 
 * There are two singly linked lists of size N and M in a system. But, due to
 * some programming error the end node of one of the linked list got linked into
 * one of the node of second list, forming a inverted Y shaped list. Write a
 * program to get the point where two linked lists intersect each other.
 * 
 * Y ShapedLinked List Above diagram shows an example with two linked list
 * having 15 as intersection point. Note: Expected time complexity is O(m + n)
 * where m and n are lengths of two linked lists.
 * 
 * Input: First line of input is the number of test cases T. Every test case has
 * four lines. First line of every test case contains three numbers, x (number
 * of nodes before merge point in 1st list), y (number of nodes before merge
 * point in 11nd list) and z (number of nodes after merge point). Next three
 * lines contain x, y and z values.
 * 
 * Output: Print the data of the node in the linked list where two linked lists
 * intersects.
 * 
 * Your Task: The task is to complete the function intersetPoint() which finds
 * the point of intersection of two linked list. The function should return data
 * value of a node where two linked lists merge. If linked list do not merge at
 * any point, then it shoudl return -1.
 * 
 * Constraints: 1 <= T <= 50 1 <= N <= 100 1 <= value <= 1000
 * 
 * Example: Input: 2 2 3 2 10 20 30 40 50 5 10 2 3 2 10 20 30 40 50 10 20
 * 
 * Output: 5 10
 * 
 * Explanation: Testcase 1: The point of intersection of two linked list is 5,
 * means both of them get linked (intersects) with each other at node whose
 * value is 5.
 * 
 * @author Govind
 *
 */

public class IntersectionPointInYShappedLinkedLists {
	private static int findIntersectionPoint(Node headA, Node headB) {
		Node currentA = headA;
		while (currentA.next != null) {
			Node currentB = headB;
			while (currentB.next != null) {
				if (currentA.data == currentB.data) {
					// Matched
					return currentA.data;
				}
				currentB = currentB.next;
			}
			currentA = currentA.next;
		}
		return -1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] lengths = br.readLine().trim().split(" ");
			int aLenBefore = Integer.parseInt(lengths[0]);
			int bLenBefore = Integer.parseInt(lengths[1]);
			int lenAfterMergePoint = Integer.parseInt(lengths[2]);
			String[] strABeforeElements = br.readLine().trim().split(" ");
			LinkedList all = new LinkedList();
			String[] strBBeforeElements = br.readLine().trim().split(" ");
			LinkedList bll = new LinkedList();
			String[] strAfterElements = br.readLine().trim().split(" ");
			for (int j = lenAfterMergePoint - 1; j >= 0; j--) {
				all.insertAtHead(Integer.parseInt(strAfterElements[j]));
				bll.insertAtHead(Integer.parseInt(strAfterElements[j]));
			}
			for (int j = aLenBefore - 1; j >= 0; j--) {
				all.insertAtHead(Integer.parseInt(strABeforeElements[j]));
			}
			for (int j = bLenBefore - 1; j >= 0; j--) {
				bll.insertAtHead(Integer.parseInt(strBBeforeElements[j]));
			}
			// Now find the intersection points of both the LinkedLists
			output.append(findIntersectionPoint(all.head, bll.head));
		}
		System.out.println(output);
	}
}
