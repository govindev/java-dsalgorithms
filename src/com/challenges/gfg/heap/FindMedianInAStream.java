package com.challenges.gfg.heap;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0
 * https://www.youtube.com/watch?v=VmogG01IjYc
 * 
 * Given an input stream of N integers. The task is to insert these numbers into
 * a new stream and find the median of the stream formed by each insertion of X
 * to the new stream.
 * 
 * Input: The first line of input contains an integer N denoting the number of
 * elements in the stream. Then the next N lines contains integer x denoting the
 * number to be inserted into the stream. Output: For each element added to the
 * stream print the floor of the new median in a new line.
 * 
 * Constraints: 1 <= N <= 106 1 <= x <= 106
 * 
 * Example: Input: 4 5 15 1 3 Output: 5 10 5 4
 * 
 * Explanation: Testcase 1: Flow in stream : 5, 15, 1, 3 5 goes to stream -->
 * median 5 (5) 15 goes to stream --> median 10 (5, 15) 1 goes to stream -->
 * median 5 (5, 15, 1) 3 goes to stream --> median 4 (5, 15, 1, 3)
 * 
 * @author Govind
 *
 */
class FindMedianInAStream {
	static PriorityQueue<Integer> lefts;
	static PriorityQueue<Integer> rights;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder output = new StringBuilder();
		// 1. Read the size of the array
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		// 2. Read each element one by one and find out the medians for them
		// 4a. Define two heaps
		lefts = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return -1 * a.compareTo(b);
			}
		});
		rights = new PriorityQueue<Integer>();
		for (int i = 0; i < size; i++) {
			int element = Integer.parseInt(br.readLine());
			// 3. Find the median
			// 4. To find the median use the Heap approach for that create two heaps
			// 4b. Add element to one of the Heaps first
			addElement(element, lefts, rights);
			// 4c. Balance the heaps
			rebalance(lefts, rights);
			// 4d. Get the median
			int median = getMedian(lefts, rights);
			// 4e. Print the median
			output.append(median + "\n");
		}
		System.out.println(output);
	}

	public static void addElement(int element, PriorityQueue<Integer> lefts, PriorityQueue<Integer> rights) {
		// Check for the size of the heaps and the element to the heap with less number
		// of elements
		if (lefts.size() == 0 || lefts.peek() > element) {
			lefts.add(element);
		} else {
			rights.add(element);
		}
	}

	public static void rebalance(PriorityQueue<Integer> lefts, PriorityQueue<Integer> rights) {
		PriorityQueue<Integer> lessElementsHeap = lefts.size() > rights.size() ? rights : lefts;
		PriorityQueue<Integer> moreElementsHeap = lefts.size() > rights.size() ? lefts : rights;
		if (moreElementsHeap.size() - lessElementsHeap.size() >= 2) {
			lessElementsHeap.add(moreElementsHeap.poll());
		}
	}

	public static int getMedian(PriorityQueue<Integer> lefts, PriorityQueue<Integer> rights) {
		PriorityQueue<Integer> lessElementsHeap = lefts.size() > rights.size() ? rights : lefts;
		PriorityQueue<Integer> moreElementsHeap = lefts.size() > rights.size() ? lefts : rights;

		if (moreElementsHeap.size() == lessElementsHeap.size()) {
			return (moreElementsHeap.peek() + lessElementsHeap.peek()) / 2;
		} else {
			return moreElementsHeap.peek();
		}
	}
}