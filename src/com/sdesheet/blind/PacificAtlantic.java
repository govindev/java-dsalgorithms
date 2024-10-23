package com.sdesheet.blind;

public class PacificAtlantic {
    List<List<Integer>> result;
    boolean[][] pacificFlows;
    boolean[][] atlanticFlows;
    int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        pacificFlows = new boolean[heights.length][heights[0].length];
        atlanticFlows = new boolean[heights.length][heights[0].length];
        result = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                pacificFlow(i, j);
            }
        }
        for (int i = heights.length-1; i >= 0; i--) {
            for (int j = heights[i].length-1; j >= 0; j--) {
                atlanticFlow(i, j);
            }
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (pacificFlows[i][j] && atlanticFlows[i][j]) {
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }

    private boolean pacificFlow(int i, int j) {
        if (i < 0 || i > heights.length-1
                || j < 0 || j > heights.length-1) {
            return false;
        }
        if (i == 0 || j == 0 || pacificFlows[i][j]) {
            pacificFlows[i][j] = true;
            return true;
        }
        int height = heights[i][j];
        if ((canExplore(i-1, j, height) && pacificFlow(i-1, j))
                || (canExplore(i, j+1, height) && pacificFlow(i, j+1))
                || (canExplore(i+1, j, height) && pacificFlow(i+1, j))
                || (canExplore(i, j-1, height) && pacificFlow(i, j-1))) {
            pacificFlows[i][j] = true;
            return true;
        }
        return false;
    }

    private boolean canExplore(int i, int j, int fromHeight) {
        if (i < 0 || i > heights.length-1
                || j < 0 || j > heights.length-1) {
            return false;
        }
        return (fromHeight >= heights[i][j]);
    }

    private boolean atlanticFlow(int i, int j) {
        if (i < 0 || i > heights.length-1
                || j < 0 || j > heights.length-1) {
            return false;
        }
        if (i == heights.length-1 || j == heights.length-1 || atlanticFlows[i][j]) {
            atlanticFlows[i][j] = true;
            return true;
        }
        int height = heights[i][j];
        if ((canExplore(i-1, j, height) && atlanticFlow(i-1, j))
                || (canExplore(i, j+1, height) && atlanticFlow(i, j+1))
                || (canExplore(i+1, j, height) && atlanticFlow(i+1, j))
                || (canExplore(i, j-1, height) && atlanticFlow(i, j-1))) {
            atlanticFlows[i][j] = true;
            return true;
        }
        return false;
    }

}
