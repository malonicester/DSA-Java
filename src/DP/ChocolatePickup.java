package DP;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/ninja-and-his-friends_3125885?source=youtube&campaign=striver_dp_videos&leftPanelTab=0
public class ChocolatePickup {
    public static void main(String[] args) {
        int[][] arr = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };
        int[][][] dp = new int[arr.length + 1][arr[0].length + 1][arr[0].length + 1];
        for (int[][] a : dp) {
            for (int[] b : a)
                Arrays.fill(b, -1);
        }
        int ans = maxChocolates(arr, 0, 0, arr[0].length - 1, dp);
        System.out.println(ans);
    }

    static int maxChocolates(int[][] arr, int i, int j1, int j2, int[][][] dp) {
        if (i < 0 || i >= arr.length || j1 < 0 || j2 < 0 || j1 >= arr[0].length || j2 >= arr[0].length)
            return Integer.MIN_VALUE / 2;
        if (i == arr.length - 1) {
            if (j1 == j2) return arr[i][j1];
            return arr[i][j1] + arr[i][j2];
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int maximum = Integer.MIN_VALUE / 2;
        //Explore all paths now
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int value = 0;
                if (j1 == j2) {
                    value = arr[i][j1];
                } else value = arr[i][j1] + arr[i][j2];
//                For every move of Alice there are 3 moves of Bob so total 9 Combination Possible
                value += maxChocolates(arr, i + 1, j1 + d1, j2 + d2, dp);
                maximum = Math.max(maximum, value);
            }
        }
        return dp[i][j1][j2] = maximum;
    }

}
