package com.miscellaneous;

import java.util.ArrayList;

public class SubarrayWithSum {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 7, 5};
        int n = 5, s = 12;
        System.out.println(subarraySum(arr, n, s));
    }
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        int start = 0, sum = arr[start];
        if (sum == s) {
            return res(start, start);
        }
        for (int end = 1; end < n; end++) {
            if (s == arr[end]) {
                return res(end, end);
            } else if (s < arr[end]) {
                start = end+1;
                sum = 0;
            }
            sum += arr[end];
            if (sum == s) return res(start, end);
            while (sum > s && start < end) {
                sum -= arr[start];
                start++;
                if (sum == s) return res(start, end);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        return res;
    }

    static ArrayList<Integer> res(int start, int end) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(start+1);
        res.add(end+1);
        return res;
    }
}
