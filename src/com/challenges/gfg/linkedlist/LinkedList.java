package com.challenges.gfg.linkedlist;

public class LinkedList {
	public Node head;

	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			this.head = newNode;
		} else {
			newNode.next = this.head;
			this.head = newNode;
		}
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

}