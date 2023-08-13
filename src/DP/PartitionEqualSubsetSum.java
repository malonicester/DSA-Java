package DP;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 15};
        int sum = 0;
        for (int a : arr)
            sum += a;
        int target = sum / 2;
        int[][] dp = new int[arr.length][target + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        int ans = partitionEqualSubsetSum(arr, 0, target, dp);
        System.out.println(ans);
    }

    static int partitionEqualSubsetSum(int[] arr, int index, int target, int[][] dp) {
        if (target == 0) return 1;
        if (index >= arr.length) return 0;
        if (dp[index][target] != -1) return dp[index][target];
        int take = 0;
        if (arr[index] <= target) {
            take = partitionEqualSubsetSum(arr, index + 1, target - arr[index], dp);
        }
        int notTake = partitionEqualSubsetSum(arr, index + 1, target, dp);
        return dp[index][target] = take == 1 || notTake == 1 ? 1 : 0;
    }
}
