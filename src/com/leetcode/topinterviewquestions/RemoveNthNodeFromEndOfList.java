package com.leetcode.topinterviewquestions;

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5 };
		int n = 2;
		ListNodeA head = null;
		ListNodeA current = null;
		for (int i = 0; i < array.length; i++) {
			if (current == null) {
				current = new ListNodeA(array[i]);
				head = current;
			} else {
				current.next = new ListNodeA(array[i]);
				current = current.next;
			}
		}
		head = removeNthFromEnd(head, n);
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val + "->");
			head = head.next;
		}
		System.out.println(sb.toString());
	}

	public static ListNodeA removeNthFromEnd(ListNodeA head, int n) {
		// Two pointer appraoch
		int fast = 1;
		ListNodeA slow = new ListNodeA(0);
		slow.next = head;
		ListNodeA current = head;
		while (fast < n) {
			current = current.next;
			fast++;
		}
		while (current.next != null) {
			current = current.next;
			slow = slow.next;
		}
		if (slow.next == head)
			return head.next;
		slow.next = slow.next.next;
		return head;
	}

	public static ListNodeA removeNthFromEndNaive(ListNodeA head, int n) {
		// Figure out the length of the linked list
		int l = 0;
		ListNodeA current = head;
		while (current != null) {
			current = current.next;
			l++;
		}
		n = l - n + 1;
		if (n == 1)
			return head.next;
		int i = 1;
		current = head;
		while (i < n - 1) {
			current = current.next;
			i++;
		}
		current.next = current.next.next;
		return head;
	}

}

//Definition for singly-linked list.
class ListNodeA {
	int val;
	ListNodeA next;

	ListNodeA() {
	}

	ListNodeA(int val) {
		this.val = val;
	}

	ListNodeA(int val, ListNodeA next) {
		this.val = val;
		this.next = next;
	}
}
