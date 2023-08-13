package DP;

import java.util.Arrays;

//T.C->O(N^2) SC->O(N^2)
public class OptimalGameDP {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7};
        String ans = stoneGameIIISpaceOptimized(arr);
        System.out.println(ans);
    }

    static int competeWithNeighbour(int[] arr, int s, int e, int[][] dp) {
        if (s >= e) return 0;
        if (dp[s][e] != -1) return dp[s][e];
        int start = arr[s] + Math.min(competeWithNeighbour(arr, s + 2, e, dp), competeWithNeighbour(arr, s + 1, e - 1, dp));
        int end = arr[e] + Math.min(competeWithNeighbour(arr, s + 1, e - 1, dp), competeWithNeighbour(arr, s, e - 2, dp));
        return dp[s][e] = Math.max(start, end);
    }

    static String stoneGameIII(int[] arr) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        int alice = compete(arr, 0, dp);
        if (alice > 0) return "Alice";
        if (alice == 0) return "Tie";
        return "Bob";
    }

    static int compete(int[] arr, int i, int[] dp) {
        if (i >= arr.length) return 0;
        if (dp[i] != -1) return dp[i];
        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans, arr[i] - compete(arr, i + 1, dp));
        if (i + 1 < arr.length) ans = Math.max(ans, arr[i] + arr[i + 1] - compete(arr, i + 2, dp));
        if (i + 2 < arr.length) ans = Math.max(ans, arr[i] + arr[i + 1] + arr[i + 2] - compete(arr, i + 3, dp));
        return dp[i] = ans;
    }

    static String stoneGameIIIDP(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int ans = Integer.MIN_VALUE;
            ans = Math.max(ans, arr[i] - dp[i + 1]);
            if (i + 1 < arr.length) ans = Math.max(ans, arr[i] + arr[i + 1] - dp[i + 2]);
            if (i + 2 < arr.length) ans = Math.max(ans, arr[i] + arr[i + 1] + arr[i + 2] - dp[i + 3]);
            dp[i] = ans;
        }
        int alice = dp[0];
        if (alice > 0) return "Alice";
        if (alice == 0) return "Tie";
        return "Bob";
    }

    static String stoneGameIIISpaceOptimized(int[] arr) {
        int n = arr.length;
        int i_1 = 0, i_2 = 0, i_3 = 0;
        for (int i = n - 1; i >= 0; i--) {
            int ans = Integer.MIN_VALUE;
            ans = Math.max(ans, arr[i] - i_1);
            if (i + 1 < arr.length) ans = Math.max(ans, arr[i] + arr[i + 1] - i_2);
            if (i + 2 < arr.length) ans = Math.max(ans, arr[i] + arr[i + 1] + arr[i + 2] - i_3);
            i_3 = i_2;
            i_2 = i_1;
            i_1 = ans;
        }
        int alice = i_1;
        if (alice > 0) return "Alice";
        if (alice == 0) return "Tie";
        return "Bob";
    }

}
