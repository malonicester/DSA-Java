package DP;

import java.util.Arrays;

public class KoramangalaToBTM {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        int ans = travel(arr, 0,dp);
        System.out.println(ans);
    }

    static int minimumTrampolineJumps(int[] arr, int index, int[] dp) {
        if (index >= arr.length - 1) return 0;
        if (dp[index] != -1) return dp[index];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[index]; i++) {
            if (i + index >= arr.length - 1) break;
            min = Math.min(min, 1 + minimumTrampolineJumps(arr, index + i, dp));

        }
        dp[index] = min;
        return dp[index];
    }

    static int travel(int[] arr, int index, int[] dp) {
        if (index >= arr.length - 1) return 0;
        if (dp[index] != -1) return dp[index];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[index]; i++) {
            min = Math.min(min, 1 + travel(arr, index + i, dp));
        }
        return dp[index] = min;
    }
}
