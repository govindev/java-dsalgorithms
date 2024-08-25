package com.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return Collections.emptyList();
        if (numRows == 1) {
            List<List<Integer>> rows = new ArrayList<>();
            rows.add(List.of(1));
            return rows;
        }
        List<List<Integer>> prevRows = generate(numRows - 1);
        List<Integer> prevRow = prevRows.getLast();

        List<Integer> currRow = new ArrayList<>();
        currRow.add(1);
        int i = 0;
        while (i < prevRow.size() - 1) {
            currRow.add(prevRow.get(i) + prevRow.get(i+1));
            i++;
        }
        currRow.add(1);

        prevRows.add(currRow);
        return prevRows;
    }
}
