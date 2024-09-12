package BinarySearch.practice;

public class SearchInRotatedArrayII {
    public static void main(String[] args) {
        int[] arr = {2, 5, 5, 8, 8, 8, 8, 8, 8, 8, 0, 0, 1, 2};
        int ans = findPivotInRotatedSortedArray(arr);
        System.out.println(SearchInRotatedArrayII.class.getClassLoader().getParent());
    }

    private static boolean binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    private static int findPivotInRotatedSortedArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > start && arr[mid] < arr[mid - 1]) return mid - 1;
            if (end < mid && arr[mid] > arr[mid + 1]) return mid;

            if (arr[start] == arr[mid]) {
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
            }

            if (arr[end] == arr[mid]) {
                if (arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }

            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
