package RecursionAndDP;

import java.util.Arrays;

public class Dice {
    public static void main(String[] args) {
        int n = 30;
        int k = 30;
        int target = 500;
        int[][] dp = new int[n + 1][target + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int ans = dice(n, k, target);
        System.out.println(ans);
    }

    public static int dice(int n, int k, int target, int[][] dp) {
        if (target == 0 && n == 0) return 1;
        if (n == 0 || target < 0) return 0;
        if (dp[n][target] != -1) return dp[n][target];
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            if (target < i) continue;
            ans = (ans + dice(n - 1, k, target - i, dp)) % 1000000007;
        }
        return dp[n][target] = ans;
    }

    public static int dice(int n, int k, int total) {
        int[][] dp = new int[n + 1][total + 1];
        dp[0][0] = 1;
        for (int dice = 1; dice <= n; dice++) {
            for (int target = 1; target <= total; target++) {
                int ans = 0;
                for (int i = 1; i <= k; i++) {
                    if (target < i) continue;
                    ans = (ans + dp[dice - 1][target - i]) % 1000000007;
                }
                dp[dice][target] = ans;
            }

        }
        return dp[n][total];
    }

}
