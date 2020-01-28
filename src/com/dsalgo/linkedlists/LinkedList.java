package com.dsalgo.linkedlists;

public class LinkedList {
	private Node head;

	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}

	public void deleteFromHead() {
		this.head = this.head.getNextNode();
	}

	public int length() {
		int length = 0;
		Node current = this.head;
		while (current != null) {
			length++;
			current = current.getNextNode();
		}
		return length;
	}

	public Node find(int data) {
		Node current = this.head;
		while (current != null) {
			if (current.getData() == data) {
				return current;
			}
			current = current.getNextNode();
		}
		return null;
	}

	@Override
	public String toString() {
		String list = "{";

		Node currentNode = this.head;
		while (currentNode != null) {
			list += currentNode.toString() + ",";
			currentNode = currentNode.getNextNode();
		}
		list += "}";
		return list;
	}
}