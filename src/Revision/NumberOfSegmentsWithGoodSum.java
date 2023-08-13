package Revision;

import java.util.Arrays;

public class NumberOfSegmentsWithGoodSum {
    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 3, 6, 8, 9};
        int ans = numberOfSegmentsWithGoodSum(arr, 20);
        System.out.println(ans);
    }

    static int numberOfSegmentsWithGoodSum(int[] arr, int k) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        System.out.println(Arrays.toString(prefix));
        int count = 0;
        for (int i = 0; i < prefix.length; i++) {
            for (int j = i + 1; j < prefix.length; j++) {
                System.out.print((arr[j]-arr[i]) + " ");
                if (prefix[j] - prefix[i] <= k) count++;
            }
        }
        return count;
    }
}
