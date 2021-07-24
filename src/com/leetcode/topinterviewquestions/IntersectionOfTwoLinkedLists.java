package com.leetcode.topinterviewquestions;

import java.util.*;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// Constant space
		ListNode a = headA;
		ListNode b = headB;
		while (a != b) {
			a = (a == null) ? headB : a.next;
			b = (b == null) ? headA : b.next;
		}
		return a;

	}

	public ListNode getIntersectionNodeLinearSpace(ListNode headA, ListNode headB) {
		// Linear space complexity solution
		Set<ListNode> set = new HashSet<>();
		while (headA != null) {
			if (set.contains(headA)) {
				return headA;
			}
			set.add(headA);
			headA = headA.next;
		}
		while (headB != null) {
			if (set.contains(headB)) {
				return headB;
			}
			set.add(headB);
			headB = headB.next;
		}
		return null;
	}
}
