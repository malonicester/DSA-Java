package Revision.binarySearch;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {0, 10, 11, 34, 534, 5, 2, 1};
        int ans = findInMountainArray(arr,11);
        System.out.println(ans);
    }

    static int findInMountainArray(int[] arr, int target) {
        int peak = peakIndex(arr);
        if (target <= arr[peak]) return binarySearch(arr,0,peak,target);
        return binarySearch(arr,peak+1,arr.length-1,target);
    }

    static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid]==target) return mid;
            if(arr[mid]>target) end = mid - 1;
            else  start = mid + 1;
        }
        return -1;
    }

    static int peakIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
//           You are decreasing part of array it may be the answer so look
            if (mid < end && arr[mid] > arr[mid + 1]) {
                end = mid;
            } else start = mid + 1;
        }
        return start;
    }
}
