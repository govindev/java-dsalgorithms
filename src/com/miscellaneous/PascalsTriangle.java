package com.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        if (numRows < 1) return rows;

        List<Integer> currRow = List.of(1);
        rows.add(currRow);

        for (int i = 1; i < numRows; i++) {
            currRow = nextRow(currRow);
            rows.add(currRow);
        }

        return rows;
    }

    private static List<Integer> nextRow(List<Integer> row) {
        List<Integer> next = new ArrayList<>();

        next.add(1);
        for (int i = 1; i < row.size(); i++) {
            next.add(row.get(i) + row.get(i-1));
        }
        next.add(1);

        return next;
    }
}
