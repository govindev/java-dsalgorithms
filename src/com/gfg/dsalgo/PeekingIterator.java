package com.gfg.dsalgo;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
	Integer peek = null;
	Integer next = null;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iterator = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (peek != null) {
			return peek;
		} else {
			if (iterator.hasNext()) {
				next = iterator.next();
				peek = next;
			}
			return peek;
		}
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (next != null) {
			int result = next;
			next = null;
			peek = null;
			return result;
		}
		if (iterator.hasNext()) {
			return iterator.next();
		}
		return null;
	}
	
	@Override
	public boolean hasNext() {
		if (iterator.hasNext()) {
			return true;
		}
		if (next != null || peek != null) {
			return true;
		}
		return false;
	}
}
