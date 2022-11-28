package com.sdesheet.striver;

public class SearchA2DMatrix {
    public static void main(String[] args) {
//        int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = new int[][] {{1,3}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m-1;
        while (left <= right) {
            int mid = (left+right)/2;

            if (matrix[mid][0] == target) return true;

            if (target < matrix[mid][0]) { right = mid-1; continue; }

            if (target > matrix[mid][n-1]) { left = mid+1; continue; }

            // Do binary search in the current row
            int l = 0, r = n-1;
            while (l <= r) {
                int rm = (l+r)/2;

                if (matrix[mid][rm] == target) return true;
                if (target < matrix[mid][rm]) r = rm - 1;
                else l = rm + 1;
            }
            return false;
        }
        return false;
    }
}
