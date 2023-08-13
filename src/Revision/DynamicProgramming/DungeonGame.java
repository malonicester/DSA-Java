package Revision.DynamicProgramming;

public class DungeonGame {
    public static void main(String[] args) {
        int[][] arr = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int ans = dungeonGame(arr);
    }

    static int dungeonGame(int[][] arr) {
        int n = arr.length, m = arr[0].length;
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

