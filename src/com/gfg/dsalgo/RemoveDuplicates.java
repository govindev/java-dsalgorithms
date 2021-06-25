package com.gfg.dsalgo;

public class RemoveDuplicates {
	public static void main(String[] args) {
		sumInsured(2000, 1);
		int[] arr = { 10, 20, 20, 20, 30, 40, 40 };
		int size = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[size - 1]) {
				arr[size] = arr[i];
				size++;
			}
		}
		System.out.println("Size before removing the duplicates : " + arr.length);
		System.out.println("Size after removing the duplicates : " + size);
	}
	
	
	private static void sumInsured(double amount, int year) {
		for (int i = 0; i < 10; i++) {
			amount = amount + amount/10;
			System.out.println(amount);
		}
	}

}


