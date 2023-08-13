package DP;

public class BuyAndSellStockCoolDown {
    public static void main(String[] args) {

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
        op1 = arr[i] + sellStockIIDP(arr, i + 2, 1, dp);
        op2 = sellStockIIDP(arr, i + 1, 0, dp);
        return dp[i][buy] = Math.max(op1, op2);
    }
}
