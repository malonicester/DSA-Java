package DP;

import java.util.Arrays;

public class PartitionArrayForMaxSum {
    public static void main(String[] args) {
        int[] arr = {36,-36};
        int k = 3;
        int[]dp = new int[arr.length+1];
        Arrays.fill(dp,-1);
        int ans = partitionArrayMaxSum(arr, 0, k,dp);
        System.out.println(ans);
    }

    static int partitionArrayMaxSum(int[] arr, int index, int k,int[]dp) {
        if (index == arr.length) return 0;
        if(dp[index]!=-1) return dp[index];
        int maxSum = Integer.MIN_VALUE;
        int len = 0;
        int maximum = Integer.MIN_VALUE;
        for (int j = index; j < Math.min(arr.length, index + k); j++) {
            len++;
            maximum = Math.max(maximum, arr[j]);
            int sum = (maximum * len) + partitionArrayMaxSum(arr, j + 1, k,dp);
            maxSum = Math.max(sum, maxSum);
        }
        return dp[index] = maxSum;
    }
}
