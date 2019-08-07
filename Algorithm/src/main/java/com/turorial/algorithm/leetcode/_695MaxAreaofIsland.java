package com.turorial.algorithm.leetcode;

/** https://leetcode.com/problems/max-area-of-island/ */
public class _695MaxAreaofIsland {
  int[][] directions = new int[][] {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

  public int maxAreaOfIsland(int[][] grid) {
    int maxResult = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && grid[i][j] == 1)
          maxResult = Math.max(maxResult, dfs(grid, visited, i, j));
      }
    }

    return maxResult;
  }

  public int dfs(int[][] grid, boolean[][] visited, int x, int y) {

    visited[x][y] = true;
    int result = 1;
    for (int[] direction : directions) {
      int a = direction[0] + x;
      int b = direction[1] + y;

      if (a < 0 || a >= grid.length || b < 0 || b >= grid[0].length) {
        continue;
      }
      if (grid[a][b] == 1 && !visited[a][b]) {
        result += dfs(grid, visited, a, b);
      }
    }
    return result;
  }
}
