package com.leetcode.topinterviewquestions;

import java.util.*;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != null && fast != null) {
			if (slow == fast)
				return true;
			slow = slow.next;
			if (fast.next == null)
				return false;
			fast = fast.next.next;
		}
		return false;
	}

	public boolean hasCycleUsingSet(ListNode head) {
		// Linear space complexity
		Set<ListNode> visited = new HashSet<>();
		while (head != null) {
			if (visited.contains(head))
				return true;
			visited.add(head);
			head = head.next;
		}
		return false;
	}
}
