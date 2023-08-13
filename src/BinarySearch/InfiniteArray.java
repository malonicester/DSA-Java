package BinarySearch;

public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 7, 8, 10, 11, 12, 15, 20, 23, 30};
        int ans = findingAns(arr,3);
        System.out.println(ans);
    }

    static int findingAns(int[] arr, int target) {
        int start = 0;
        int end = 1;
//        this will narrow the search space where the target can exist so that we will be performing the search only once
        while ( end < arr.length && target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return infiniteSort(arr, target, start, end);
    }

    static int infiniteSort(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
