package DP;

import java.util.Arrays;

public class JumpGameIV {
    public static void main(String[] args) {
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        boolean[] visited = new boolean[arr.length + 1];
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        int ans = jumpGameIV(arr, 0, visited, dp);
        System.out.println(ans);

    }

    static int jumpGameIV(int[] arr, int index, boolean[] visited, int[] dp) {
        if (index < 0 || index >= arr.length) return Integer.MAX_VALUE / 2;
        if (index == arr.length - 1) return 0;
        if (visited[index]) return Integer.MAX_VALUE / 2;
        if (dp[index] != -1) return dp[index];
        visited[index] = true;
        int multiJump = Integer.MAX_VALUE;
        for (int i = index; i < arr.length; i++) {
            if (arr[i] == arr[index] && i != index) {
                multiJump = 1 + jumpGameIV(arr, index + i, visited, dp);
            }
        }
        int oneRight = 1 + jumpGameIV(arr, index + 1, visited, dp);
        int oneLeft = 1 + jumpGameIV(arr, index - 1, visited, dp);
        return dp[index] = min(multiJump, oneRight, oneLeft);
    }

    static int min(int... arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++)
            min = Math.min(min, arr[i]);
        return min;
    }
}
