package com.leetcode.thirtydaychallenge;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/***
 * Group Anagrams
 * 
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3288/
 * 
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [
 * ["ate","eat","tea"], ["nat","tan"], ["bat"] ] Note:
 * 
 * All inputs will be in lowercase. The order of your output does not matter.
 * 
 * @author Govind
 *
 */

public class GroupAnagrams {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		String[] strings = br.readLine().trim().split(",");
		List<List<String>> groupAnagrams = groupAnagrams(strings);
		output.append("[");
		for (List<String> anagrams : groupAnagrams) {
			output.append("[");
			for (String str : anagrams) {
				output.append(str + ", ");
			}
			output.append("],");
		}
		output.append("]");
		System.out.println("Group of Anagrams \n" + output);
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> groupAnagrams = new ArrayList<List<String>>();
		for (String string : strs) {
			if (groupAnagrams.size() == 0) {
				List<String> anagrams = new ArrayList<String>();
				anagrams.add(string);
				groupAnagrams.add(anagrams);
			} else {
				boolean isAnagram = false;
				for (List<String> anagrams : groupAnagrams) {
					// Check whether the given strings are anagrams
					isAnagram = checkAnagram(string, anagrams.get(0));
					if (isAnagram) {
						anagrams.add(string);
						break;
					}
				}
				if (!isAnagram) {
					List<String> anagrams = new ArrayList<String>();
					anagrams.add(string);
					groupAnagrams.add(anagrams);
				}
			}
		}
		return groupAnagrams;
	}

	public static boolean checkAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		for (int i = 0; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			int str2CharIndex = str2.indexOf(ch);
			if (str2CharIndex == -1) {
				// Character not found
				return false;
			} else {
				// If character found
				// remove this character from the string2
				str2 = str2.substring(0, str2CharIndex) + str2.substring(str2CharIndex + 1, str2.length());
			}
		}
		return true;
	}
}