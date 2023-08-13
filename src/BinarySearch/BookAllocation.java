package BinarySearch;

public class BookAllocation {
    public static void main(String[] args) {
        int[] arr = {12,34,67,90};
        int ans = maxPages(arr, 2);
        System.out.println(ans);
    }

    static int maxPages(int[] arr, int stCount) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] < min) {
                min = arr[i];
            }
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
        if(arr.length<stCount) return false;
        int count = 1;
        int page = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxPage) {
                return false;
            } else if (page + arr[i] > maxPage) {
                count++;
                page = arr[i];
            } else {
                page = page + arr[i];
            }
        }
        if (count > stCount) return false;
        return true;
    }
}
