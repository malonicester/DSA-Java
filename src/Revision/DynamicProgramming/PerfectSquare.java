package Revision.DynamicProgramming;

import java.util.Arrays;

public class PerfectSquare {
    public static void main(String[] args) {
        int n = 13;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = perfectSquare(n, dp);
        System.out.println(ans);
    }

    static int perfectSquare(int n, int[] dp) {
        if (n < 0) return Integer.MAX_VALUE / 3;
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int ans = Integer.MAX_VALUE / 3;
        for (int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + perfectSquare(n - i * i, dp));
        }
        return dp[n] = ans;
    }
}
