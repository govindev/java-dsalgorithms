package com.dsalgo.recursion;

public class TowersOfHanoi {

	private static void moveElements(int noOfElements, CStack<Integer> source, CStack<Integer> destination,
			CStack<Integer> temp) {
		// 1. Move (n-1) elements from source to temp using destination
		if (noOfElements - 1 > 0) {
			// Only if elements are there
			moveElements(noOfElements - 1, source, temp, destination);
		}

		// 2. Move nth element from source to destination
		Integer element = source.pop();
		System.out.println(element + " : " + source + " -> " + destination);
		destination.push(element);

		// 3. Move (n-1) elements from temp to destination using source
		if (noOfElements - 1 > 0) {
			// Only if elements are there
			moveElements(noOfElements - 1, temp, destination, source);
		}

	}

	public static void main(String[] args) {
		CStack<Integer> source = new CStack<Integer>("Src");
		CStack<Integer> temp = new CStack<Integer>("Temp");
		CStack<Integer> destination = new CStack<Integer>("Dest");

		source.push(3);
		source.push(2);
		source.push(1);

		moveElements(source.size(), source, destination, temp);
	}

}
