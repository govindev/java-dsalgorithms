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
        int MARK_ZERO_FLAG = 0;
        boolean isRowZeroAZeroRow = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        isRowZeroAZeroRow = true;
                    } else {
                        matrix[i][0] = MARK_ZERO_FLAG;
                    }
                    matrix[0][j] = MARK_ZERO_FLAG;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0 &&
                        (matrix[i][0] == MARK_ZERO_FLAG || matrix[0][j] == MARK_ZERO_FLAG)) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == MARK_ZERO_FLAG) {
            setZerosForFirstColumn(matrix);
        }
        if (isRowZeroAZeroRow) {
            setZerosForFirstRow(matrix);
        }

    }

    private void setZerosForFirstColumn(int[][] matrix) {
        int j = 0;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = 0;
        }
    }

    private void setZerosForFirstRow(int[][] matrix) {
        int i = 0;
        for (int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] = 0;
        }
    }
}
