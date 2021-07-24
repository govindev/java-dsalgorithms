package com.leetcode.topinterviewquestions;

import java.util.*;

public class MinStack {
	// Using single stack
	private Stack<Integer> stack;
	private int min;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<Integer>();
		min = Integer.MAX_VALUE;
	}

	public void push(int val) {
		if (val <= min) {
			stack.push(min);
			min = val;
		}
		stack.push(val);
	}

	public void pop() {
		if (stack.pop() == min)
			min = stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}
}

class MinStack1 {
	// Using two stacks
	private List<Integer> vals;
	private List<Integer> mins;

	/** initialize your data structure here. */
	public MinStack1() {
		vals = new ArrayList<>();
		mins = new ArrayList<>();
	}

	public void push(int val) {
		if (vals.isEmpty()) {
			vals.add(val);
			mins.add(val);
		} else {
			vals.add(val);
			mins.add(Math.min(val, mins.get(mins.size() - 1)));
		}
	}

	public void pop() {
		vals.remove(vals.size() - 1);
		mins.remove(mins.size() - 1);
	}

	public int top() {
		return vals.get(vals.size() - 1);
	}

	public int getMin() {
		return mins.get(mins.size() - 1);
	}
}