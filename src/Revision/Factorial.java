package Revision;

public class Factorial {
    public static void main(String[] args) {
        int ans = fibonacci(4);
        System.out.println(ans);
    }

    static int factorial(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * i;
        }
        return dp[n];
    }

    static int fibonacci(int n) {
        int prev1 = 0;
        int prev2 = 1;
        for (int i = 2; i <= n; i++) {
            int ans = prev1 + prev2;
            prev1 = prev2;
            prev2 = ans;
        }
        return prev2;
    }
}
