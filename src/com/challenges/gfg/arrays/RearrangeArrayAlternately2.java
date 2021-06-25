package com.challenges.gfg.arrays;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RearrangeArrayAlternately2 {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(read.readLine());
			int[] temp = new int[n];
			String str[] = read.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				temp[i] = Integer.parseInt(str[i]);
			}
			RearrangeAlternate obj = new RearrangeAlternate();
			obj.rearrange1(temp, n);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n; i++) {
				sb.append(temp[i] + " ");
			}
			System.out.println(sb);
		}
	}

}

class RearrangeAlternate {
	public static void rearrange(int arr[], int n) {

		// Your code here
		int[] arr2 = arr.clone();
		int mid = arr2.length / 2;
		java.util.Arrays.sort(arr2);
		for (int i = 0, j = 0; i < mid; i++) {
			arr[j++] = arr2[arr2.length - 1 - i];
			arr[j++] = arr2[i];
			// if (j < arr2.length)
			// arr[j++] = arr2[arr2.length - 1 - i];
		}
		if (arr2.length > 1 && mid * 2 < n) {
			arr[n - 1] = arr2[mid];
		}

	}

	public static void rearrange1(int arr[], int n) {
		int min = 0;
		int max = n - 1;
		int i = 0;
		int max_element = arr[max] + 1;
		while (min <= max) {
			if (i % 2 == 0) {
				// Even
				arr[i] = arr[i] + ((arr[max] % max_element) * max_element);
				max--;
			} else {
				// Odd
				arr[i] = arr[i] + ((arr[min] % max_element) * max_element);
				min++;
			}
			i++;
		}
		for (i = 0; i < n; i++) {
			arr[i] = arr[i] / max_element;
		}
	}
}