package RecursionAndDP;

public class JumpGameII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1};
        int ans = jumpGameII(arr);
        System.out.println(ans);

    }

    public static int jumpGameII(int[] arr) {
        return jumpGameII(arr, 0, 0, new int[arr.length + 1]);
    }

    private static int jumpGameII(int[] arr, int index, int count, int[] dp) {
        if (index >= arr.length - 1) return 0;
        if (dp[index] != 0) return dp[index];
        int min = Integer.MAX_VALUE / 2; // Using Integer.MAX_VALUE / 2 because 1 + Integer.MAX_VALUE can cause integer Overflow
        for (int i = 1; i <= arr[index]; i++) {
            min = 1 + Math.min(min, jumpGameII(arr, index + i, count + 1, dp));
        }
        dp[index] = min;
        return min;
    }
}
