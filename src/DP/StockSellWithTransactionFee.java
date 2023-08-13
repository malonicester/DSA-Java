package DP;

import java.util.Arrays;

public class StockSellWithTransactionFee {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 8, 4, 9};
        int[][] dp = new int[arr.length + 1][2];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        int ans = stockSellWithTransactionFee(arr, 0, 1, dp, 2);
        System.out.println(ans);
    }

    static int stockSellWithTransactionFee(int[] arr, int index, int buy, int[][] dp, int transactionFee) {
        if (index == arr.length) return 0;
        if (dp[index][buy] != -1) return dp[index][buy];
        int ans = 0;
        if (buy == 1) {
            ans = Math.max(stockSellWithTransactionFee(arr, index + 1, 1, dp, transactionFee),
                    -arr[index] + stockSellWithTransactionFee(arr, index + 1, 0, dp, transactionFee)
            );
        } else {
            ans = Math.max(arr[index] - transactionFee + stockSellWithTransactionFee(arr, index + 1, 1, dp, transactionFee),
                    stockSellWithTransactionFee(arr, index + 1, 0, dp, transactionFee));
        }
        return dp[index][buy] = ans;
    }
}
