package DP;

import java.util.Arrays;

public class StockSellWith2Transactions {
    public static void main(String[] args) {
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        int k = 2;
        int[][][] dp = new int[arr.length + 1][2][k + 1];
        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, -1);
        int ans = stockSellWithKTransactions(arr, 0, 1, k, dp);
        System.out.println(ans);
    }

    static int stockSellWithKTransactions(int[] arr, int index, int buy, int k, int[][][] dp) {
        if (index >= arr.length || k <= 0) return 0;
        if (dp[index][buy][k] != -1) return dp[index][buy][k];
        int ans = 0;
        if (buy == 1) {
            ans = Math.max(
                    -arr[index] + stockSellWithKTransactions(arr, index + 1, 0, k, dp),
                    stockSellWithKTransactions(arr, index + 1, 1, k, dp)
            );
        } else {
            ans = Math.max(
                    arr[index] + stockSellWithKTransactions(arr, index + 1, 1, k - 1, dp),
                    stockSellWithKTransactions(arr, index + 1, 0, k, dp)
            );
        }
        return dp[index][buy][k] = ans;
    }
}
