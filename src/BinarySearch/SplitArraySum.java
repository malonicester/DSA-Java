package BinarySearch;

import java.util.Set;
import java.util.TreeSet;

public class SplitArraySum {
    public static void main(String[] args) {
     Set<Integer> set = new TreeSet<>();

    }

    static int splitArrayLargestSum(int[] arr, int m) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = Math.max(arr[i], start);
            end += arr[i];
        }
//        Binary Search
        while (start < end) {
//            Try for the midddle as potential answer
            int mid = start + (end - start) / 2;
//            Calculate how many pieces  you can divide this in with this maxSum
            int sum = 0;
            int pieces = 1;
            for (int num : arr) {
                if (sum + num > mid) {
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }
            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
