package Revision;

import java.util.Arrays;
import java.util.Map;

public class MaximumDiffSubArray {
    public static void main(String[] args) {
        int[]arr = {8,2,4,7};
        System.out.println(maximumDifferenceSubArray(arr,2));

    }

    static int maximumDifferenceSubArray(int[] arr, int limit) {
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        int max = Integer.MIN_VALUE;
        while (i < j) {
            if (arr[j] - arr[i] > limit) {
                j--;
            } else {
                max = Math.max(max, j - i + 1);
                i++;
            }
        }
        return max;
    }

}
