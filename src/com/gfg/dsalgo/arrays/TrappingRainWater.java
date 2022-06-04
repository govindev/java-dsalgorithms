package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrappingRainWater {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Max units of water that can be saved is : " + getMaxUnitsOfWater(array));
    }

    private static int getMaxUnitsOfWater(int[] arr) {
        int[] lmax = new int[arr.length];
        lmax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lmax[i] = Math.max(lmax[i-1], arr[i]);
        }

        int[] rmax = new int[arr.length];
        rmax[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length-2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i+1], arr[i]);
        }

        int maxWater = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            maxWater += Math.min(lmax[i], rmax[i]) - arr[i];
        }

        return maxWater;
    }

}
