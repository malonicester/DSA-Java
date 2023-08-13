package DP;


public class SumExist {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int sum = 20;
        int i = arr.length + 1;
        boolean[][] dp = new boolean[i][sum+1];
        boolean ans = isSumExist(arr, 0, sum, dp);
        System.out.println(ans);
    }

    static boolean isSumExist(int[] arr, int idx, int sum, boolean[][] dp) {
        if (sum == 0) return true;
        if (idx == arr.length || sum < 0) return false;
        if (dp[idx][sum]) return true;
        dp[idx][sum] = isSumExist(arr, idx + 1, sum - arr[idx], dp) || isSumExist(arr, idx + 1, sum, dp);
        return dp[idx][sum];
    }

}
