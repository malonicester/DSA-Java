package SlidingWindowAndTwoPointers;

public class TappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = trap(arr);
        System.out.println(ans);
    }

    private static int rainWaterTapping(int[] arr) {
        int total = 0;
        int n = arr.length;
        /*
          Left Max means the left tallest building to the element arr[i]
          and right max means the tallest building to the right for the element arr[i]

          because water will there if and only if left and right are taller than current building
          so the first and last building will have no significance because
          the first element has no left taller building
          and end element has not right most taller building
         */
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = arr[0];
        rightMax[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        for (int i = n - 2; i > 0; i--) rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        for (int i = 1; i < n - 1; i++) {
            if (leftMax[i] > arr[i] && rightMax[i] > arr[i]) {
                total += Math.min(leftMax[i], rightMax[i]) - arr[i];
            }
        }
        return total;
    }

    private static int trap(int[] arr) {
        int left = 0, right = arr.length - 1, leftMax = 0, rightMax = 0, total = 0;
        while (left < right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax) leftMax = arr[left];
                else total += leftMax - arr[left];
                left++;
            } else {
                if (arr[right] >= rightMax) rightMax = arr[right];
                else total += rightMax - arr[right];
                right--;
            }
        }
        return total;
    }
}
