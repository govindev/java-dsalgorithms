package com.leetcode.thirtydaychallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/***
 * Last Stone Weight
 *
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3297/
 *
 * We have a collection of stones, each stone has a positive integer weight.
 * 
 * Each turn, we choose the two heaviest stones and smash them together. Suppose
 * the stones have weights x and y with x <= y. The result of this smash is:
 * 
 * If x == y, both stones are totally destroyed; If x != y, the stone of weight
 * x is totally destroyed, and the stone of weight y has new weight y-x. At the
 * end, there is at most 1 stone left. Return the weight of this stone (or 0 if
 * there are no stones left.)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [2,7,4,1,8,1] Output: 1 Explanation: We combine 7 and 8 to get 1 so
 * the array converts to [2,4,1,1,1] then, we combine 2 and 4 to get 2 so the
 * array converts to [2,1,1,1] then, we combine 2 and 1 to get 1 so the array
 * converts to [1,1,1] then, we combine 1 and 1 to get 0 so the array converts
 * to [1] then that's the value of last stone.
 * 
 * 
 * Note:
 * 
 * 1 <= stones.length <= 30 1 <= stones[i] <= 1000
 * 
 * Hint #1 Simulate the process. We can do it with a heap, or by sorting some
 * list of stones every time we take a turn.
 * 
 * @author Govind
 *
 */

class LastStoneWeight {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] stonesStrArray = br.readLine().trim().split(",");
		int[] stones = new int[stonesStrArray.length];
		List<Integer> stonesList = new ArrayList<Integer>();

		int i = 0;
		for (String stone : stonesStrArray) {
			stones[i] = Integer.parseInt(stone);
			stonesList.add(stones[i]);
			i++;
		}

//		for (int i : stones) {
//			stonesList.add(i);
//		}

		while (stonesList.size() > 1) {
			Collections.sort(stonesList);
			Collections.reverse(stonesList);
			Iterator<Integer> iterator = stonesList.iterator();
			int x = iterator.next();
			int y = iterator.next();
			stonesList.remove(0);
			stonesList.remove(0);
			if (x != y) {
				stonesList.add(x - y);
			}
		}

		int lastStoneWeight = 0;
		if (stonesList.size() > 0) {
			Iterator<Integer> iterator = stonesList.iterator();
			lastStoneWeight = iterator.next();
		}
		System.out.println("Last stone weight : " + lastStoneWeight);
	}
}