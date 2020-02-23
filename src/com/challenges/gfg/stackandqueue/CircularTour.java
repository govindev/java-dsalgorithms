package com.challenges.gfg.stackandqueue;

import java.util.*;

/**
 * Suppose there is a circle. There are N petrol pumps on that circle. You will
 * be given two sets of data. 1. The amount of petrol that every petrol pump
 * has. 2. Distance from that petrol pump to the next petrol pump.
 * 
 * Your task is to complete the function tour() which returns an integer
 * denoting the first point from where a truck will be able to complete the
 * circle (The truck will stop at each petrol pump and it has infinite
 * capacity).
 * 
 * Note : Assume for 1 litre petrol, the truck can go 1 unit of distance.
 * 
 * Input: The first line of input will be the number of test cases. Then T test
 * cases follow. Each Test case contains 2 lines. The first line will contain an
 * integer N denoting the number of petrol pumps and in the next line are N
 * space separated values petrol and distance denoting the amount of petrol
 * every petrol pump has and the distance to next petrol pump respectively .
 * 
 * Output: The output of each test case will be the index of the the first point
 * from where a truck will be able to complete the circle otherwise -1 .
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 50 1 <= petrol, distance <= 100
 * 
 * Example (To be used only for expected output) Input: 1 4 4 6 6 5 7 3 4 5
 * Output: 1
 * 
 * Explanation: Testcase 1: there are 4 petrol pumps with amount of petrol and
 * distance to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4,
 * 5}. The first point from where truck can make a circular tour is 2nd petrol
 * pump. Output in this case is 1 (index of 2nd petrol pump).
 * 
 * @author Govind
 *
 */

class CircularTour {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j = 0;
			int k = 0;
			for (int i = 0; i < 2 * n; i++) {
				if (i % 2 == 0) {
					p[j] = Integer.parseInt(arr[i]);
					j++;
				} else {
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}

			System.out.println(tour(p, d));
			t--;
		}
	}

	private static int tour(int petrol[], int distance[]) {
		PetrolStationNode head = null;
		PetrolStationNode prev = null;
		for (int i = 0; i < petrol.length; i++) {
			PetrolStation petrolStation = new PetrolStation(petrol[i], distance[i]);
			PetrolStationNode petrolStationNode = new PetrolStationNode(petrolStation);
			if (head == null) {
				head = petrolStationNode;
				prev = head;
			} else {
				prev.nextPetrolStationNode = petrolStationNode;
				prev = petrolStationNode;
			}
			if (i == petrol.length - 1) {
				petrolStationNode.nextPetrolStationNode = head;
			}
		}
		// Start from head
		for (int i = 0; i < petrol.length; i++) {
			boolean isCurrentStationThePointToStart = true;
			PetrolStationNode current = head;
			int trucksLeftFuel = 0;
			do {
				PetrolStation currnetPetrolStation = current.petrolStation;
				trucksLeftFuel += currnetPetrolStation.petrol;
				int distanceToNextPetrolStation = currnetPetrolStation.distanceToNextStation;
				trucksLeftFuel = trucksLeftFuel - distanceToNextPetrolStation;
				if (trucksLeftFuel < 0) {
					// If the truck starts at the present head's petrol station it won't be able to
					// make round trip
					isCurrentStationThePointToStart = false;
					break;
				}
				current = current.nextPetrolStationNode;
			} while (current != head);
			if (!isCurrentStationThePointToStart) {
				head = head.nextPetrolStationNode;
			} else {
				return i;
			}
		}
		return -1;
	}
}

class PetrolStation {
	int petrol;
	int distanceToNextStation;

	PetrolStation(int petrol, int distanceToNextStation) {
		this.petrol = petrol;
		this.distanceToNextStation = distanceToNextStation;
	}

	@Override
	public String toString() {
		return "{" + petrol + " " + distanceToNextStation + " }";
	}
}

class PetrolStationNode {
	PetrolStation petrolStation;
	PetrolStationNode nextPetrolStationNode;

	PetrolStationNode(PetrolStation petrolStation) {
		this.petrolStation = petrolStation;
		this.nextPetrolStationNode = null;
	}
}