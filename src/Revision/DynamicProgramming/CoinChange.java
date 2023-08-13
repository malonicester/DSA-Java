package Revision.DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {2};
        int amount = 3;
        int[][] dp = new int[arr.length + 1][amount + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int ans = coinChangeDP(arr, arr.length - 1, amount, dp);
        System.out.println(ans == Integer.MAX_VALUE / 3);
    }

    static int coinChangeDP(int[] arr, int index, int amount, int[][] dp) {
        if (index == 0) {
            if (amount % arr[index] == 0) return amount / arr[0];
            return Integer.MAX_VALUE / 3;
        }
        if (dp[index][amount] != -1) return dp[index][amount];
        int notTake = coinChangeDP(arr, index - 1, amount, dp);
        int take = Integer.MAX_VALUE / 3;
        if (arr[index] <= amount) {
            take = 1 + coinChangeDP(arr, index, amount - arr[index], dp);
        }
        return dp[index][amount] = Math.min(notTake, take);

    }
}
