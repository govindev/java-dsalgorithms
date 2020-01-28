package com.dsalgo.linkedlists;

public class DoublyLinkedListDemo {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtHead(1);
		list.insertAtHead(21);
		list.insertAtHead(231);
		list.insertAtHead(98);
		list.insertAtHead(92);
		list.insertAtHead(38);

		System.out.println(list);
	}
}
