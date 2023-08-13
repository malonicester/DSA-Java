package DP;

import java.util.Arrays;

public class LT1498 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
        int target = 3;
        int[][] dp = new int[arr.length + 1][target];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        int ans = numberOfSubsetEqualsTarget(arr, target);
        System.out.println(ans);
    }

    static int numberOfSubsetEqualsTarget(int[] arr, int target, int index, int[][] dp) {
        if (target == 0) return 1;
        if (index >= arr.length) return 0;
        if (dp[index][target] != -1) return dp[index][target];
        int pick = 0;
        if (arr[index] <= target) {
            pick = numberOfSubsetEqualsTarget(arr, target - arr[index], index + 1, dp);
        }
        int skip = numberOfSubsetEqualsTarget(arr, target, index + 1, dp);
        return dp[index][target] = pick + skip;
    }

    static int numberOfSubsetEqualsTarget(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        for (int i = 0; i < dp.length; i++) dp[i][0] = 1;
        if (arr[0] <= target) dp[0][arr[0]] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (arr[i] <= j) take = dp[i - 1][j - arr[i]];
                dp[i][j] = take + notTake;
            }
        }
        return dp[arr.length - 1][target];
    }
}
