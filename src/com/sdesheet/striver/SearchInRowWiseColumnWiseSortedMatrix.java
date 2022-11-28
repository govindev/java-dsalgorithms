package com.sdesheet.striver;

public class SearchInRowWiseColumnWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        int target = 29;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n-1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (target > matrix[i][j]) i++;
            else j--;
        }

        return false;
    }
}
