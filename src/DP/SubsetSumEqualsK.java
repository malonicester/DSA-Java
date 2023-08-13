package DP;

import java.util.Arrays;

public class SubsetSumEqualsK {
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 1};
        int k = 4;
        int[][] dp = new int[arr.length + 1][k + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        int ans = subsetSumEqualsK(arr, k, arr.length - 1, dp);
        System.out.println(ans == 1);
    }

    static int subsetSumEqualsK(int[] arr, int k, int i, int[][] dp) {
        if (k == 0) return 1;
        if (i == 0) {
            if (arr[0] == k) return 1;
            return 0;
        }
        if (dp[i][k] != -1) return dp[i][k];
        int take = 0;
        if (arr[i] <= k)
            take = subsetSumEqualsK(arr, k - arr[i], i - 1, dp);
        int notTake = subsetSumEqualsK(arr, k, i - 1, dp);
        return dp[i][k] = take == 1 || notTake == 1 ? 1 : 0;
    }

}
