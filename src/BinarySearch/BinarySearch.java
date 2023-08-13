package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 1, 4, 5, 6, 7, 8};
        int ans = lowerBound(arr, 1);
        System.out.println(ans);
    }

    static int binaryRec(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return 1;
        }

        if (arr[mid] > target) {
            return binaryRec(arr, start, mid - 1, target);
        }
        return binaryRec(arr, mid + 1, end, target);
    }

    static int lowerBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}
