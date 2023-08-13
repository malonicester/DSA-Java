package DP;

import java.util.Arrays;

public class MinSubsetDiff {
    public static void main(String[] args) {
        int[] arr = {3, 9, 7, 3};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int[][] dp = new int[arr.length + 1][sum + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        System.out.println(minSubSetDiff(arr, arr.length, 0, sum, dp));
    }

    static int minSubSetDiff(int[] arr, int i, int sumCal, int sumTotal, int[][] dp) {
        if (i == 0) {
            return Math.abs((sumTotal - sumCal) - sumTotal);
        }
        if (dp[i][sumCal] != -1) return dp[i][sumCal];
        return dp[i][sumCal] = Math.min(minSubSetDiff(arr, i - 1, sumCal + arr[i - 1], sumTotal, dp), minSubSetDiff(arr, i - 1, sumCal, sumTotal, dp));
    }
}
