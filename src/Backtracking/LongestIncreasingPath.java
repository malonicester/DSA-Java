package Backtracking;

import java.util.Arrays;

public class LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] arr = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1},
        };
        int ans = longestPath(arr);
        System.out.println(ans);
    }

    static int longestIncreasingPath(int[][] arr, int i, int j, int[][] dp) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int currentMax = 1;
        if (i - 1 >= 0 && arr[i - 1][j] > arr[i][j]) {
            currentMax = Math.max(currentMax, 1 + longestIncreasingPath(arr, i - 1, j, dp));
        }
        if (i + 1 < arr.length && arr[i + 1][j] > arr[i][j]) {
            currentMax = Math.max(currentMax, 1 + longestIncreasingPath(arr, i + 1, j, dp));
        }
        if (j + 1 < arr[0].length && arr[i][j + 1] > arr[i][j]) {
            currentMax = Math.max(currentMax, 1 + longestIncreasingPath(arr, i, j + 1, dp));
        }
        if (j - 1 >= 0 && arr[i][j - 1] > arr[i][j]) {
            currentMax = Math.max(currentMax, 1 + longestIncreasingPath(arr, i, j - 1, dp));
        }
        return dp[i][j] = currentMax;
    }

    static int longestPath(int[][] arr) {
        int max = 0;
        int[][] dp = new int[arr.length][arr.length];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                max = Math.max(max,longestIncreasingPath(arr, i, j, dp));
            }
        }
        return max;
    }
}
