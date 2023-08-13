package DP;

import java.util.Arrays;

public class BatteryDown {
    public static void main(String[] args) {
        int n = 100;
        int m = 1000;
        int[][] dp = new int[n + m][n + m];
        for(int []a:dp){
            Arrays.fill(a,-1);
        }
        int ans = batteryDown(n,m,dp);
        System.out.println(ans);
    }

    static int batteryDown(int n, int m, int[][] dp) {
        if (n <= 0 || m <= 0) return 0;
        if (dp[n][m] != -1) return dp[n][m];
        int one = 1 + batteryDown(n - 2, m + 1, dp);
        int two = 1 + batteryDown(n + 1, m - 2, dp);
        dp[n][m] = Math.max(one, two);
        return dp[n][m];
    }

}
