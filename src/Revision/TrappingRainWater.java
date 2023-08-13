package Revision;

import java.util.Arrays;
import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = trappingRainWaterSpaceOpt(arr);
        System.out.println(ans);
    }

    static int trappingRainWater(int[] arr) {
        int n = arr.length;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0] = arr[0];
        right[n - 1] = arr[n - 1];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            ans += Math.min(left[i], right[i]) - arr[i];
        }
        return ans;
    }

    static int trappingRainWaterSpaceOpt(int[] arr) {
        int left = 0, n = arr.length, right = n - 1, leftMax = 0, rightMax = 0, ans = 0;
        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] >= leftMax) leftMax = arr[left];
                else ans += leftMax - arr[left];
                left++;
            } else {
                if (arr[right] >= rightMax) rightMax = arr[right];
                else ans += rightMax - arr[right];
                right--;
            }
        }
        return ans;
    }
}
