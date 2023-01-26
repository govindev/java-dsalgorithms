package com.miscellaneous;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }

    public void rotateLatest(int[][] matrix) {
        // Method 2 : Rotate one element at a time
        int left = 0, right = matrix.length-1;
        while (left < right) {
            int top = left, bottom = right;
            for (int i = 0; i < right-left; i++) {
                int temp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }
            left++; right--;
        }
    }

    public static void rotate(int[][] matrix) {
        // Method 1 : Using the Transpose approach
        // Step 1 : Transpose the Matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                // swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Step 2 : Reverse all the rows
        for (int i = 0; i < matrix.length; i++) {
            int left = 0, right = matrix.length - 1;
            while (left < right) {
                // swap
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++; right--;
            }
        }
    }
}
