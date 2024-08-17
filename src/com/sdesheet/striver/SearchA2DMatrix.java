package com.sdesheet.striver;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int[][] matrix = new int[][] {{1,3}};
        int target = 3;
        System.out.println(search2DMatrix(matrix, target));
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


    public static boolean search2DMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int top = 0; int bottom = rowLen - 1;
        while (top <= bottom) {
            int center = (top+bottom) / 2;
            if (target >= matrix[center][0] && target <= matrix[center][colLen-1]) {
                int start = 0;
                int end = colLen-1;
                while (start <= end) {
                    int mid = (start+end) / 2;
                    if (matrix[center][mid] == target) return true;
                    else if (matrix[center][mid] > target) end = mid-1;
                    else start = mid+1;
                }
                return false;
            }
            else if (target < matrix[center][0]) bottom = center - 1;
            else top = center + 1;
        }
        return false;
    }
}
