package RecursionAndDP.Graphs;

import java.util.Arrays;

public class ZeroOneMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        };
        int[][] ans = zeroOneMatrix(arr);
        for (int[] a : ans) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] zeroOneMatrix(int[][] arr) {
        int[][] copyArray = Arrays.copyOfRange(arr, 0, arr.length);
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    copyArray[i][j] = dfs(arr, copyArray, i, j, visited);
                }
            }
        }
        return copyArray;
    }

    private static int dfs(int[][] arr, int[][] copyArray, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length)
            return Integer.MAX_VALUE;
        if(visited[row][col]) return 1 + copyArray[row][col];
        if (arr[row][col] == 0) return 0;
        visited[row][col] = true;
        int left = dfs(arr, copyArray, row, col - 1, visited);
        int right = dfs(arr, copyArray, row, col + 1, visited);
        int below = dfs(arr, copyArray, row + 1, col, visited);
        int up = dfs(arr, copyArray, row - 1, col, visited);
        int min = getMin(left, right, below, up);
        visited[row][col] = false;
        return min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
    }

    private static int getMin(int... arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
        }
        return min;
    }
}
