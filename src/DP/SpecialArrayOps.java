package DP;

import java.util.Arrays;

public class SpecialArrayOps {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 1, 0, 0, 1};
        int sum = 0;
        for (int a : arr)
            sum += a;
        int s = 3;
        int[][][] dp = new int[arr.length + 1][arr.length + 1][sum + 1];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        int ans = arrayOfOps(arr, 0, arr.length - 1, sum, s, dp);
        System.out.println(ans);
    }

    static int arrayOfOps(int[] arr, int start, int end, int sum, int s, int[][][] dp) {
        if (start < 0 || start >= arr.length || end < 0 || end >= arr.length || sum == s) return 0;
        if (dp[start][end][sum] != -1) return dp[start][end][sum];
        int op1 = 1 + arrayOfOps(arr, start + 1, end, sum - arr[start], s, dp);
        int op2 = 1 + arrayOfOps(arr, start, end - 1, sum - arr[end], s, dp);
        return dp[start][end][sum] = Math.min(op1, op2);
    }
}
