package com.leetcode.topinterviewquestions;

public class AddTwoNumbers {
	public static void main(String[] args) {
		int[] a = { 2, 4, 3 };
		int[] b = { 5, 6, 4 };
		int i = 0, j = 0;
		ListNode aRoot = null, aCurrent = null, bRoot = null, bCurrent = null;
		while (i < a.length || j < b.length) {
			ListNode aNode, bNode;
			if (i < a.length) {
				aNode = new ListNode(a[i]);
				if (aRoot == null) {
					aRoot = aNode;
					aCurrent = aNode;
				} else {
					aCurrent.next = aNode;
					aCurrent = aNode;
				}
				i++;
			}
			if (j < b.length) {
				bNode = new ListNode(b[j]);
				if (bRoot == null) {
					bRoot = bNode;
					bCurrent = bNode;
				} else {
					bCurrent.next = bNode;
					bCurrent = bNode;
				}
				j++;
			}
		}
		ListNode root = addTwoNumbers(aRoot, bRoot);
		StringBuilder output = new StringBuilder();
		output.append("[");
		while (root != null) {
			output.append(root.val + ",");
			root = root.next;
		}
		output.append("]");
		System.out.println(output.toString());
	}

	public ListNode addTwoNumbersEffective() {
		// Effective Solution
		return null;
	}

	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Not so effective solution
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				s1.insert(0, l1.val + "");
				l1 = l1.next;
			}
			if (l2 != null) {
				s2.insert(0, l2.val + "");
				l2 = l2.next;
			}
		}

		System.out.println(s1 + " " + s2);
		Long sum = Long.parseLong(s1.toString()) + Long.parseLong(s2.toString());
		System.out.println(s1 + " " + s2 + " " + sum);
		ListNode root = null;
		ListNode current = null;
		if (sum == 0) {
			return new ListNode(0);
		}
		while (sum != 0) {
			long value = sum % 10;
			ListNode node = new ListNode((int) value);
			if (root == null) {
				root = node;
			} else {
				current.next = node;
			}
			current = node;
			sum = sum / 10;
		}
		return root;
	}
}

//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}