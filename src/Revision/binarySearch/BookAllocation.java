package Revision.binarySearch;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BookAllocation {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int ans = bookAllocation(arr, 2);
        System.out.println(ans);
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
//        Duration duration =
       long vla  =  ChronoUnit.MINUTES.between(LocalDateTime.now(),LocalDateTime.now());
    }

    static int bookAllocation(int[] arr, int stCount) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            min = Math.min(min, arr[i]);
        }
        int start = min;
        int end = sum;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canAllocate(arr, stCount, mid)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    static boolean canAllocate(int[] arr, int stCount, int maxPage) {
        if (arr.length < stCount) return false;
        int count = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxPage) return false;
            else if (sum + arr[i] > maxPage) {
                sum = arr[i];
                count++;
            } else {
                sum += arr[i];
            }
        }
        return count <= stCount;
    }
}
