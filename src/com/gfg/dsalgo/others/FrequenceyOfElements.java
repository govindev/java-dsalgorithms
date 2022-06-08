package com.gfg.dsalgo.others;

import java.util.*;
import java.util.Map.Entry;

public class FrequenceyOfElements {
	public static void main(String[] args) {
		int[] array = { 10, 12, 10, 15, 10, 20, 12, 12 };
		Map<Integer, Integer> map = new HashMap<>();
		for (int e : array) {
			map.put(e, map.getOrDefault(e, 0) + 1);
		}
		Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, Integer> entry = iterator.next();
			System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
		}
	}
}
