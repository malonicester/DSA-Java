package Revision.DynamicProgramming;

import java.util.Arrays;

public class BuySellStockCoolDown {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 2};
        int[][] dp = new int[arr.length + 1][2];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int ans = buySellStockCoolDown(arr, 0, 1,dp);
        System.out.println(ans);
    }

    static int buySellStockCoolDown(int[] arr, int index, int buy, int[][] dp) {
        if (index >= arr.length) return 0;
        if (dp[index][buy] != -1) return dp[index][buy];
        if (buy == 1) {
            return dp[index][buy] = Math.max(buySellStockCoolDown(arr, index + 1, 1, dp), -arr[index] + buySellStockCoolDown(arr, index, 0, dp));
        }
        return dp[index][buy] = Math.max(arr[index] + buySellStockCoolDown(arr, index + 2, 1, dp), buySellStockCoolDown(arr, index + 1, 0, dp));
    }
}
