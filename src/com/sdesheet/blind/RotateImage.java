package com.sdesheet.blind;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,2,3}, {4,5,6}, {7,8,9}
        };
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
        rotateImage.printMatrix(matrix);
    }

    public void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.print("[");
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.print("],");
        }
    }

    public void rotate(int[][] matrix) {
        // transposeMatrix(matrix);
        rotateOptimized(matrix);
    }

    public void rotateOptimized(int[][] matrix) {
        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix.length - 1;
        while (top <= bottom && left <= right) {
            for (int i = 0; left+i < right; i++) {
                int temp = matrix[bottom-i][left];
                matrix[bottom-i][left] = matrix[bottom][right-i];
                matrix[bottom][right-i] = matrix[top+i][right];
                matrix[top+i][right] = matrix[top][left+i];
                matrix[top][left+i] = temp;
            }
            top++; left++; bottom--; right--;
        }
    }

    private void transposeMatrix(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                temp[j][i] = matrix[i][j];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            int[] row = temp[i];
            int left = 0, right = temp.length - 1;
            while (left <= right) {
                int holder = row[left];
                matrix[i][left] = row[right];
                matrix[i][right] = holder;

                left++;
                right--;
            }
        }
    }
}
