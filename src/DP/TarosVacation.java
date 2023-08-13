package DP;

import java.util.Arrays;

//https://atcoder.jp/contests/dp/tasks/dp_c
public class TarosVacation {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };
        int[][] dp = new int[arr.length + 1][4];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        int ans = tarosVacation(arr, 0, 0, dp);
        System.out.println(ans);
    }

    static int tarosVacation(int[][] arr, int day, int flag, int[][] dp) {
        if (day == arr.length) return 0;
        if (dp[day][flag] != -1) return dp[day][flag];
        int max = 0;
        if (flag == 0) {
            max = Math.max(max, arr[day][1] + tarosVacation(arr, day + 1, 1, dp));
            max = Math.max(max, arr[day][2] + tarosVacation(arr, day + 1, 2, dp));
            max = Math.max(max, arr[day][3] + tarosVacation(arr, day + 1, 3, dp));
        }
        if (flag == 1) {
            max = Math.max(max, arr[day][2] + tarosVacation(arr, day + 1, 2, dp));
            max = Math.max(max, arr[day][3] + tarosVacation(arr, day + 1, 3, dp));
        }
        if (flag == 2) {
            max = Math.max(max, arr[day][1] + tarosVacation(arr, day + 1, 1, dp));
            max = Math.max(max, arr[day][3] + tarosVacation(arr, day + 1, 3, dp));
        }
        if (flag == 3) {
            max = Math.max(max, arr[day][1] + tarosVacation(arr, day + 1, 1, dp));
            max = Math.max(max, arr[day][2] + tarosVacation(arr, day + 1, 2, dp));
        }
        return dp[day][flag] = max;
    }
}
