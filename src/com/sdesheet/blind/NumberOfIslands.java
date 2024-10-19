package com.sdesheet.blind;

public class NumberOfIslands {
    public static void main(String[] args) {
        // [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
        int[][] grid = new int[][] {{}, {}};
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println("Number of islands : "+ numberOfIslands.numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        int islands = 0;
        boolean[][] used = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (dfs(grid, used, i, j)) {
                    islands++;
                }
            }
        }
        return islands;
    }

    private boolean dfs(char[][] grid, boolean[][] used, int i, int j) {
        if (i < 0 || i > grid.length-1
                || j < 0 || j > grid[i].length-1
                || grid[i][j] == 0
                || used[i][j]) {
            return false;
        }
        used[i][j] = true;
        dfs(grid, used, i-1, j);
        dfs(grid, used, i, j+1);
        dfs(grid, used, i+1, j);
        dfs(grid, used, i, j-1);

        return true;
    }
}
