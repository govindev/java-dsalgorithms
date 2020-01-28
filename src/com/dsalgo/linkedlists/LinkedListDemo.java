package com.dsalgo.linkedlists;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtHead(10);
		list.insertAtHead(8);
		list.insertAtHead(29);
		list.insertAtHead(34);
		list.insertAtHead(2);
		list.insertAtHead(6);
		list.insertAtHead(22);
		list.insertAtHead(19);

		System.out.println(list);
		System.out.println("Length of linked list : " + list.length());
		
		list.deleteFromHead();
		
		System.out.println(list);
		System.out.println("Length of linked list : " + list.length());
		
		System.out.println("Search element : " + list.find(35));
	}
}