package BinarySearch;


public class SearchRotatedInArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int ans = searchInRoatedArray(arr, 4);
        System.out.println(ans);
    }

    static int searchInRoatedArray(int[] arr, int target) {
        int pivot = findPivot(arr);
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

    static int findPivot(int[] arr) {
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
            if(arr[mid]<=arr[start]){
                end = mid - 1;
            }else{
                start = mid + 1;
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
