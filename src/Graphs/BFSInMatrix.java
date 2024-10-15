package Graphs;

import RecursionAndDP.Graphs.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class BFSInMatrix {
    private static final int[] delRow = {1, 0, -1, 0};
    private static final int[] delCol = {0, 1, 0, -1};

    private static void bfd(int[][] arr, int startRow, int startCol, boolean[][] visited) {
        int n = arr.length, m = arr[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        visited[startRow][startCol] = true;
        queue.add(new Pair<>(startRow, startCol));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> current = queue.poll();
            int first = current.getFirst();
            int second = current.getSecond();
            for (int i = 0; i < delRow.length; i++) {
                int row = first + delRow[i];
                int col = second + delCol[i];
                if (row >= 0 && row < n && col >= 0 && col < m && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.add(new Pair<>(row, col));
                }
            }
        }
    }
}
