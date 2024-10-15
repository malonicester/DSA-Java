package Graphs;

import RecursionAndDP.Graphs.Pair;

import java.util.*;

public class NumberOfDistinctIslands {
    private static final int[] delRow = {1, 0, -1, 0};
    private static final int[] delCol = {0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] arr = new int[3][];
        for (int i = 0; i < arr.length; i++) {
            int[] new_arr = new int[i];
            for (int j = 0; j < i; j++) {
                new_arr[j] = j;
            }
            arr[i] = new_arr;
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int numberOfDistinctIslands(int[][] arr) {
        Set<List<Pair<Integer, Integer>>> set = new HashSet<>();
        int n = arr.length, m = arr[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    List<Pair<Integer, Integer>> list = new ArrayList<>();
                    dfs(arr, list, i, j, n, m, visited, i, j);
                    if (!list.isEmpty()) set.add(list);
                }
            }
        }
        return set.size();
    }

    private static void dfs(int[][] arr, List<Pair<Integer, Integer>> list, int startRow, int startCol, int n, int m, boolean[][] visited, int baseRow, int baseCol) {
        visited[startRow][startCol] = true;
        int rowDiff = startRow - baseRow;
        int colDiff = startCol - baseCol;
        list.add(new Pair<>(rowDiff, colDiff));
        for (int i = 0; i < delRow.length; i++) {
            int row = startRow + delRow[i];
            int col = startCol + delCol[i];
            if (row >= 0 && row < n && col >= 0 && col < m && arr[row][col] == 1 && !visited[row][col]) {
                dfs(arr, list, row, col, n, m, visited, baseRow, baseCol);
            }
        }
    }
}
