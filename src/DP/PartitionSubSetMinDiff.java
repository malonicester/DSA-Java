package DP;

public class PartitionSubSetMinDiff {
    public static void main(String[] args) {
        int[] arr = {3, 9, 7, 2};
        int ans = minimumSubSetDifferenceOptimized(arr);
        System.out.println(ans);
    }

    static int minimumSubSetDifference(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) total += arr[i];
        int k = total;
//      The rows define elements and the column defines the sum is possible or not
        boolean[][] dp = new boolean[arr.length][k + 1];
        for (int i = 0; i < dp.length; i++) dp[i][0] = true;
//      If the first element is lesser than the target element it is absolutely possible to compute it, so we can make it true.
        if (arr[0] <= k) dp[0][arr[0]] = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= k; j++) {
                boolean skip = dp[i - 1][j];
                boolean take = false;
                if (arr[i] <= j) take = dp[i - 1][j - arr[i]];
                dp[i][j] = skip || take;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= total / 2; i++) {
            if (dp[arr.length - 1][i]) {
                min = Math.min(min, Math.abs(total - i) - i);
            }
        }
        return min;
    }

    static int minimumSubSetDifferenceOptimized(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) total += arr[i];
        int k = total / 2;
//      The rows define elements and the column defines the sum is possible or not
        boolean[][] dp = new boolean[arr.length][k + 1];
        for (int i = 0; i < dp.length; i++) dp[i][0] = true;
//      If the first element is lesser than the target element it is absolutely possible to compute it, so we can make it true.
        if (arr[0] <= k) dp[0][arr[0]] = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= k; j++) {
                boolean skip = dp[i - 1][j];
                boolean take = false;
                if (arr[i] <= j) take = dp[i - 1][j - arr[i]];
                dp[i][j] = skip || take;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= total / 2; i++) {
            if (dp[arr.length - 1][i]) {
                min = Math.min(min, Math.abs(total - i) - i);
            }
        }
        return min;
    }
}
