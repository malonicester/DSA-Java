package Revision.DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyStock4 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 5, 0, 3};
        int k = 2;
        int[][][] dp = new int[arr.length + 1][2][k + 1];
        for(int[][]a:dp){
            for (int[]b:a){
                Arrays.fill(b,-1);
            }
        }
        int ans = bestTimeToBuyStock(arr, 0, 1, k,dp);
        System.out.println(ans);
    }

    static int bestTimeToBuyStock(int[] arr, int index, int buy, int k, int[][][] dp) {
        if (index >= arr.length || k <= 0) return 0;
        if (dp[index][buy][k] != -1) return dp[index][buy][k];
        if (buy == 1) {
            return dp[index][buy][k] = Math.max(bestTimeToBuyStock(arr, index + 1, 1, k, dp), -arr[index] + bestTimeToBuyStock(arr, index + 1, 0, k, dp));
        }
        return dp[index][buy][k] = Math.max(arr[index] + bestTimeToBuyStock(arr, index + 1, 1, k - 1, dp), bestTimeToBuyStock(arr, index + 1, 0, k, dp));
    }
}
