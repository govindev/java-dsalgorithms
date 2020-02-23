package com.challenges.gfg.stackandqueue;

import java.io.*;
import java.util.*;

/***
 * https://practice.geeksforgeeks.org/problems/lru-cache/1
 * 
 * The task is to design and implement methods of an LRU cache. The class has
 * two methods get() and set() which are defined as follows. get(x) : Returns
 * the value of the key x if the key exists in the cache otherwise returns -1.
 * set(x,y) : inserts the value if the key x is not already present. If the
 * cache reaches its capacity it should invalidate the least recently used item
 * before inserting the new item. In the constructor of the class the size of
 * the cache should be intitialized.
 * 
 * Input Format: The first line of input contain an integer T denoting the
 * number of test cases. Then T test case follow. Each test case contains 3
 * lines. The first line of input contains an integer N denoting the capacity of
 * the cache and then in the next line is an integer Q denoting the number of
 * queries Then Q queries follow. A Query can be of two types 1. SET x y : sets
 * the value of the key x with value y 2. GET x : gets the key of x if present
 * else returns -1.
 * 
 * Output Format: For each test case, in a new line, output will be space
 * separated values of the query.
 * 
 * Your Task: This is a function problem. You only need to complete the provided
 * functions.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 10 1 <= Q <= 100
 * 
 * Example(To be used only for expected output): Input: 2 2 2 SET 1 2 GET 1 2 7
 * SET 1 2 SET 2 3 SET 1 5 SET 4 5 SET 6 7 GET 4 GET 1
 * 
 * Output: 2 5 -1
 * 
 * @author Govind
 *
 */

class LRUNode {
	int key, value;
	LRUNode next, pre;

	LRUNode(int key, int value) {
		this.key = key;
		this.value = value;
		next = pre = null;
	}
}

public class LRUCacheMain {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {

			int capacity = Integer.parseInt(read.readLine());
			int queries = Integer.parseInt(read.readLine());
			LRUCache cache = new LRUCache(capacity);
			String str[] = read.readLine().trim().split(" ");
			int len = str.length;
			int itr = 0;

			for (int i = 0; (i < queries) && (itr < len); i++) {
				String queryType = str[itr++];
				if (queryType.equals("SET")) {
					int key = Integer.parseInt(str[itr++]);
					int value = Integer.parseInt(str[itr++]);
					cache.set(key, value);
				}
				if (queryType.equals("GET")) {
					int key = Integer.parseInt(str[itr++]);
					System.out.print(cache.get(key) + " ");
				}

			}
			System.out.println();

		}
	}
}

class LRUCache {
	private static Map<Integer, LRUNode> hsMap;
	private static int capacity, count;
	private static LRUNode head, tail;

	LRUCache(int cap) {
		// Intialize the cache capacity with the given
		// cap
		capacity = cap;
		count = 0;
		hsMap = new LinkedHashMap<Integer, LRUNode>();
	}

	// This method works in O(1)
	public static int get(int key) {
		// your code here
		LRUNode LRUNode = hsMap.get(key);
		if (LRUNode == null)
			return -1;
		LRUNode.value = LRUNode.value + 1;
		return LRUNode.key;
	}

	// This method works in O(1)
	public static void set(int key, int value) {
		// your code here
		if (hsMap.get(key) != null) {
			LRUNode presLRUNode = hsMap.remove(key);
			if (presLRUNode == head) {
				head = head.next;
			} else if (presLRUNode == tail) {
				tail = tail.pre;
			} else {
				LRUNode presLRUNodePre = presLRUNode.pre;
				LRUNode presLRUNodeNext = presLRUNode.next;
				if (presLRUNodePre != null)
					presLRUNodePre.next = presLRUNodeNext;
				if (presLRUNodeNext != null)
					presLRUNodeNext.pre = presLRUNodePre;
			}
			LRUNode newLRUNode = new LRUNode(value, 0);
			hsMap.put(key, newLRUNode);
			if (count == 0) {
				head = newLRUNode;
				tail = newLRUNode;
			} else {
				tail.next = newLRUNode;
				newLRUNode.pre = tail;
				tail = newLRUNode;
			}

		} else if (count < capacity) {
			LRUNode newLRUNode = new LRUNode(value, 0);
			hsMap.put(key, newLRUNode);
			if (count == 0) {
				head = newLRUNode;
				tail = newLRUNode;
			} else {
				tail.next = newLRUNode;
				newLRUNode.pre = tail;
				tail = newLRUNode;
			}
		} else {
			// Get the least visited element
			LRUNode current = tail;
			LRUNode minLRUNode = current;
			int minVisitCount = minLRUNode.value;
			current = current.pre;
			while (current != null) {
				if (current.value <= minVisitCount) {
					minLRUNode = current;
					minVisitCount = current.value;
				}
				current = current.pre;
			}
			// Find the minKey for the minLRUNode
			Set entries = hsMap.keySet();
			Iterator iterator = entries.iterator();
			Integer minKey = null;
			while (iterator.hasNext()) {
				int currentKey = (int) iterator.next();
				if (minLRUNode == hsMap.get(key)) {
					minKey = currentKey;
					break;
				}
			}

			hsMap.remove(minKey);
			if (minLRUNode == head) {
				head = head.next;
			} else if (minLRUNode == tail) {
				tail = tail.pre;
			} else {
				LRUNode minLRUNodePre = minLRUNode.pre;
				LRUNode minLRUNodeNext = minLRUNode.next;
				minLRUNodePre.next = minLRUNodeNext;
				minLRUNodeNext.pre = minLRUNodePre;
			}
			LRUNode newLRUNode = new LRUNode(value, 0);
			hsMap.put(key, newLRUNode);
			if (count == 0) {
				head = newLRUNode;
				tail = newLRUNode;
			} else {
				tail.next = newLRUNode;
				newLRUNode.pre = tail;
				tail = newLRUNode;
			}
		}
	}
}
