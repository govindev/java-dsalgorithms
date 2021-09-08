package com.gfg.dsalgo;

import java.util.*;

public class CountDistinctElements {
	public static void main(String[] argss) {
		int[] array = { 15, 12, 13, 12, 13, 13, 18 };
		System.out.println(count(array));
	}

	private static int count(int[] elements) {
		Set<Integer> set = new HashSet<>();
		for (int num : elements) {
			set.add(num);
		}
		return set.size();
	}
	
	private static int count2(int[] elements) {
		Set<Integer> set = new HashSet(Arrays.asList(elements));
		return set.size();
	}
}
