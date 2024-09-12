package SlidingWindowAndTwoPointers;

import java.util.Arrays;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4};
        int ans = largestAreaHistogram(arr);
        System.out.println(ans);
    }

    private static int largestAreaHistogram(int[] arr) {
        int val = 1, n = arr.length;
        int[] leftMax = new int[n];
        leftMax[0] = 0;
        int[] rightMax = new int[n];
        rightMax[n - 1] = n - 1;
        for (int i = 1; i < n; i++) {
            if (arr[leftMax[i - 1]] < arr[i]) {
                leftMax[i] = i;
            } else {
                leftMax[i] = leftMax[i - 1];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr[rightMax[i + 1]] < arr[i]) {
                rightMax[i] = i;
            } else {
                rightMax[i] = rightMax[i + 1];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int left = leftMax[i];
            int right = rightMax[i];
            int res = (right - left + 1) * arr[i];
            val = Math.max(val,res);
        }
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));
        return val;
    }

}
