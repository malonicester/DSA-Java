package BinarySearch.practice;

public class PeakIndexOfMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,3};
        int ans = peakIndexOfMountainArray(arr);
        System.out.println(ans);
    }

    public static int peakIndexOfMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
//                You are in Decreasing part of array so it may be the answer else we will miss out
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    public static int peakIndexOfMountainArray(MountainArray arr) {
        int start = 0, end = arr.length() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr.get(mid) > arr.get(mid + 1)) {
//                You are in Decreasing part of array so it may be the answer else we will miss out
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
