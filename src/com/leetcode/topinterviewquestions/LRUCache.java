package com.leetcode.topinterviewquestions;

import java.util.*;

public class LRUCache {
	private int capacity;
	private Queue<Integer> lru;
	private Map<Integer, Integer> cache;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.lru = new LinkedList<>();
		this.cache = new HashMap<>();
	}

	public int get(int key) {
		if (!cache.containsKey(key))
			return -1;
		lru.remove(key);
		lru.offer(key);
		return cache.get(key);
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			lru.remove(key);
			lru.offer(key);
			cache.put(key, value);
		} else {
			if (cache.size() >= capacity) {
				int lruElm = lru.remove();
				System.out.println(" lrul element : " + lruElm);
				cache.remove(lruElm);
			}
			lru.offer(key);
			cache.put(key, value);
		}
	}
}

//  Your LRUCache object will be instantiated and called as such:
//  LRUCache obj = new LRUCache(capacity);
//  int param_1 = obj.get(key);
//  obj.put(key,value);
