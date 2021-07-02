package com.leetcode.topinterviewquestions;

public class RomanToInteger {
	public static void main(String[] args) {
		String s = "MCMXCIV";
		System.out.println(romanToInt(s));
	}

	public static int romanToInt1(String s) {
		int n = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (i + 1 < s.length()) {
				char nxtCh = s.charAt(i + 1);
				if (ch == 'I' && (nxtCh == 'V' || nxtCh == 'X')) {
					n += (nxtCh == 'V' ? 4 : 9);
					i += 1;
					continue;
				}
				if (ch == 'X' && (nxtCh == 'L' || nxtCh == 'C')) {
					n += (nxtCh == 'L' ? 40 : 90);
					i += 1;
					continue;
				}
				if (ch == 'C' && (nxtCh == 'D' || nxtCh == 'M')) {
					n += (nxtCh == 'D' ? 400 : 900);
					i += 1;
					continue;
				}
			}
			if (ch == 'I')
				n += 1;
			if (ch == 'V')
				n += 5;
			if (ch == 'X')
				n += 10;
			if (ch == 'L')
				n += 50;
			if (ch == 'C')
				n += 100;
			if (ch == 'D')
				n += 500;
			if (ch == 'M')
				n += 1000;

		}
		return n;

	}

	public static int romanToInt(String s) {
		int last = 0;
		int n = 0;
		for (int i = 0; i < s.length(); i++) {
			int present = getValue(s.charAt(i));
			if (present > last) {
				// Remove last
				n -= last;
				// Add present - last
				n += (present - last);
			} else {
				n += present;
			}
			last = present;
		}
		return n;
	}

	private static int getValue(char ch) {
		switch (ch) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}
}
