package Revision.DynamicProgramming;

import java.util.Arrays;

public class BuyStockSell1 {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int[][] dp = new int[arr.length+1][2];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        int ans = buySellStock(arr, 0, 1, dp);
        System.out.println(ans);
    }

    //    1 -> Have to buy -> You are paying the money or we can say you we are getting negative money
    //    0 -> Can sell
    static int buySellStock(int[] arr, int index, int buy, int[][] dp) {
        if (index >= arr.length) return 0;
        if (dp[index][buy] != -1) return dp[index][buy];
        if (buy == 1) {
            return dp[index][buy] = Math.max(buySellStock(arr, index + 1, 1, dp), -arr[index] + buySellStock(arr, index + 1, 0, dp));
        }
        return dp[index][buy] = Math.max(arr[index], buySellStock(arr, index + 1, 0, dp));
    }
}
