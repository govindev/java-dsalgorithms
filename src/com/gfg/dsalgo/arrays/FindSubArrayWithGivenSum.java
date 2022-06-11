package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FindSubArrayWithGivenSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter Sum : ");
        int givenSum = Integer.parseInt(br.readLine());


        // In both the below approaches we are using sliding window concept
        // This works fine for array with non-negative elements
        findSubArrayWithGivenSum(array, givenSum);
        System.out.println("Found : " + findSubArrayWithGivenSumRefactor(array, givenSum));
    }

    private static boolean findSubArrayWithGivenSumRefactor(int[] arr, int givenSum) {
        int sum = arr[0], start = 0;
        for (int i = 1; i < arr.length; i++) {
            while(sum > givenSum && start < i-1) {
                sum -= arr[start]; start++;
            }
            if (sum == givenSum) return true;
            sum += arr[i];
        }
        return (sum == givenSum);
    }

    private static boolean findSubArrayWithGivenSum(int[] arr, int givenSum) {
        int sum = arr[0];
        int start = 0, i = 0;
        while(true) {
            if(sum < givenSum) {
                i++;
                if (i >= arr.length) {
                    break;
                }
                sum += arr[i];
            }
            if (sum > givenSum) {
                if (start >= arr.length) {
                    break;
                }
                sum -= arr[start];
                start++;
            }
            if (sum == givenSum) {
                System.out.println("Found the sub array with the given sum. It starts at index : " + start + ", ends at index : " + i);
                return true;
            }
        }
        System.out.println("There exists no sub array with the given sum ");
        return false;
    }


    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        // Subarray with given sum
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0, right = 0, sum = 0;
        while (left < n && right < n) {
            if (left == right) sum = arr[left];
            if (sum == s) {
                list.add(left+1);list.add(right+1); return list;
            }
            if (sum > s) {
                if (left == right) {
                    left++;
                    right++;
                } else {
                    sum -= arr[left];
                    left++;
                }
            }
            if (sum < s) {
                if (right+1 < n) {
                    right++;
                    sum += arr[right];
                } else {
                    break;
                }
            }
        }
        list.add(-1);
        return list;
    }
}
