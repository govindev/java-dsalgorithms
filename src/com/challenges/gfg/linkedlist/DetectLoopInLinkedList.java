package com.challenges.gfg.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
 * 
 * Given a linked list of N nodes. The task is to check if the the linked list
 * has a loop. Linked list can contain self loop.
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * first line of input contains length of linked list and next line contains the
 * data of linked list.
 * 
 * Output: For each testcase, print "True", if linked list contains loop, else
 * print "False".
 * 
 * User Task: The task is to complete the function detectloop() which contains
 * reference to the head as only argument. This function should return 1 if
 * linked list contains loop, else return 0.
 * 
 * Constraints: 1 <= T <= 50 1 <= N <= 300
 * 
 * Example: Input: 2 3 1 3 4 2 4 1 8 3 4 0
 * 
 * Output: True False
 * 
 * Explaination: Testcase 1: In above test case N = 3. The linked list with
 * nodes N = 3 is given. Then value of x=2 is given which means last node is
 * connected with xth node of linked list. Therefore, there exists a loop.
 * 
 * Testcase 2: For N = 4 x = 0 means then lastNode->next = NULL, then the Linked
 * list does not contains any loop.
 * 
 * @author Govind
 *
 */
public class DetectLoopInLinkedList {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int length = Integer.parseInt(br.readLine());
			String[] sElements = br.readLine().trim().split(" ");
			int loopedToElementIndex = Integer.parseInt(br.readLine());
			LinkedList ll = new LinkedList();
			Node last = null;
			for (int j = length - 1; j >= 0; j--) {
				ll.insertAtHead(Integer.parseInt(sElements[j]));
				if (j == length - 1) {
					// Last element insertion
					last = ll.head;
				}
				if ((j + 1) == loopedToElementIndex) {
					// There is a loop. The last node of the Linked list forms a loop by pointing to
					// this Node
					last.next = ll.head;
				}
			}
			output.append((detectLoop2(ll.head) == 1) ? "True\n" : "False\n");
		}
		System.out.println(output);
	}

	/**
	 * Approach 2 : Using two pointers
	 * 
	 * @param head
	 * @return
	 */
	private static int detectLoop2(Node head) {
		Node pointer1 = head, pointer2 = head;
		while (pointer1.next != null && pointer2.next != null && pointer2.next.next != null) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next.next;
			if (pointer1 == pointer2) {
				return 1;
			}
		}
		return 0;
	}

	/**
	 * Approach 1 : To back traverse and check whether this node exists previously
	 * 
	 * @param head
	 * @return
	 */
	private static int detectLoop(Node head) {
		Node current = head;
		int count = 1;
		while (current.next != null) {
			current = current.next;
			boolean isExists = isExistsAlready(head, current, count);
			count++;
			if (isExists)
				return 1;
		}
		return 0;
	}

	static boolean isExistsAlready(Node head, Node prevNode, int prevCount) {
		Node current = head;
		while (prevCount > 0) {
			if (current == prevNode) {
				return true;
			}
			current = current.next;
			prevCount--;
		}
		return false;
	}
}
