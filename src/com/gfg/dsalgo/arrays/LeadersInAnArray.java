package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeadersInAnArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        printLeaders(array);
        printLeadersEfficient(array);
    }

    private static void printLeaders(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isLeader = true;
            for (int j = i+1; j < array.length; j++) {
                if (array[i] <= array[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader)
            {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.print(array[array.length - 1] + ", ");
    }

    private static void printLeadersEfficient(int[] array) {
        int leader = array[array.length-1];
        System.out.print("\n" + leader + ", ");

        for(int i = array.length-2; i >= 0; i--) {
            if (array[i] > leader) {
                System.out.print(array[i] + ", ");
                leader = array[i];
            }
        }
    }
}
