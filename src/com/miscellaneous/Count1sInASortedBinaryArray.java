package com.miscellaneous;

public class Count1sInASortedBinaryArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 0, 0, 0, 0, 0};
        System.out.println(count1s(arr));
        arr = new int[] {1, 1, 1, 1, 1, 1, 1};
        System.out.println(count1s(arr));
    }

    public static int count1s(int[] arr) {
        // For decreasing binary array
        int left = 0, right = arr.length-1, end = -1;
        // Find the end
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] == 1) {
                if (mid != arr.length-1 && arr[mid+1] == 1) {
                    left = mid+1;
                } else {
                    end = mid;
                    break;
                }
            } else if (arr[mid] == 0) right = mid-1;
        }
        return end+1;
    }
}
