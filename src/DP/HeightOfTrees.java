package DP;

import java.util.Arrays;
//longest Increasing SubSeq
public class HeightOfTrees {
    public static void main(String[] args) {
        int[] arr = {10, 20, 9, 33, 21, 50, 41, 60, 50};
        int[][] dp = new int[arr.length][arr.length + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int ans = heightOfTrees(arr, 0, -1, dp);
        System.out.println(ans);
    }

    static int heightOfTrees(int[] arr, int index, int prev, int[][] dp) {
        if (index >= arr.length) return 0;
        if (dp[index][prev + 1] != -1) return dp[index][prev + 1];
        int take = 0;
        if (prev == -1 || arr[index] > arr[prev]) {
            take = 1 + heightOfTrees(arr, index + 1, index, dp);
        }
        int notTake = heightOfTrees(arr, index + 1, prev, dp);
        dp[index][prev + 1] = Math.max(take, notTake);
        return dp[index][prev + 1];
    }
}
