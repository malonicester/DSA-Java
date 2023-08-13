package DP;

import java.util.Arrays;

public class DungeonGame {
    public static void main(String[] args) {
        int[][] arr = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        int[][] dp = new int[arr.length + 1][arr[0].length + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        int sum = dungeonGame(arr,0,0,dp);
        System.out.println(sum);
        for(int[]a:dp)
            System.out.println(Arrays.toString(a));
    }

    //   Wrong till now
    static int dungeonGame(int[][] arr, int i, int j, int[][] dp) {
        if (i >= arr.length || j >= arr[0].length) return Integer.MAX_VALUE / 4;
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            return Math.max(1 - arr[i][j], 1);
        }
        if (dp[i][j] != -1) return dp[i][j];
        int right = dungeonGame(arr, i, j + 1, dp);
        int down = dungeonGame(arr, i + 1, j, dp);
        int ans = Math.min(right, down) - arr[i][j];
        if (ans <= 0) dp[i][j] = 1;
        else dp[i][j] = ans;
        return dp[i][j];
    }

    static int dungeon(int[][] arr) {
//        Rather than starting from 0,0 it will be good to start from end because we will be knowing at each step how much energy was required at least to make this move.
//      At every we are considering 1 because it is the minimum energy required to move further.
//      Suppose in a cell there is positive value means no energy is required so (1-arr[i][j]) will give negative value so max will be  1  there.
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    dp[i][j] = Math.max(1, 1 - arr[i][j]);
                } else if (i == n - 1) {
                    dp[i][j] = Math.max(1, dp[i][j + 1] - arr[i][j]);
                } else if (j == m - 1) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - arr[i][j]);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - arr[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
