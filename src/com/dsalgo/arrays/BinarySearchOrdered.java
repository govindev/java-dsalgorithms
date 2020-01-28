package com.dsalgo.arrays;

public class BinarySearchOrdered {

	private static int key = 1;

	private static void print(String message, int[] array) {
		System.out.println("\n " + message);
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}

	private static Integer search(int[] sortedArray, int startIndex, int endIndex) {
		int mid = (startIndex + endIndex) / 2;
		if (key == sortedArray[mid]) {
			return mid;
		} else if (key > sortedArray[mid]) {
			startIndex = mid + 1;
			if (startIndex < endIndex)
			return search(sortedArray, startIndex, endIndex);
		} else if (key < sortedArray[mid]) {
			endIndex = mid - 1;
			if (endIndex > startIndex)
			return search(sortedArray, startIndex, endIndex);
		}
		return null;
	}
	
	public static void main(String[] args) {
		int sortedArray[] = {2, 4, 6, 8, 10};
		print("Sorted Array elements : ", sortedArray);
		System.out.println("\nSearch element is : " + key);
		
		Integer index = search(sortedArray, 0, sortedArray.length);
		if (index != null) {
			System.out.println("Search element found in the array at the index : " + index);
		} else {
			System.out.println("Element not found in the array");
		}
	}

}


// First search n, Second search n/2, third search n/4, .... (i-1)th search =2, ith search = n/2^(i-1) = 1
// 2^(i - 1) = n
// (i - 1) = log2 ^n
// Worst time complexity find(item) = O(log2 ^ n) 


// n         log2 ^ n
// 2           1
// 1024        10
//1048576(million)     20
// billion     40










// Insertion of items time complexity
// array = {3, 7, 20, 32, 45, 55, 60, 75
// Insert(52)
// Insert(item) = O(n)
// Search(item) = O(log2 ^ n)



// Deletion of items time complexity
// Delete(55)
// Delete(item) = O(n)