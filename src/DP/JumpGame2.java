package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1};
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        System.out.println(jumpGameII(arr, 0, 0, dp));
    }

    //    static int jumpGameII(int[]arr){
//        int min = Integer.MIN_VALUE;
//        int index = arr.length - 1;
//        for(int i = arr.length - 1;i>=0;i--){
//            if(arr[i]+i>=index && )
//        }
//    }
    static int jumpGameII(int[] arr, int index, int count, int[] dp) {
        if (index >= arr.length) return Integer.MAX_VALUE/2;
        if (index == arr.length - 1) return 0;
        if (dp[index] != -1) return dp[index];
        int min = 1000000;
        for (int i = 1; i <= arr[index]; i++) {
            int ans = 1 + jumpGameII(arr, index + i, count + 1, dp);
            min = Math.min(min, ans);
        }
        return dp[index] = min;
    }
}
