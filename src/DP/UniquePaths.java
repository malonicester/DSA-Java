package DP;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        int[][] arr = new int[m][n];
        int[][] dp = new int[m + 1][n + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        System.out.println(uniquePaths(3, 7));
    }

    static int uniquePaths(int[][] arr, int i, int j, int[][] dp) {
        if (i >= arr.length || j >= arr[0].length || arr[i][j] == -1) return 0;
        if (i == arr.length - 1 && j == arr[0].length - 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        int right = uniquePaths(arr, i, j + 1, dp);
        int down = uniquePaths(arr, i + 1, j, dp);
        return dp[i][j] = right + down;
    }

    static int uniquePaths(int m, int n) {
        int left = 0, down = 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else {
                    left = dp[i][j - 1];
                    down = dp[i - 1][j];
                    dp[i][j] = left + down;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    static int uniquePathsSpaceOptimized(int m, int n) {
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) temp[j] = 1;
                else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) up = prev[j];
                    if (j > 0) left = temp[j - 1];
                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}
