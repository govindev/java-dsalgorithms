package com.sdesheet.blind;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println("Number of islands : "+ numberOfIslands.numIslands(grid));
    }

    char[][] grid;
    boolean[][] used;
    Queue<int[]> queue;

    public int numIslands(char[][] grid) {
        if (grid.length <= 0) {
            return 0;
        }
        this.grid = grid;
        used = new boolean[grid.length][grid[0].length];
        return numIslandsDfs();
        // return numIslandsBfs();
    }

    private int numIslandsBfs() {
        int islands = 0;
        queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1'
                        && !used[i][j]) {
                    bfs(i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(int i, int j) {
        queue.add(new int[]{i,j});
        used[i][j] = true;
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int row = pair[0];
            int col = pair[1];
            int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            for (int[] direction : directions) {
                i = row+direction[0];
                j = col+direction[1];

                if (i >= 0 && i <= grid.length-1 && j >=0 && j <= grid[i].length-1
                        && !used[i][j] && grid[i][j] == '1') {
                    queue.add(new int[]{i, j});
                    used[i][j] = true;
                }
            }
        }
    }

    private int numIslandsDfs() {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (dfs(i, j)) {
                    islands++;
                }
            }
        }
        return islands;
    }

    private boolean dfs(int i, int j) {
        if (i < 0 || i > grid.length-1
                || j < 0 || j > grid[i].length-1
                || grid[i][j] == '0'
                || used[i][j]) {
            return false;
        }
        used[i][j] = true;

        dfs(i-1, j);
        dfs(i, j+1);
        dfs(i+1, j);
        dfs(i, j-1);

        return true;
    }
}
