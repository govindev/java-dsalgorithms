package com.sdesheet.striver.arrays;

import java.util.Arrays;

public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        // Most optimized
        int colZero = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        colZero = 0;
                }
            }
        }

        for (int i = matrix.length-1; i >= 0; i--) {
            for (int j = matrix[i].length-1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    if (j == 0) {
                        if (colZero == 0) matrix[i][j] = 0;
                    } else if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }


    public void setZeroesOptimized(int[][] matrix) {
        int[] row = new int[matrix.length];
        Arrays.fill(row,1);
        int[] col = new int[matrix[0].length];
        Arrays.fill(col,1);
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (matrix[i][j] != 0 && (row[i] == 0 || col[j] == 0)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }




    public void setZeroesBruteForce(int[][] matrix) {
        // Works if -1 is said to be not present in the arry
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    // Mark all elements of row and column to -1's
                    matrix[i][j] = -1;
                    markRowAndColumn(i, j, matrix);
                } else matrix[i][j]--;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = 0;
            }
        }
    }

    private void markRowAndColumn(int row, int col, int[][] matrix) {
        // Mark row
        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i] != 0) matrix[row][i] = -1;
        }
        // Mark col
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] != 0) matrix[i][col] = -1;
        }
    }
}
