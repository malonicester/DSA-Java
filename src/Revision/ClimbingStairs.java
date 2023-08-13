package Revision;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;
        int ans = climbingStairs(48);
        System.out.println(ans);
    }

    static int climbingStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
