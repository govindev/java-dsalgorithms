package com.challenges.gfg.stackandqueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/***
 * https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k/0
 * 
 * Given an array A and an integer K. Find the maximum for each and every
 * contiguous subarray of size K.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. The first line of each test case contains a single integer N
 * denoting the size of array and the size of subarray K. The second line
 * contains N space-separated integers A1, A2, ..., AN denoting the elements of
 * the array.
 * 
 * Output: Print the maximum for every subarray of size k.
 * 
 * Constraints: 1 ≤ T ≤ 200 1 ≤ N ≤ 107 1 ≤ K ≤ N 0 ≤ A[i] <= 107
 * 
 * Example: Input: 2 9 3 1 2 3 1 4 5 2 3 6 10 4 8 5 10 7 9 4 15 12 90 13
 * 
 * Output: 3 3 4 5 5 5 6 10 10 10 15 15 90 90
 * 
 * Explanation: Testcase 1: Starting from first subarray of size k = 3, we have
 * 3 as maximum. Moving the window forward, maximum element are as 3, 4, 5, 5, 5
 * and 6.
 * 
 * @author Govind
 *
 */
public class MaximumOfAllSubarraysOfSizeK {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] lengths = br.readLine().trim().split(" ");
			int arrayLength = Integer.parseInt(lengths[0]);
			int windowLength = Integer.parseInt(lengths[1]);
			String[] array = br.readLine().trim().split(" ");
			Queue queue = new Queue();
			for (int p = 0, q = 0; p < arrayLength; p++) {
				int value = Integer.parseInt(array[p]);
				if (q >= windowLength) {
					queue.remove();
				} else {
					q++;
				}
				queue.add(value);
				if (q >= windowLength) {
					output.append(queue.max() + " ");
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}
}

class QNode {
	int value;
	QNode next;

	QNode(int value) {
		this.value = value;
	}
}

class Queue {
	QNode front = null, rear = null, max = null;

	int max() {
		if (max != null)
			return max.value;
		return -1;
	}

	void add(int value) {
		QNode node = new QNode(value);
		if (front == null) {
			front = node;
			rear = node;
			max = node;
		} else {
			rear.next = node;
			rear = node;
			if (node.value > max.value) {
				max = node;
			}
		}
	}

	int remove() {
		if (front != null) {
			if (max == front) {
				// Find the next max
				QNode current = front.next;
				max = front.next;
				while (current != null) {
					if (current.value >= max.value) {
						max = current;
					}
					current = current.next;
				}
			}
			front = front.next;
		}
		return -1;
	}
}