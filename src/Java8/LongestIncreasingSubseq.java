package Java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubseq {
    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 10, 7, 7, 13};
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int ans = longestIncreasingSubSeq(arr, -1, 0, dp);
        System.out.println(ans);
    }

    static int longestIncreasingSubSeq(int[] arr, int prev, int index, int[][] dp) {
        if (index >= arr.length) return 0;
        if (dp[prev + 1][index] != -1) return dp[prev][index];
        int take = 0;
        if (prev == -1 || arr[index] > arr[prev]) {
            take = 1 + longestIncreasingSubSeq(arr, index, index + 1, dp);
        }
        int notTake = longestIncreasingSubSeq(arr, prev, index + 1, dp);
        return dp[prev + 1][index] = Math.max(take, notTake);
    }

    static int longestSubString(String str) {
        int start = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch));
            }
            map.put(ch, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
