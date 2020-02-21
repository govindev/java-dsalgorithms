package com.challenges.gfg.linkedlist;

public class Node {
	int data;
	Node next;
	Node bottom;

	Node(int data) {
		this.data = data;
		this.next = null;
		this.bottom = null;
	}

	public int getData() {
		return this.data;
	}
}
