package com.miscellaneous;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }

    public void rotateLatest(int[][] matrix) {
        int len = matrix.length;
        for (int col = 0; col < len; col++) {
            for (int row = col; row < len; row++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            int left = 0, right = len-1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++; right--;
            }
        }
    }

    public static void rotate(int[][] matrix) {
        // 1. Transpose the Matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 2. Rever the matrix
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
