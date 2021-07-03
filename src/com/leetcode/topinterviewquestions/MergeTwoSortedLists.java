package com.leetcode.topinterviewquestions;

public class MergeTwoSortedLists {
	public ListNodeB mergeTwoLists(ListNodeB l1, ListNodeB l2) {
		ListNodeB head = new ListNodeB(0);
		ListNodeB mCurrent = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				mCurrent.next = l1;
				l1 = l1.next;
			} else {
				mCurrent.next = l2;
				l2 = l2.next;
			}
			mCurrent = mCurrent.next;
		}
		while (l1 != null) {
			mCurrent.next = l1;
			l1 = l1.next;
			mCurrent = mCurrent.next;
		}
		while (l2 != null) {
			mCurrent.next = l2;
			l2 = l2.next;
			mCurrent = mCurrent.next;
		}
		return head.next;
	}
}

// Definition for singly-linked list.
class ListNodeB {
	int val;
	ListNodeB next;

	ListNodeB() {
	}

	ListNodeB(int val) {
		this.val = val;
	}

	ListNodeB(int val, ListNodeB next) {
		this.val = val;
		this.next = next;
	}
}