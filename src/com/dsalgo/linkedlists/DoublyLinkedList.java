package com.dsalgo.linkedlists;

public class DoublyLinkedList {

	private DoublyLinkedNode head;

	public DoublyLinkedNode getHead() {
		return head;
	}

	public void setHead(DoublyLinkedNode head) {
		this.head = head;
	}

	public void insertAtHead(int data) {
		DoublyLinkedNode newNode = new DoublyLinkedNode(data);
		if (this.head != null) {
			this.head.setPrevNode(newNode);
			newNode.setNextNode(this.head);
		}
		this.head = newNode;
	}

	public Integer length() {
		DoublyLinkedNode current = this.head;
		Integer length = 0;
		while (current != null) {
			length = length + 1;
			current = current.getNextNode();
		}
		return length;
	}

	public DoublyLinkedNode getNodeAtIndex(int index) {
		if (index == 0) {
			return this.head;
		}
		DoublyLinkedNode current = this.head;
		while (index > 0 && current != null) {
			index--;
			current = current.getNextNode();
		}
		return current;
	}

	@Override
	public String toString() {
		DoublyLinkedNode current = this.head;
		String list = "";
		while (current != null) {
			list += "\n" + current.toString();
			current = current.getNextNode();
		}
		return list;
	}
}
