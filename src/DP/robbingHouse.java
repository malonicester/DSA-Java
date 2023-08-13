package DP;

import java.util.Arrays;

public class robbingHouse {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        int ans = robbingHouse(arr, 0, dp);
        System.out.println(ans);
    }

    static int robbingHouse(int[] arr, int i, int[] dp) {
        if (i >= arr.length) return 0;
        if (dp[i] != -1) return dp[i];
        int one = arr[i] + robbingHouse(arr, i + 2, dp);
        int two =  robbingHouse(arr, i + 1, dp);
        return dp[i] = Math.max(one, two);
    }
}
