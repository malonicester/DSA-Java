package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '1', '0', '0' },
                {'0', '0', '0', '1', '1' }
        };
        int ans = numberOfIslands(grid);
        System.out.println(ans);
    }

    static int numberOfIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    count++;
                    bfs(grid, visited, row, col);
                }
            }
        }
        return count;
    }

    private static void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        while (!queue.isEmpty()) {
            int r = queue.peek()[0];
            int c = queue.peek()[1];
            queue.remove();
            if (r - 1 >= 0) {
                if (grid[r - 1][c] == '1' && !visited[r - 1][c]) {
                    visited[r - 1][c] = true;
                    queue.add(new int[]{r - 1, c});
                }
            }
            if (r + 1 < n) {
                if (grid[r + 1][c] == '1' && !visited[r + 1][c]) {
                    visited[r + 1][c] = true;
                    queue.add(new int[]{r + 1, c});
                }
            }
            if (c - 1 >= 0) {
                if (grid[r][c - 1] == '1' && !visited[r][c - 1]) {
                    visited[r][c - 1] = true;
                    queue.add(new int[]{r, c - 1});
                }
            }
            if (c + 1 < m) {
                if (grid[r][c + 1] == '1' && !visited[r][c + 1]) {
                    visited[r][c + 1] = true;
                    queue.add(new int[]{r, c + 1});
                }
            }
        }
    }
}
