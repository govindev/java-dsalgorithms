package com.interviews.nexthink;

import java.util.Stack;

public class ValidString {

	public static void main(String[] args) {
		String str1 = "ab(a(c)fg)9)";
		String str2 = ")a(b)c()(";
		String str3 = "";

		if (validString(str1).equals("ab(a(c)fg)9") && validString(str2).equals("a(b)c()")
				&& validString(str3).equals("")) {
			System.out.println("All the tests are passed");
		} else {
			System.out.println("Tests are failing");
		}
	}

	public static String validString(String str) {
		if (str == null || str.isEmpty())
			return str;
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			if (ch == '(') {
				stack.push(i);
			} else if (ch == ')' && !stack.isEmpty()) {
				stack.pop();
			} else if (ch == ')' && stack.isEmpty()) {
				sb.deleteCharAt(i);
			}
		}
		while (!stack.isEmpty()) {
			int chInd = stack.pop();
			sb.deleteCharAt(chInd);
		}
		return sb.toString();
	}
}