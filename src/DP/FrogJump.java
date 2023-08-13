package DP;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10};
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        int ans = frogJumpWspace(arr);
        System.out.println(ans);
    }

    //    Memoized Approach
    static int frogJumps(int[] arr, int n, int i, int[] dp) {
        if (dp[i] != -1) return dp[i];
        if (i == n - 1) return 0;
        if (i == n - 2) return frogJumps(arr, n, i + 1, dp) + Math.abs(arr[i] - arr[i + 1]);
        dp[i] = Math.min(frogJumps(arr, n, i + 1, dp) + Math.abs(arr[i] - arr[i + 1]), frogJumps(arr, n, i + 2, dp) + Math.abs(arr[i] - arr[i + 2]));
        return dp[i];
    }

    //     Tabulation
    static int frogJumpsTabulation(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            int val1 = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int val2 = Integer.MAX_VALUE;
            if (i > 1) {
                val2 = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }
            dp[i] = Math.min(val1, val2);
        }
        return dp[arr.length - 1];
    }

    //    Space Optimization
    static int frogJumpWspace(int[] arr) {
        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i < arr.length; i++) {
            int val1 = prev + Math.abs(arr[i] - arr[i - 1]);
            int val2 = Integer.MAX_VALUE;
            if (i > 1) {
                val2 = prev2 + Math.abs(arr[i] - arr[i - 2]);
            }
            int curr = Math.min(val1, val2);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}

