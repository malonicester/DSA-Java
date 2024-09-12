package BinarySearch.practice;

public class PivotElementInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int ans = pivotElementInRotatedSortedArray(arr, arr.length);
        System.out.println(ans);
    }

    private static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int pivotElementInRotatedSortedArray(int[] arr, int n) {
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

/*
          - If Mid is the Pivot so it will be arr[mid] > arr[mid + 1]
          - Checked for mid < end and not mid + end because end starts with 'length - 1' index
            mid < end means in worst case it will be end - 1 when + 1 it will be end

 */

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
/*'
          - If Mid - 1 is the Pivot so obviously arr[mid - 1] > arr[mid]
          - Mid > start is checked not mid - 1 > 0 because
          it will ensure tha checking is happening only between start and end
          and in worst case mid - 1 = 1 = 1 - 1 = 0th index will prevent index out of bound
 */
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;

    }
}
