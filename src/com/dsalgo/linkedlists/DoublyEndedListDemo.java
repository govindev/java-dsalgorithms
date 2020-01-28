package com.dsalgo.linkedlists;

public class DoublyEndedListDemo {

	public static void main(String[] args) {
		DoublyEndedList dList = new DoublyEndedList();
		dList.insertAtTail(10);
		dList.insertAtTail(3);
		dList.insertAtTail(13);
		dList.insertAtTail(23);
		dList.insertAtTail(46);
		dList.insertAtTail(15);
		dList.insertAtTail(9);
		System.out.println(dList);
	}
}