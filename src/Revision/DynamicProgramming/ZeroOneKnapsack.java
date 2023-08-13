package Revision.DynamicProgramming;

import java.util.Arrays;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] weight = {1, 2, 4, 5};
        int[] value = {5, 4, 8, 6};
        int maxWeight = 5;
        int[][] dp = new int[weight.length + 1][maxWeight + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int ans = zerOneKnapsack(weight, value, 0, maxWeight, dp);
        System.out.println(ans);
    }

    static int zerOneKnapsack(int[] weight, int[] value, int i, int maxWeight, int[][] dp) {
        if (i >= weight.length) {
            if (maxWeight < 0) return Integer.MIN_VALUE / 4;
            return 0;
        }
        if (dp[i][maxWeight] != -1) return dp[i][maxWeight];
        int pick = Integer.MIN_VALUE / 4;
        if (weight[i] <= maxWeight) {
            pick = value[i] + zerOneKnapsack(weight, value, i + 1, maxWeight - weight[i], dp);
        }
        int notPick = zerOneKnapsack(weight, value, i + 1, maxWeight, dp);
        return dp[i][maxWeight] = Math.max(pick, notPick);
    }
}
