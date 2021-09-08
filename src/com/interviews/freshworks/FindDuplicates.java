package com.interviews.freshworks;

import java.util.*;

public class FindDuplicates {
	public static void main(String[] args) {
		int[] source = { 23, 45, 65, 67, 78, 89, 21, 45 };
		int[] arr2 = { 22, 33, 45, 67, 55, 45, 67 };
		printDuplicates(source, arr2);
	}

	public static void printDuplicates(int[] source, int[] arr) {

		Map<Integer, Integer> src = new HashMap<>();
		for (int elm : source) {
			int count = 1;
			if (src.containsKey(elm)) {
				count += src.get(elm);
			}
			src.put(elm, count);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("Duplicates : ");

		for (int elm : arr) {
			if (src.containsKey(elm)) {
				int count = src.get(elm);
				src.put(elm, count - 1);
				if (count > 0)
					sb.append(elm + ",");
			}
		}
		System.out.println(sb.toString());
	}
}
