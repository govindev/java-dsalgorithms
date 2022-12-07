package com.sdesheet.blind;

public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Identify the row
        int rowInd = -1;
        int low = 0, high = matrix.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            int right = matrix[mid].length-1;
            if (target >= matrix[mid][0] && target <= matrix[mid][right]) {
                rowInd = mid;
                break;
            } else if (target > matrix[mid][right]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        if (rowInd == -1) return false;
        // Search in the row
        int left = 0, right = matrix[rowInd].length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (target == matrix[rowInd][mid]) {
                return true;
            } else if (target > matrix[rowInd][mid]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }
}
