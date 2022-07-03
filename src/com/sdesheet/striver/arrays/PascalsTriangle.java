package com.sdesheet.striver.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println("5th row 3rd column in pascal triangle is : " + findNumber(5,3));
        printRow(5);
    }

    private static void printRow(int row) {
        int res = 1;
        System.out.print(res);
        int temp = row;
        for (int i = 2; i < row; i++) {
            temp--;
            res *= temp;
            res /= (i-1);
            System.out.print(" " + res);
        }
        System.out.print(" " + 1);
    }

    private static int findNumber(int row, int col) {
        // Formula is simple (row-1) C (col-1)
        row--;col--;
        int t = row, b = col;
        for (int i = 2; i <= col; i++) {
            row--;
            t *= row;
            col--;
            b *= col;
        }
        return t/b;
    }
    private static List<List<Integer>> generate(int numRows) {
        // Brute Force
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);
        rows.add(prevRow);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < prevRow.size()-1; j++) {
                row.add(prevRow.get(j)+prevRow.get(j+1));
            }
            row.add(1);
            rows.add(row);
            prevRow = row;
        }
        return rows;
    }
}
