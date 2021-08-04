package com.leetcode.topinterviewquestions;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String columnTitle) {
		// Find out what is the starting point
		int len = columnTitle.length();
		int num = 0;
		for (int i = 0; i < len; i++) {
			int ch = columnTitle.charAt(i) - 'A' + 1;
			num += (ch * Math.pow(26, len - i - 1));
		}
		return num;
	}
}
