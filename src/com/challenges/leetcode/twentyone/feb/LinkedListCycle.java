package com.challenges.leetcode.twentyone.feb;
/**
 * 
 * @author Govind
 *
 */

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3627/
// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null)
				return false;
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
}