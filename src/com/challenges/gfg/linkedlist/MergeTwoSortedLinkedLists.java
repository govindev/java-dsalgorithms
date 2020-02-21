package com.challenges.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
 * 
 * Given two sorted linked lists consisting of N and M nodes respectively. The
 * task is to merge both of the list (in-place) and return head of the merged
 * list.
 * 
 * Note: It is strongly recommended to do merging in-place using O(1) extra
 * space.
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * first line of input contains N and M, and next two line contains N and M
 * sorted elements in two lines for each.
 * 
 * Output: For each testcase, print the merged list in sorted form.
 * 
 * User Task: The task is to complete the function sortedMerge() which takes
 * references to the heads of two linked lists as the arguments and returns the
 * head of merged linked list.
 * 
 * Constraints: 1 <= T <= 200 1 <= N, M <= 103 1 <= Node's data <= 103
 * 
 * Example: Input: 2 4 3 5 10 15 40 2 3 20 2 2 1 1 2 4
 * 
 * Output: 2 3 5 10 15 20 40 1 1 2 4
 * 
 * Explanation: Testcase 1: After merging the two linked lists, we have merged
 * list as 2, 3, 5, 10, 15, 20, 40.
 * 
 * @author Govind
 *
 */
public class MergeTwoSortedLinkedLists {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] lengths = br.readLine().trim().split(" ");
			int ll1Len = Integer.parseInt(lengths[0]);
			int ll2len = Integer.parseInt(lengths[1]);
			String[] ll1Elements = br.readLine().trim().split(" ");
			String[] ll2Elements = br.readLine().trim().split(" ");
			LinkedList ll1 = new LinkedList();
			for (int j = ll1Len - 1; j >= 0; j--) {
				ll1.insertAtHead(Integer.parseInt(ll1Elements[j]));
			}
			LinkedList ll2 = new LinkedList();
			for (int j = ll2len - 1; j >= 0; j--) {
				ll2.insertAtHead(Integer.parseInt(ll2Elements[j]));
			}
			sortedMerge(ll1.head, ll2.head);
		}
	}

	private static Node sortedMerge(Node lHead, Node rHead) {
		Node newHead = null, lCurrent = lHead, rCurrent = rHead, nCurrent = null;
		if (lHead.data < rHead.data) {
			newHead = lHead;
			lCurrent = lHead.next;
		} else {
			newHead = rHead;
			rCurrent = rHead.next;
		}
		nCurrent = newHead;
		while (true) {
			if (lCurrent != null && rCurrent != null) {
				if (lCurrent.data < rCurrent.data) {
					nCurrent.next = lCurrent;
					lCurrent = lCurrent.next;
				} else {
					nCurrent.next = rCurrent;
					rCurrent = rCurrent.next;
				}
			} else if (lCurrent != null) {
				nCurrent.next = lCurrent;
				lCurrent = lCurrent.next;
			} else if (rCurrent != null) {
				nCurrent.next = rCurrent;
				rCurrent = rCurrent.next;
			} else {
				break;
			}
			nCurrent = nCurrent.next;
		}
		return newHead;
	}
}
