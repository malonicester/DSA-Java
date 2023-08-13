package Revision.DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuy3 {
    public static void main(String[] args) {
        int[] arr = {7,6,4,3,1};
        int[][][] dp = new int[arr.length + 1][2][3];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        int ans = buySellStock3(arr, 0, 1, 0, dp);
        System.out.println(ans);
    }

    static int buySellStock3(int[] arr, int index, int buy, int count, int[][][] dp) {
        if (index >= arr.length || count == 2) return 0;
        if (dp[index][buy][count] != -1) return dp[index][buy][count];
        if (buy == 1) {
            return dp[index][buy][count] = Math.max(buySellStock3(arr, index + 1, 1, count, dp), -arr[index] + buySellStock3(arr, index + 1, 0, count, dp));
        }
        return dp[index][buy][count] = Math.max(arr[index] + buySellStock3(arr, index + 1, 1, count + 1, dp), buySellStock3(arr, index + 1, 0, count, dp));
    }
}
