package com.sdesheet.striver;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        // 1. Transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 2. Reverse
        for (int i = 0; i < matrix.length; i++) {
            int left = 0, right = matrix[i].length-1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++; right--;
            }
        }
    }
}
