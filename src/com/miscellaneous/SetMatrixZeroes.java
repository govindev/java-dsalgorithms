package com.miscellaneous;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean zeroRow = false, zeroCol = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) zeroCol = true;
                    if (j == 0) zeroRow = true;
                }
            }
        }

        for (int i = matrix.length-1; i >= 0; i--) {
            for (int j = matrix[i].length-1; j >= 0; j--) {
                if (i == 0) {
                    if (zeroCol == true) matrix[i][j] = 0;
                }
                else if (j == 0) {
                    if (zeroRow == true) matrix[i][j] = 0;
                }
                else if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public void setZeroesWithExtraSpace(int[][] matrix) {

        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
