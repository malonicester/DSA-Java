package Revision;

import java.util.Arrays;

public class ConsecutiveOnes {
    public static void main(String[] args) {
        String s = "110100001";
        int ans = longestOnes(s, 4);
        System.out.println(ans);
    }

    public static int longestOnes(int[] A, int K) {
        int zeroCount = 0;
        int start = 0, res = 0;
        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0) zeroCount++;
            if (zeroCount > K) {
                if (A[start] == 0) zeroCount--;
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static int longestOnes(String s, int k) {
        int i = 0, j = 0, count = 0, ans = Integer.MIN_VALUE;
        while (j < s.length()) {
            int num = s.charAt(j) - '0';
            if (num == 0) count++;
            if (count <= k) {
                ans = Math.max(ans, j - i + 1);
            } else {
                while (count > k) {
                    if (s.charAt(i) - '0' == 0) count--;
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}
