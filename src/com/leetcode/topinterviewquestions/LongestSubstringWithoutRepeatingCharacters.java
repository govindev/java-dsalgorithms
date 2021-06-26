package com.leetcode.topinterviewquestions;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int left = 0, right = 1;
		Set<Character> window = new HashSet<Character>();
		int max = 1;
		window.add(s.charAt(left));
		while (left < s.length() - 1 && right < s.length()) {
			int prevSize = window.size();
			window.add(s.charAt(right));
			if (prevSize == window.size()) {
				// Repeating character
				// 1. Remove the left character from the HashSet
				window.remove(s.charAt(left));
				// 2. Move the left pointer
				left++;
			} else {
				// Not a repeating character
				int subStringLength = right - left + 1;
				if (subStringLength > max) {
					max = subStringLength;
				}
				// 2. Move the right pointer
				right++;
			}
		}
		return max;
	}
}
