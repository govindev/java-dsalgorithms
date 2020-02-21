package com.challenges.gfg.linkedlist;

public class LinkedList {
	public Node head;
	public Node bottom;

	public void insertAtBottom(int data) {
		Node newNode = new Node(data);
		if (this.head == null) {
			this.head = newNode;
		} else {
			newNode.bottom = this.head;
			newNode.next = this.head.next;
			this.head.next = null;
			this.head = newNode;
		}
	}

	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			this.head = newNode;
		} else {
			newNode.next = this.head;
			this.head = newNode;
		}
	}

	public int getLength() {
		int count = 1;
		Node last = head;
		while (last.next != null) {
			last = last.next;
			count++;
		}
		return count;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		while (current.next != null) {
			sb.append(current.data + "->");
			current = current.next;
		}
		sb.append(current.data);
		return sb.toString();
	}

	public StringBuilder getPrintString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		while (current.next != null) {
			sb.append(current.data + " ");
			current = current.next;
		}
		sb.append(current.data);
		return sb;
	}

	public StringBuilder getPrintStringTraversingViaBottom() {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		while (current.bottom != null) {
			sb.append(current.data + " ");
			current = current.bottom;
		}
		sb.append(current.data);
		return sb;
	}

	public void roatate(int noOfRoatations) {
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		// 'Last' is the 'current' element where 'current.next' is null
		// So now 'last' is nothing but 'current'
		Node last = current;
		for (int i = 0; i < noOfRoatations; i++) {
			last.next = head;
			head = head.next;
			last = last.next;
			last.next = null;
		}
	}

	private Node probableHead;

	private Node reverse(Node current, int groupSize) {
		if (current.next == null) {
			probableHead = current;
			return current;
		}
		groupSize = groupSize - 1;
		if (groupSize < 1) {
			probableHead = current;
			return current;
		}
		Node next = reverse(current.next, groupSize);
		current.next = next.next;
		next.next = current;
		return current;
	}

	public void reverseInGroups(int groupSize) {
		Node current = head;
		Node last = head;
		int iterations = (getLength() / groupSize) + ((getLength() % groupSize == 0) ? 0 : 1);
		for (int i = 0; i < iterations; i++) {
			reverse(current, groupSize);
			if (i == 0) {
				head = probableHead;
			} else {
				last.next = probableHead;
			}
			last = current;
			current = head;
			for (int j = 1; j <= groupSize * (i + 1); j++) {
				if (current.next == null)
					break;
				current = current.next;
			}
		}
	}

}