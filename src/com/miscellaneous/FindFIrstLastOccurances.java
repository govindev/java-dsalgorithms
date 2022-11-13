package com.miscellaneous;

public class FindFIrstLastOccurances {
    public ArrayList<Integer> firstAndLast(int arr[], int n, int x){
        ArrayList<Integer> list = new ArrayList<>();
        int first = findFirst(arr, n, x);
        if (first == -1) {
            list.add(-1);
            return list;
        }
        int last = findLast(arr, n, x);
        list.add(first);
        list.add(last);
        return list;
    }

    public int findFirst(int arr[], int n, int x) {
        int left = 0, right = n-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] == x) {
                if (mid == 0 || arr[mid-1] != arr[mid]) return mid;
                right = mid-1;
            }
            else if (arr[mid] > x) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }

    public int findLast(int arr[], int n, int x) {
        int left = 0, right = n-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] == x) {
                if (mid == n-1 || arr[mid+1] != arr[mid]) return mid;
                left = mid+1;
            }
            if (arr[mid] > x) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }
}
