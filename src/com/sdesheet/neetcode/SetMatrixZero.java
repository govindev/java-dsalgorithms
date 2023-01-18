package com.sdesheet.neetcode;

import java.util.Arrays;

public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        boolean isZeroCol = false, isZeroRow = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (j == 0) isZeroRow = true;
                    if (i == 0) isZeroCol = true;
                }
            }
        }

        for (int i = matrix.length-1; i >= 0; i--) {
            for (int j = matrix[i].length-1; j >= 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    if (i != 0 && j != 0) matrix[i][j] = 0;
                    if ((j == 0 && isZeroRow) || (i == 0 && isZeroCol)) matrix[i][j] = 0;
                }
            }
        }
    }
    public void setZeroes1(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        // Fill the rows and cols arrays with non-zero values
        Arrays.fill(rows, 1);
        Arrays.fill(cols, 1);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 0;
                    cols [j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows[i] == 0 || cols[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
