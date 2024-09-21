package com.sdesheet.blind;

import java.util.Arrays;

public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        boolean isRowZeroAZeroRow = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    // rowMarks[i] = 0;
                    if (i == 0) {
                        isRowZeroAZeroRow = true;
                    } else {
                        matrix[i][0] = 0;
                    }

                    // colMarks[j] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // For the first column
        if (matrix[0][0] == 0) {
            for (int i = 1; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        // For the first row
        if (isRowZeroAZeroRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public void setZeroesExtraSpace(int[][] matrix) {
        int[] rowMarks = new int[matrix.length];
        Arrays.fill(rowMarks, -1);
        int[] colMarks = new int[matrix[0].length];
        Arrays.fill(colMarks, -1);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowMarks[i] = 0;
                    colMarks[j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowMarks[i] == 0 || colMarks[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
