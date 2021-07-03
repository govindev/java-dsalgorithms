package com.leetcode.topinterviewquestions;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	private static ListNodeC getHead(int[] array) {
		ListNodeC head = new ListNodeC(array[0]);
		ListNodeC current = head;
		for (int i = 1; i < array.length; i++) {
			current.next = new ListNodeC(array[i]);
			current = current.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNodeC ln1 = getHead(new int[] { 1, 4, 5 });
		ListNodeC ln2 = getHead(new int[] { 1, 3, 4 });
		ListNodeC ln3 = getHead(new int[] { 2, 6 });
		ListNodeC[] lists = new ListNodeC[] { ln1, ln2, ln3 };
		ListNodeC head = mergeKLists(lists);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while (head != null) {
			sb.append(head.val + ",");
			head = head.next;
		}
		sb.append("]");
		System.out.println(sb.toString());
	}

	public static ListNodeC mergeKListsNaive(ListNodeC[] lists) {
		ListNodeC beforeHead = new ListNodeC(0);
		ListNodeC current = beforeHead;

		while (true) {
			int k = 0;
			while (k < lists.length && lists[k] == null) {
				k++;
			}
			if (k >= lists.length || lists[k] == null)
				break;
			for (int i = 1; i < lists.length; i++) {
				if (k >= i)
					continue;
				if (lists[i] == null)
					continue;
				if (lists[i].val < lists[k].val)
					k = i;
			}
			current.next = new ListNodeC(lists[k].val);
			current = current.next;
			lists[k] = lists[k].next;
		}
		return beforeHead.next;
	}

	public static ListNodeC mergeKLists(ListNodeC[] lists) {
		// Using Priority Queue
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (ListNodeC head : lists) {
			while (head != null) {
				queue.add(head.val);
				head = head.next;
			}
		}
		ListNodeC preHead = new ListNodeC(-1);
		ListNodeC current = preHead;
		while (!queue.isEmpty()) {
			current.next = new ListNodeC(queue.remove());
			current = current.next;
		}
		return preHead.next;
	}
}

//Definition for singly-linked list.
class ListNodeC {
	int val;
	ListNodeC next;

	ListNodeC() {
	}

	ListNodeC(int val) {
		this.val = val;
	}

	ListNodeC(int val, ListNodeC next) {
		this.val = val;
		this.next = next;
	}
}