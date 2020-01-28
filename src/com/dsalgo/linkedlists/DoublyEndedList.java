package com.dsalgo.linkedlists;

public class DoublyEndedList {

	private Node head;
	private Node tail;

	public void insertAtTail(int data) {
		Node newNode = new Node(data);

		if (this.head == null) {
			this.head = newNode;
		}

		if (this.tail != null) {
			this.tail.setNextNode(newNode);
		}

		this.tail = newNode;
	}

	@Override
	public String toString() {
		String list = "{";

		Node current = this.head;
		while (current != null) {
			list += current.toString() + ",";
			current = current.getNextNode();
		}
		list += "}";
		return list;
	}
}