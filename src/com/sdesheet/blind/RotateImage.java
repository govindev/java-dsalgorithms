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

    private void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach(layer -> {
            System.out.println();
            Arrays.stream(layer).forEach(value -> System.out.print(value + " "));
        });
    }

    public void rotate(int[][] matrix) {
        if (isRotationIsNotRequired(matrix)) return;
        if (isNotASquare(matrix)) return;

        // rotateUsingTransposeMethod(matrix);

        int left = 0, right = matrix.length - 1, top = 0, bottom = matrix.length - 1;
        rotateLayer(matrix, left, right, top, bottom);
    }

    public void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverseRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int left = 0, right = matrix[i].length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++; right--;
            }
        }
    }

    public void rotateUsingTransposeMethod(int[][] matrix) {
        transposeMatrix(matrix);
        reverseRows(matrix);
    }

    private void rotateLayer(int[][] matrix, int left, int right, int top, int bottom) {
        if (hasNoMoreLayersToRotate(left, right)) return;

        for (int i = 0; i < right-left; i++) {
            int corner1 = matrix[top][left+i];
            int corner2 = matrix[top+i][right];
            int corner3 = matrix[bottom][right-i];
            int corner4 = matrix[bottom-i][left];

            matrix[top+i][right] = corner1;
            matrix[bottom][right-i] = corner2;
            matrix[bottom-i][left] = corner3;
            matrix[top][left+i] = corner4;
        }

        rotateLayer(matrix, ++left, --right, ++top, --bottom);
    }

    private boolean hasNoMoreLayersToRotate(int left, int right) {
        return (left >= right);
    }

    private boolean isRotationIsNotRequired(int[][] matrix) {
        return (matrix.length <= 1);
    }

    private boolean isNotASquare(int[][] matrix) {
        return (matrix.length > 1 && matrix.length != matrix[0].length);
    }
}
