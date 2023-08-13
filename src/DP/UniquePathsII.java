package DP;

import java.util.Arrays;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        };
        int[][] dp = new int[arr.length + 1][arr[0].length + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        int ans = uniquePathsII(arr);
        System.out.println(ans);
    }

    static int uniquePathsII(int[][] arr, int i, int j, int[][] dp) {
        if (i >= arr.length || j >= arr[0].length || arr[i][j] == 1) return 0;
        if (i == arr.length - 1 && j == arr[0].length - 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        int down = uniquePathsII(arr, i + 1, j, dp);
        int right = uniquePathsII(arr, i, j + 1, dp);
        return dp[i][j] = down + right;
    }

    static int uniquePathsII(int[][] arr) {
//      if the first element is obstacle we can not move further
        if(arr[0][0]==1) return 0;
        int[][] dp = new int[arr.length][arr[0].length];
        dp[0][0] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1 || (i == 0 && j == 0)) continue;
                int left = 0;
                int right = 0;
                if (i > 0) left = dp[i - 1][j];
                if (j > 0) right = dp[i][j - 1];
                dp[i][j] = left + right;
            }
        }
        return dp[arr.length - 1][arr[0].length - 1];
    }
}
