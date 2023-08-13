package DP;

import java.util.Arrays;

public class SellStockII {
    public static void main(String[] args) {
        int[] arr = {123521, 32233, 3, 4, 5};
        int i = arr.length + 1;
        long[][] dp = new long[i][2];
        for (long[] a : dp)
            Arrays.fill(a, -1);
        long ans = sellStockIIDP(arr, 0, 1, dp);
        System.out.println(ans);
    }

    static int sellStockII(int[] arr, int i, int buy) {
        if (i >= arr.length) return 0;
        int op1 = 0;
        int op2 = 0;
        if (buy == 1) {
            op1 = sellStockII(arr, i + 1, 1);
            op2 = -arr[i] + sellStockII(arr, i + 1, 0);
            return Math.max(op1, op2);
        }
        op1 = arr[i] + sellStockII(arr, i + 1, 1);
        op2 = sellStockII(arr, i + 1, 0);
        return Math.max(op1, op2);
    }

     static long sellStockIIDP(int[] arr, int i, int buy, long[][] dp) {
        if (i >= arr.length) return 0;
        if (dp[i][buy] != -1) return dp[i][buy];
        long op1 = 0;
        long op2 = 0;
        if (buy == 1) {
            op1 = sellStockIIDP(arr, i + 1, 1, dp);
//          buy and sell on next day
            op2 = -arr[i] + sellStockIIDP(arr, i, 0, dp);
            return dp[i][buy] = Math.max(op1, op2);
        }
        op1 = arr[i] + sellStockIIDP(arr, i + 1, 1, dp);
        op2 = sellStockIIDP(arr, i + 1, 0, dp);
        return dp[i][buy] = Math.max(op1, op2);
    }
}
