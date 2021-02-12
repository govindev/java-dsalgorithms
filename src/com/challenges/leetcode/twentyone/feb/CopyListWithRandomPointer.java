package com.challenges.leetcode.twentyone.feb;

import java.util.Map;
import java.util.HashMap;

/***
 * Copy LIst with Random Pointer
 * 
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3635/
 * https://www.youtube.com/watch?v=OvpKeraoxW0
 * 
 * @author Govind
 *
 */

//Definition for a NodeR.
class NodeR {
	int val;
	NodeR next;
	NodeR random;

	public NodeR(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

class CopyListWithRandomPointer {
	public NodeR copyRandomList1(NodeR head) {
		Map<NodeR, NodeR> map = new HashMap<>();
		NodeR tempHead = head;
		while (tempHead != null) {
			NodeR NodeR = new NodeR(tempHead.val);
			map.put(tempHead, NodeR);
			tempHead = tempHead.next;
		}
		tempHead = head;
		NodeR newHead = map.get(tempHead);
		while (tempHead != null) {
			NodeR NodeR = map.get(tempHead);
			NodeR.next = map.get(tempHead.next);
			NodeR.random = map.get(tempHead.random);
			tempHead = tempHead.next;
		}
		return newHead;
	}

	public NodeR copyRandomList(NodeR head) {
		if (head == null)
			return null;
		NodeR tempHead = head;
		while (tempHead != null) {
			NodeR NodeR = new NodeR(tempHead.val);
			NodeR tempHeadNext = tempHead.next;
			tempHead.next = NodeR;
			NodeR.next = tempHeadNext;

			tempHead = tempHeadNext;
		}
		tempHead = head;
		while (tempHead != null) {
			if (tempHead.random != null)
				tempHead.next.random = tempHead.random.next;
			else
				tempHead.next.random = null;
			tempHead = tempHead.next.next;
		}
		tempHead = head;
		NodeR newHead = tempHead.next;
		while (tempHead != null) {
			NodeR tempHeadNext = tempHead.next.next;
			if (tempHeadNext != null)
				tempHead.next.next = tempHeadNext.next;
			else
				tempHead.next.next = null;
			tempHead.next = tempHeadNext;

			tempHead = tempHeadNext;
		}
		return newHead;
	}
}