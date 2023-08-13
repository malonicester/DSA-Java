package DP;

import java.util.Arrays;

public class StoneGameIV {
    public static void main(String[] args) {
        int n = 17;
        boolean ans = stoneGameIV(n);
        System.out.println(ans);
    }

    static int compete(int n, int[] dp) {
        if (n <= 0) return 0;
        if (dp[n] != -1) return dp[n];
        for (int i = 1; i * i <= n; i++) {
            if (compete(n - i * i, dp) == 0) return dp[n] = 1;
        }
        return dp[n] = 0;
    }

    static boolean stoneGameIV(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        return compete(n, dp) == 1;
    }
}
