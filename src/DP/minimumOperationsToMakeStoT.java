package DP;

import java.util.Arrays;

public class minimumOperationsToMakeStoT {
    public static void main(String[] args) {
        String s = "horse";
        String t = "ros";
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        int ans = minOperations(s, t, s.length(), t.length(), dp);
        System.out.println(ans);
    }

    static int minOperations(String s, String t, int len1, int len2, int[][] dp) {
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;
        if (dp[len1][len2] != -1) return dp[len1][len2];
//        if (len1 < 0 || len2 < 0) return 0;
        if (s.charAt(len1 - 1) == t.charAt(len2 - 1)) {
            return minOperations(s, t, len1 - 1, len2 - 1, dp);
        }
//       Replace 1 Character
        int replace = minOperations(s, t, len1 - 1, len2 - 1, dp);
        //       Delete One character
        int delete = minOperations(s, t, len1 - 1, len2, dp);
//      Add One Character(length of 1st will not change because we are adding at last
        int add = minOperations(s, t, len1, len2 - 1, dp);
        return dp[len1][len2] = 1 + min(replace, delete, add);
    }

    static int min(int a, int b, int c) {
        int min = Integer.MAX_VALUE;
        min = Math.min(a, min);
        min = Math.min(b, min);
        return Math.min(min, c);
    }
}
