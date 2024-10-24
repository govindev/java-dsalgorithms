package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlantic {
    int[][] heights;
    Set<Integer> pacific;
    Set<Integer> atlantic;
    int rowLen;
    int colLen;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        pacific = new HashSet<>();
        atlantic = new HashSet<>();
        rowLen = heights.length;
        colLen = heights[0].length;

        for (int c = 0; c < colLen; c++) {
            dfs(0, c, heights[0][c], pacific);
            dfs(rowLen-1, c, heights[rowLen-1][c], atlantic);
        }

        for (int r = 0; r < rowLen; r++) {
            dfs(r, 0, heights[r][0], pacific);
            dfs(r, colLen-1, heights[r][colLen-1], atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int key = key(i, j);
                if (pacific.contains(key) && atlantic.contains(key)) {
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }


    private void dfs(int i, int j, int prevHeight, Set<Integer> visited) {
        if (i < 0 || i > rowLen-1
                || j < 0 || j > colLen-1
                || visited.contains(key(i, j))
                || heights[i][j] < prevHeight) {
            return;
        }
        visited.add(key(i,j));

        dfs(i-1, j, heights[i][j], visited);
        dfs(i, j+1, heights[i][j], visited);
        dfs(i+1, j, heights[i][j], visited);
        dfs(i, j-1, heights[i][j], visited);
    }

    private int key(int i, int j) {
        return (i * colLen) + j;
    }
}
