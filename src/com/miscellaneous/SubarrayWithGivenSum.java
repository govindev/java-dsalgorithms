package com.miscellaneous;

import java.util.ArrayList;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,7,5};
        int n = 5, s = 12;
        subarraySum(arr, n, s);
    }
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> res = new ArrayList<>();

        // Two-pointer approach
        int left = 0, sum = 0;
        for (int right = 0; right < n; right++) {
            if (arr[right] == s) return resp(right, right);
            if (arr[right] > s) {
                left = right+1;
                sum = 0;
                continue;
            }

            if (sum+arr[right] == s) return resp(left, right);
            if (sum+arr[right] < s) {
                sum += arr[right];
                continue;
            }

            sum -= arr[left];
            left++;
            right--;
        }
        res.add(-1);
        return res;
    }

    static ArrayList<Integer> resp(int start, int end) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(start+1);
        res.add(end+1);
        return res;
    }
}
