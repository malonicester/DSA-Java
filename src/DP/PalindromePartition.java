package DP;


import java.util.Arrays;

public class PalindromePartition {
    public static void main(String[] args) {
        String str = "BABABCBADCEDE";
        int[] dp = new int[str.length() + 1];
        Arrays.fill(dp, -1);
        int ans = minimumCutsDp(str);
        System.out.println(ans);
    }

    static int minimumCutsForPalindrome(String str, int index, int n, int[] dp) {
        if (index == n) return 0;
        if (dp[index] != -1) return dp[index];
        int minCost = Integer.MAX_VALUE;
        for (int j = index; j < n; j++) {
            if (isPalindrome(str, index, j)) {
                int cost = 1 + minimumCutsForPalindrome(str, j + 1, n, dp);
                minCost = Math.min(cost, minCost);
            }
        }
        return dp[index] = minCost;
    }

    static boolean isPalindrome(String str, int i, int j) {

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    static int minimumCutsDp(String s) {
        int[] dp = new int[s.length() + 1];
        int n = s.length();
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(cost, minCost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0] - 1;
    }
}
