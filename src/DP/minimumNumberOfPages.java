package DP;

import java.util.Arrays;

public class minimumNumberOfPages {
    public static void main(String[] args) {
        int n = 1000;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = minPages(n,  0);
        System.out.println(ans);
    }

    static int minPages(int n, int[] dp, int count) {
        if (n == 0) return count;
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];
        int one = minPages(n - 12, dp, count + 1);
        int two = minPages(n - 10, dp, count + 1);
        return dp[n] = one == 0 ? two : two == 0 ? one : Math.min(one, two);
    }

    static int minPages(int n, int count) {
        if (n == 0) return count;
        if (n < 0) return 0;
        int one = minPages(n - 12, count + 1);
        int two = minPages(n - 10, count + 1);
        return one == 0 ? two : two == 0 ? one : Math.min(one, two);
    }
}
