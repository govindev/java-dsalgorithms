package com.dsalgo.recursion;

public class TowerOfHanoi2 {

	private static void move(int noOfElmnts, char src, char dest, char temp) {
		if (noOfElmnts - 1 > 0) {
			move(noOfElmnts - 1, src, temp, dest);
		}
		System.out.println("Moving disc " + noOfElmnts + " from " + src + " to " + dest);
		if (noOfElmnts - 1 > 0) {
			move(noOfElmnts - 1, temp, dest, src);
		}
	}

	public static void main(String[] args) {
		move(3, 'A', 'C', 'B');
	}

}
