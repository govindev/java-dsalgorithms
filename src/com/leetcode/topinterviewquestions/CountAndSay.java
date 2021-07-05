package com.leetcode.topinterviewquestions;

public class CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(4));
	}

	public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		String s = countAndSay(n - 1);
		StringBuilder sb = new StringBuilder();
		char ch = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (ch == s.charAt(i)) {
				count++;
			} else {
				sb.append(count + "" + ch);
				ch = s.charAt(i);
				count = 1;
			}
		}
		return sb.append(count + "" + ch).toString();
	}
}
