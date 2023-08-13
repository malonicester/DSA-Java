package Revision.DynamicProgramming;

import java.util.Arrays;

public class BuySellStock2 {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int[][] dp = new int[arr.length + 1][2];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int ans = buySellStock2(arr, 0, 1, dp);
        System.out.println(ans);
    }

    static int buySellStock2(int[] arr, int index, int buy, int[][] dp) {
        if (index >= arr.length) return 0;
        if (dp[index][buy] != -1) return dp[index][buy];
        if (buy == 1) {
            return dp[index][buy] = Math.max(buySellStock2(arr, index + 1, 1, dp), -arr[index] + buySellStock2(arr, index, 0, dp));
        }
        return dp[index][buy] = Math.max(arr[index] + buySellStock2(arr, index + 1, 1, dp), buySellStock2(arr, index + 1, 0, dp));
    }
}
