package com.dsalgo.recursion;

import java.util.Stack;

public class CStack<Object> extends Stack<Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public <Object>CStack(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}