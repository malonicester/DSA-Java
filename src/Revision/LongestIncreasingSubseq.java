package Revision;

import java.util.Arrays;

public class LongestIncreasingSubseq {
    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 10, 7, 7, 13};
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int[]a:dp){
            Arrays.fill(a,-1);
        }
        int ans = longestIncreasingSubsequence(arr, 0, -1,dp);
        System.out.println(ans);
        System.out.println(ans);
//        int res = fibonacci(9);
//        System.out.println(res);
    }

    static int longestIncreasingSubSeq(int[] arr, int prev, int index) {
        if (index >= arr.length) return 0;
        int take = 0;
        if (prev == -1 || arr[index] > arr[prev]) {
            take = 1 + longestIncreasingSubSeq(arr, index, index + 1);
        }
        int notTake = longestIncreasingSubSeq(arr, prev, index + 1);
        return Math.max(take, notTake);
    }

    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int longestIncreasingSubsequence(int[] arr, int index, int prev, int[][] dp) {
        if (index >= arr.length) return 0;
        if (dp[index][prev + 1] != -1) return dp[index][prev + 1];
        int take = 0;
        if (prev == -1 || arr[index] > arr[prev]) {
            take = 1 + longestIncreasingSubsequence(arr, index + 1, index, dp);
        }
        int notTake = longestIncreasingSubsequence(arr, index + 1, prev, dp);
        return dp[index][prev + 1] = Math.max(take, notTake);
    }
}
