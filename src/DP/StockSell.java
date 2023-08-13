package DP;

import java.util.Arrays;

public class StockSell {
    public static void main(String[] args) {
        int[] arr = {7, 70, 10, 5, 1, 3};
        int[][] dp = new int[arr.length + 1][2];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int ans = stockSellDP(arr, 0, 1, dp);
        System.out.println(ans);
    }

    //    buy->0 (can sell) or 1(have to buy) --> T.C->O(2^N)
    static int stockSellRecur(int[] arr, int i, int buy) {
        if (i >= arr.length) return 0;
        int op1 = 0;
        int op2 = 0;
        if (buy == 1) {
//            I don't buy on current date and go to next day
            op1 = stockSellRecur(arr, i + 1, 1);
            op2 = -arr[i] + stockSellRecur(arr, i + 1, 0);
            return Math.max(op1, op2);
        }
//       if buy == 0 we can sell
//        op1 -> i sell
        op1 = arr[i];
//        I will wait for next day to sell
        op2 = stockSellRecur(arr, i + 1, 0);
        return Math.max(op1, op2);
    }

    static int stockSellDP(int[] arr, int i, int buy, int[][] dp) {
        if (i >= arr.length) return 0;
        if (dp[i][buy] != -1) return dp[i][buy];
        int op1 = 0;
        int op2 = 0;
        if (buy == 1) {
//            I don't buy on current date and go to next day
            op1 = stockSellDP(arr, i + 1, 1, dp);
//            I buy so i can say that i will get negative money
            op2 = -arr[i] + stockSellDP(arr, i + 1, 0, dp);
            return dp[i][buy] = Math.max(op1, op2);
        }
//       if buy == 0 we can sell
//       op1 -> i sell
        op1 = arr[i];
//      I will wait for next day to sell
        op2 = stockSellDP(arr, i + 1, 0, dp);
        return dp[i][buy] = Math.max(op1, op2);
    }


    static int stock(int[] arr) {
        int min = arr[0];
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - min);
        }
        return maxProfit;
    }
}
