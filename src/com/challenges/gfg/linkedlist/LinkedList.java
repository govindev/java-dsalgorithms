package com.challenges.gfg.linkedlist;

public class LinkedList {
	private Node head;

	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			this.head = newNode;
		} else {
			newNode.next = this.head;
			this.head = newNode;
		}
	}

	public Node getHead() {
		return this.head;
	}
}