package Revision;

public class FrogJumps {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10};
        int ans = frogJumps(arr);
        System.out.println(ans);
    }

    static int frogJumps(int[] arr, int index) {
        if (index == 0) return 0;
        int left = Math.abs(arr[index] - arr[index - 1]) + frogJumps(arr, index - 1);
        int right = Integer.MAX_VALUE;
        if (index > 1)
            right = Math.abs(arr[index] - arr[index - 2]) + frogJumps(arr, index - 2);
        return Math.min(left, right);
    }

    static int frogJumps(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            int one = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int two = Integer.MAX_VALUE;
            if (i > 1) {
                two = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }
            dp[i] = Math.min(one, two);
        }
        return dp[arr.length - 1];
    }
}
