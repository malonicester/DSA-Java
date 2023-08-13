package DP;

import java.util.Arrays;

public class MasaiMonetary {
    public static void main(String[] args) {
        int n = 12;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = maximumChange(n, dp);
        System.out.println(ans);
    }

    static int maximumChange(int n, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        dp[n] = Math.max(n, maximumChange(n / 2, dp) + maximumChange(n / 3, dp) + maximumChange(n / 4, dp));
        return dp[n];
    }
}
