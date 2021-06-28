package com.leetcode.topinterviewquestions;

import java.util.LinkedHashMap;
import java.util.Map;

public class ZigZagConversion {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 3;
		System.out.println(convert(s, numRows));
	}

	public static String convert(String s, int numRows) {
		Map<Integer, StringBuilder> rows = new LinkedHashMap<>();
		int delta = -1;
		int row = 0;
		for (int i = 0; i < s.length(); i++) {
			if (rows.get(row) == null) {
				rows.put(row, new StringBuilder());
			}
			rows.get(row).append(s.charAt(i) + "");
			if (row == 0 || row == numRows - 1)
				delta *= -1;
			row += delta;
		}
		StringBuilder result = new StringBuilder("");
		for (StringBuilder sb : rows.values()) {
			result.append(sb);
		}
		return result.toString();

	}

}
