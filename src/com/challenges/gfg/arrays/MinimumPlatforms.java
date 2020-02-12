package com.challenges.gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MinimumPlatforms {

	private static void shellSort() {
		// 1. Find out the 'h' value list
		int h = 0;
		List<Integer> hList = new ArrayList<Integer>();
		do {
			hList.add(h);
			h = 3 * h + 1;
		} while (h < arrivals.length);

		// 2. Loop through the hList
		ListIterator<Integer> hIter = hList.listIterator();
		while (hIter.hasNext()) {
			h = hIter.next();

			// 3. Loop through between 0 to h
			for (int k = 0; k < h; k++) {
				// 4. Loop through the array for the insertion sort
				int i = 0 + k + h;
				for (; i < arrivals.length; i = i + h) {
					int newElement = Integer.parseInt(arrivals[i]);
					int bVal = Integer.parseInt(departures[i]);
					// 5. Insertion sort
					for (int j = i - h; j >= 0; j = j - h) {
						if (newElement < Integer.parseInt(arrivals[j])) {
							arrivals[j + h] = arrivals[j];
							arrivals[j] = newElement + "";
							
							departures[j + h] = departures[j];
							departures[j] = bVal + "";
						} else {
							break;
						}
					}
				}
			}
		}

	}

	private static String[] arrivals = {};
	private static String[] departures = {};

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int highestPlatforms = 1;
			String length = br.readLine();
			arrivals = br.readLine().split(" ");
			departures = br.readLine().split(" ");
			int[] maxPlatformsArray = new int[arrivals.length];
			shellSort();

			maxPlatformsArray[0] = 1;
			for (int j = 1; j < arrivals.length; j++) {
				int platforms = 1;
				int currTrainArrival = Integer.parseInt(arrivals[j]);
				for (int k = j - 1; k >= 0; k--) {
//					int prevTrainArrival = Integer.parseInt(arrivals[k]);
//					int prevTrainDep = Integer.parseInt(departures[k]);
					if (currTrainArrival >= Integer.parseInt(arrivals[k])
							&& currTrainArrival <= Integer.parseInt(departures[k]))
						platforms++;
					if (maxPlatformsArray[k] < 2)
						break;
				}
				maxPlatformsArray[j] = platforms;
				highestPlatforms = (platforms > highestPlatforms) ? platforms : highestPlatforms;
			}
			sb.append(highestPlatforms + "\n");
		}
		System.out.println(sb);
	}

}
