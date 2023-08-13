package DP;

import java.util.Arrays;

public class PartitionEqualsK {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int target = 11;
        boolean ans = partitionSumEqualsK(arr,target);
        System.out.println(ans);
    }

    static boolean partitionSumEqualsK(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
//      Because when target is 0 it is always achievable
        for (int i = 0; i < dp.length; i++) dp[i][0] = true;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j <= target; j++) {
                boolean skip = dp[i + 1][j];
                boolean take = false;
                if (j >= arr[i]) take = dp[i + 1][j - arr[i]];
                dp[i][j] = skip || take;
            }
        }
        for(boolean[]a:dp)
            System.out.println(Arrays.toString(a));
        return dp[0][target];
    }

}
