package com.leetcode.topinterviewquestions;

import java.util.*;

public class CopyListWithRandomPointer {
	// Definition for a Node.
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		if (head == null)
			return head;
		// Constant space
		Node current = head;

		// This loop removes the next links in the original ll
		// Map original Node next to simillar Node in second ll
		// Map second ll Node next to simillar Nodes next in original ll
		while (current != null) {
			Node current2 = new Node(current.val);
			current2.next = current.next;
			current.next = current2;
			current = current2.next;
		}

		current = head;
		// This loop puts the random mappings simillar to the original ll in
		// second ll
		while (current != null) {
			Node current2 = current.next;
			current2.random = current.random == null ? null : current.random.next;
			current = current2.next;
		}

		Node newHead = head.next;
		current = head;
		// This loops removes the connections between simillar Nodes b/w two lls
		while (current != null) {
			Node current2 = current.next;
			current.next = current2.next;
			current2.next = current2.next == null ? null : current2.next.next;
			current = current.next;
		}
		return newHead;
	}

	public Node copyRandomListSpaceN(Node head) {
		// Linear space complexity
		// Solution 1
		Node current = head;
		Map<Node, Node> mappings = new HashMap<>();
		while (current != null) {
			Node copyCurrent = new Node(current.val);
			mappings.put(current, copyCurrent);
			current = current.next;
		}
		current = head;
		while (current != null) {
			Node copyCurrent = mappings.get(current);
			copyCurrent.next = mappings.get(current.next);
			copyCurrent.random = mappings.get(current.random);
			current = current.next;
		}
		return mappings.get(head);
	}
}