package com.leetcode.topinterviewquestions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {
	public static void main(String[] args) {
		List<String> strings = generateParenthesis(3);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (String s : strings) {
			sb.append(s + ",");
		}
		sb.append("]");
		System.out.println(sb.toString());
	}

	public static List<String> generateParenthesis(int n) {
		List<String> strings = new ArrayList<>();
		generateParanthesis(strings, n, 0, 0, "");
		return strings;
	}

	public static void generateParanthesis(List<String> strings, int n, int left, int right, String current) {
		if (current.length() == n * 2) {
			strings.add(current);
			return;
		}
		if (left < n) {
			generateParanthesis(strings, n, left + 1, right, current + "(");
		}
		if (right < left) {
			generateParanthesis(strings, n, left, right + 1, current + ")");
		}
	}
}