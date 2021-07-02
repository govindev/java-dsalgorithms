package com.leetcode.topinterviewquestions;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}

	// Naive solution is giving better time complexity. But this is clean code
	public static List<String> letterCombinations(String digits) {
		if (digits.length() < 1) {
			return new ArrayList<>();
		}

		String[] lettersArray = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> result = new ArrayList<>();
		addAllCombinations(result, digits, "", 0, lettersArray);
		return result;
	}

	public static void addAllCombinations(List<String> result, String digits, String current, int index,
			String[] lettersArray) {
		if (index == digits.length()) {
			result.add(current);
			return;
		}
		String letters = lettersArray[digits.charAt(index) - '0'];
		for (int i = 0; i < letters.length(); i++) {
			addAllCombinations(result, digits, current + letters.charAt(i), index + 1, lettersArray);
		}
	}

	// Not a clean code. Naive way of doing.
	public List<String> letterCombinationsNaive(String digits) {
		if (digits.length() < 1) {
			return new ArrayList<>();
		}
		if (digits.length() == 1) {
			return Arrays.asList(getLetters(digits));
		}

		int l = digits.length();
		String[] arr1 = getLetters(digits.substring(l - 2, l - 1));
		String[] arr2 = getLetters(digits.substring(l - 1, l));
		String[] output = getCombinations(arr1, arr2);
		for (int i = l - 3; i >= 0; i--) {
			arr1 = getLetters(digits.substring(i, i + 1));
			output = getCombinations(arr1, output);
		}
		return Arrays.asList(output);
	}

	public static String[] getCombinations(String[] arr1, String[] arr2) {
		List<String> output = new ArrayList<>();
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				output.add(arr1[i] + arr2[j]);
			}
		}
		return output.toArray(new String[0]);
	}

	public static String[] getLetters(String s) {
		switch (s) {
		case "2":
			return new String[] { "a", "b", "c" };
		case "3":
			return new String[] { "d", "e", "f" };
		case "4":
			return new String[] { "g", "h", "i" };
		case "5":
			return new String[] { "j", "k", "l" };
		case "6":
			return new String[] { "m", "n", "o" };
		case "7":
			return new String[] { "p", "q", "r", "s" };
		case "8":
			return new String[] { "t", "u", "v" };
		case "9":
			return new String[] { "w", "x", "y", "z" };
		}
		return null;
	}
}
