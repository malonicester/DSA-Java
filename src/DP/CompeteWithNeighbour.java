package DP;

import java.util.Arrays;

//T.C->O(N^2) SC->O(N^2)
public class CompeteWithNeighbour {
    public static void main(String[] args) {
        int[] arr = {8, 15, 3, 7};
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int ans = competeWithNeighbour(arr, 0, n - 1, dp);
        System.out.println(ans);
    }

    static int competeWithNeighbour(int[] arr, int s, int e, int[][] dp) {
        if (s >= e) return 0;
        if (dp[s][s] != -1) return dp[s][e];
        int me = arr[s] + Math.min(competeWithNeighbour(arr, s + 2, e, dp), competeWithNeighbour(arr, s + 1, e - 1, dp));
        int opponent = arr[s] + Math.min(competeWithNeighbour(arr, s + 1, e - 1, dp), competeWithNeighbour(arr, s, e - 2, dp));
        dp[s][e] = Math.max(me, opponent);
        return dp[s][e];
    }
}
