package com.leetcode.topinterviewquestions;

import java.util.*;

public class LRUCacheRightWay {
	public static void main(String[] args) {
		int capacity = 2;
		LRUCacheRightWay cache = new LRUCacheRightWay(capacity);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);
		cache.put(3, 3);
		cache.get(2);
		cache.put(4, 4);
		cache.get(1);
		cache.get(3);
		cache.get(4);
	}

	Map<Integer, DoublyLinkedNode> mappings = new HashMap<>();
	DoublyLinkedList dll = new DoublyLinkedList();
	int capacity = 0;

	public LRUCacheRightWay(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (mappings.containsKey(key)) {
			// 0. store the value
			int val = mappings.get(key).getData();
			// 1. remove from the dll
			dll.remove(mappings.get(key));
			// 2. Add a new one to dll
			DoublyLinkedNode node = dll.add(val);
			// 3. Update the Hashmap
			mappings.put(key, node);
			return val;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (mappings.containsKey(key)) {
			// Existing element
			// 1. remove from the dll
			dll.remove(mappings.get(key));
			// 2. Add a new one to dll
			DoublyLinkedNode node = dll.add(value);
			// 3. Update the Hashmap
			mappings.put(key, node);
		} else if (mappings.size() == capacity) {
			// Remove the LRU element which last element in the hashmap & dll
			mappings.values().remove(dll.getLru());
			dll.remove(dll.getLru());
			// Add a new one to dll
			DoublyLinkedNode node = dll.add(value);
			// Update the Hashmap
			mappings.put(key, node);
		} else {
			// Add a new one to dll
			DoublyLinkedNode node = dll.add(value);
			// Update the Hashmap
			mappings.put(key, node);
		}
	}

	class DoublyLinkedNode {
		private int data;
		private DoublyLinkedNode prevNode;
		private DoublyLinkedNode nextNode;

		public DoublyLinkedNode(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public DoublyLinkedNode getNextNode() {
			return nextNode;
		}

		public void setNextNode(DoublyLinkedNode nextNode) {
			this.nextNode = nextNode;
		}

		public DoublyLinkedNode getPrevNode() {
			return prevNode;
		}

		public void setPrevNode(DoublyLinkedNode prevNode) {
			this.prevNode = prevNode;
		}
	}

	class DoublyLinkedList {
		private DoublyLinkedNode head;
		private DoublyLinkedNode tail;

		public DoublyLinkedNode getLru() {
			return this.tail;
		}

		public DoublyLinkedNode add(int val) {
			DoublyLinkedNode node = new DoublyLinkedNode(val);
			if (this.head != null) {
				this.head.setPrevNode(node);
				node.setNextNode(this.head);
			} else {
				this.tail = node;
			}
			this.head = node;
			return this.head;
		}

		public void remove(DoublyLinkedNode node) {
			if (node.getPrevNode() == null && node.getNextNode() == null) {
				this.head = null;
				this.tail = null;
			} else if (node.getPrevNode() == null) {
				this.head = node.getNextNode();
				this.head.setPrevNode(null);
			} else if (node.getNextNode() == null) {
				this.tail = node.getPrevNode();
				this.tail.setNextNode(null);
			} else {
				node.getPrevNode().setNextNode(node.getNextNode());
				node.getNextNode().setPrevNode(node.getPrevNode());
			}
			node.setPrevNode(null);
			node.setNextNode(null);
		}
	}

}
