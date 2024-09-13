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

    private void rotateOptimized(int[][] matrix) {
        int start = 0, end = matrix.length - 1, i = 0;
        while (start+i < end && start < end) {
            // temp = topLeft;
            int temp = matrix[start][start+i];
            // topLeft = bottomLeft;
            matrix[start][start+i] = matrix[end-i][start];
            // bottomLeft = bottomRight
            matrix[end-i][start] = matrix[end][end-i];
            // bottomRight = topRight
            matrix[end][end-i] = matrix[start+i][end];
            // topRight = topLeft (which is temp)
            matrix[start+i][end] = temp;

            i++;
            if (start+i == end) {
                start = start+1;
                end = end - 1;
                i = 0;
            }
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
