package DP;

import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6}


        };
        /*
          1 3 3
          5 5 6

         */
        int[][] dp = new int[arr.length + 1][arr[0].length + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        int sum = minPathSum(arr);
        System.out.println(sum);
    }

    static int minPathSum(int[][] arr, int i, int j, int[][] dp) {
        if (i >= arr.length || j >= arr[0].length) return Integer.MAX_VALUE / 2;
        if (i == arr.length - 1 && j == arr[0].length - 1) return arr[i][j];
        if (dp[i][j] != -1) return dp[i][j];
        int right = arr[i][j] + minPathSum(arr, i, j + 1, dp);
        int down = arr[i][j] + minPathSum(arr, i + 1, j, dp);
        return dp[i][j] = Math.min(right, down);
    }

    static int minPathSum(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) arr[i][j] += arr[i][j - 1];
                else if (j == 0) arr[i][j] += arr[i - 1][j];
                else arr[i][j] += Math.min(arr[i][j - 1], arr[i - 1][j]);
            }
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }
}
