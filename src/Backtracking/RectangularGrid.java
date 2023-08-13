package Backtracking;

import Streams.AB;

import java.util.Arrays;

public class RectangularGrid {
    public static void main(String[] args) {
        int[][] arr = {{3, 2, 2},
                {2, 1, 3},
                {1, 5, 4}
        };
        int[][] dp = new int[arr.length + 1][arr[0].length + 1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        int ans = uniquePaths(0, 0, dp, 3, 3);
        System.out.println(ans);
    }

    static int uniquePaths(int i, int j, int[][] dp, int m, int n) {
        if (i >= m || j >= n) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        int right = uniquePaths(i, j + 1, dp, m, n);
        int down = uniquePaths(i + 1, j, dp, m, n);
        return dp[i][j] = right + down;
    }
}
