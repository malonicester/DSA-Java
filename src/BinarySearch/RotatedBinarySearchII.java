package BinarySearch;

import java.util.Scanner;

public class RotatedBinarySearchII {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 6, 6, 6, 6, 0, 0, 1, 2};
        int ans = searchInRoatedArray(arr, 0);
        System.out.println(ans);


    }

    static int searchInRoatedArray(int[] arr, int target) {
        int pivot = findPivotWithDuplicates(arr);
        if (pivot == -1) {
            return binarySearch(arr, 0, arr.length - 1, target);
        }
        if (arr[pivot] == target) {
            return pivot;
        }
        if (target >= arr[0]) {
            return binarySearch(arr, 0, pivot - 1, target);
        }
        return binarySearch(arr, pivot + 1, arr.length - 1, target);
    }

    static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
//            if elements at middle,start and end are equal skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
//                what if these any of these element are pivot
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                if (arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
//            left side is sorted,so pivot should be in right
            else if (arr[start] <= arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
