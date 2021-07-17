package com.leetcode.topinterviewquestions;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			char leftCh = s.charAt(left);
			if ((leftCh >= 'a' && leftCh <= 'z') || (leftCh >= 'A' && leftCh <= 'Z')
					|| (leftCh >= '0' && leftCh <= '9')) {
				// convert the lower case to upper case
				if (leftCh >= 'a' && leftCh <= 'z')
					leftCh -= 32;
			} else {
				left++;
				continue;
			}
			char rightCh = s.charAt(right);
			if ((rightCh >= 'a' && rightCh <= 'z') || (rightCh >= 'A' && rightCh <= 'Z')
					|| (rightCh >= '0' && rightCh <= '9')) {
				// convert the lower case to upper case
				if (rightCh >= 'a' && rightCh <= 'z')
					rightCh -= 32;
			} else {
				right--;
				continue;
			}
			if (leftCh != rightCh)
				return false;
			left++;
			right--;
		}
		return true;
	}
}

// 'a' - 97 , 'z' - 122
// 'A' - 65, 'Z' - 90
// '0' - 48, '57' - 9

// Difference between upper and lower case letters = 97 - 65 = 32