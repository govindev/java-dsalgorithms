package com.gfg.dsalgo.searching;

public class ThreeSumSortedArray {
    public static void main(String[] args) {
        int A[] = new int[] {1,2,3,4,5,6};
        System.out.println(find3Numbers(A, 6, 15));
    }

    public static boolean find3Numbers(int A[], int n, int X) {

        for (int i = 0; i < n-2; i++) {
            int sum = X - A[i];
            int left = 1, right = n-1;
            while (left < right) {
                int curr = A[left]+A[right];
                if (curr == sum) return true;
                if (curr > sum) right--;
                else left++;
            }
        }
        return false;
    }

}
