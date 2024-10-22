package com.sdesheet.blind;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix.length < 1) return;

        // setZerosWithExtraSpace(matrix);
        setZerosWithoutExtraSpace(matrix);
    }

    private void setZerosWithExtraSpace(int[][] matrix) {
        int MARK_ZERO_FLAG = 1;

        int[] rowsWithZeros = new int[matrix.length];
        int[] colsWithZeros = new int[matrix[0].length];


        markZerosUsingFlags(matrix, rowsWithZeros, colsWithZeros, MARK_ZERO_FLAG);
        setZerosUsingFlags(matrix, rowsWithZeros, colsWithZeros, MARK_ZERO_FLAG);

    }

    private void markZerosUsingFlags(int[][] matrix, int[] rowsWithZeros, int[] colsWithZeros,
                                     int MARK_ZERO_FLAG) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowsWithZeros[i] = MARK_ZERO_FLAG;
                    colsWithZeros[j] = MARK_ZERO_FLAG;
                }
            }
        }
    }

    private void setZerosUsingFlags(int[][] matrix, int[] rowsWithZeros, int[] colsWithZeros,
                                    int MARK_ZERO_FLAG) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowsWithZeros[i] == MARK_ZERO_FLAG
                        || colsWithZeros[j] == MARK_ZERO_FLAG) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void setZerosWithoutExtraSpace(int[][] matrix) {
        boolean isRowZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 && matrix[i][j] == 0) {
                    isRowZero = true;
                }
                else if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
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

        // Set zero column
        if (matrix[0][0] == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        // Set zero row
        if (isRowZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
