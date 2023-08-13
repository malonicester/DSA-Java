package DP;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        int amount = 15;
        int[][] dp = new int[arr.length + 1][amount + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int ans = coinChangeDP(arr, arr.length-1, amount, dp);
        System.out.println(ans);
    }

    static int coinChange(int[] arr, int index, int amount, int coins) {
        if (index >= arr.length || amount < 0) return 0;
        if (amount == 0) return coins;
        int one = 0;
        if (arr[index] <= amount) {
            one = coinChange(arr, index, amount - arr[index], coins + 1);
        }
        int two = coinChange(arr, index + 1, amount, coins);
        return one == 0 ? two : two == 0 ? one : Math.min(one, two);
    }

    static int coinChangeDP(int[] arr, int index, int amount, int[][] dp) {
        if (index == 0) {
            if (amount % arr[index] == 0) return amount / arr[0];
            return Integer.MAX_VALUE;
        }
        if (dp[index][amount] != -1) return dp[index][amount];
        int notTake = coinChangeDP(arr, index - 1, amount, dp);
        int take = Integer.MAX_VALUE;
        if (arr[index] <= amount) {
            take = 1 + coinChangeDP(arr, index, amount - arr[index], dp);
        }
        return dp[index][amount] = Math.min(take,notTake);
    }
}
